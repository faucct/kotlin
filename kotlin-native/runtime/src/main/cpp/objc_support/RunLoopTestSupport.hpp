/*
 * Copyright 2010-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

#pragma once

#if KONAN_HAS_FOUNDATION_FRAMEWORK

#include <atomic>
#include <CoreFoundation/CFRunLoop.h>

#include "ScopedThread.hpp"
#include "Utils.hpp"
#include "objc_support/ObjectPtr.hpp"

namespace kotlin::objc_support::test_support {

class RunLoopInScopedThread : private Pinned {
public:
    template <typename Init>
    explicit RunLoopInScopedThread(Init init) noexcept :
        thread_([&]() noexcept {
            [[maybe_unused]] auto state = init();
            runLoop_.reset(object_ptr_retain, CFRunLoopGetCurrent());
            RuntimeAssert(*runLoop_ != nullptr, "Current run loop cannot be null");
            changeState(State::kInitial, State::kRunning);
            while (state_.load(std::memory_order_relaxed) == State::kRunning) {
                CFRunLoopRun();
            }
            changeState(State::kWillStop, State::kStopped);
            RuntimeAssert(*runLoop_ == nullptr, "Stored run loop must have been nulled");
        }) {
        while (state_.load(std::memory_order_relaxed) < State::kRunning) {
        }
        std::atomic_thread_fence(std::memory_order_acquire);
    }

    ~RunLoopInScopedThread() {
        object_ptr<CFRunLoopRef> runLoop = std::move(runLoop_);
        changeState(State::kRunning, State::kWillStop);
        CFRunLoopStop(*runLoop);
    }

    CFRunLoopRef handle() noexcept { return *runLoop_; }

    void wakeUp() noexcept { CFRunLoopWakeUp(*runLoop_); }

    void schedule(std::function<void()> f) noexcept {
        CFRunLoopPerformBlock(*runLoop_, kCFRunLoopDefaultMode, ^{
            f();
        });
        CFRunLoopWakeUp(*runLoop_);
    }

private:
    enum class State {
        kInitial,
        kRunning,
        kWillStop,
        kStopped,
    };

    void changeState(State expected, State desired) noexcept {
        auto actual = expected;
        state_.compare_exchange_strong(actual, desired, std::memory_order_acq_rel);
        RuntimeAssert(actual == expected, "Expected state to be %d but was %d", expected, actual);
    }

    object_ptr<CFRunLoopRef> runLoop_;
    std::atomic<State> state_ = State::kInitial;
    ScopedThread thread_;
};

} // namespace kotlin::objc_support::test_support

#endif