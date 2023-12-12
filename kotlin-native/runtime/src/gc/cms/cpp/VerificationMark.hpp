/*
 * Copyright 2010-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

#include <vector>
#include "MarkAndSweepUtils.hpp"

namespace kotlin::gc {

struct VerificationMarkTraits {
    using MarkQueue = std::vector<GC::ObjectData*>;

    static void clear(MarkQueue& queue) noexcept { queue.clear(); }

    static bool tryMark(ObjHeader* object) noexcept {
        auto& objectData = alloc::objectDataForObject(object);
        if (objectData.markIsVerified()) return false;
        RuntimeCheck(objectData.marked(), "Verification mark found an unmarked object %p", object);
        objectData.remarkVerified();
        return true;
    }

    static ObjHeader* tryDequeue(MarkQueue& queue) noexcept {
        if (queue.empty()) return nullptr;
        auto top = queue.back();
        queue.pop_back();
        return alloc::objectForObjectData(*top);
    }

    static bool tryEnqueue(MarkQueue& queue, ObjHeader* object) noexcept {
        auto& objectData = alloc::objectDataForObject(object);
        if (objectData.markIsVerified()) return false;
        RuntimeCheck(objectData.marked(), "Verification mark found an unmarked object %p", object);
        objectData.remarkVerified();
        queue.push_back(&alloc::objectDataForObject(object));
        return true;
    }

    static void processInMark(MarkQueue& markQueue, ObjHeader* object) noexcept {
        // just checking
        auto process = object->type_info()->processObjectInMark;
        RuntimeCheck(process != nullptr, "Got null processObjectInMark for object %p", object);

        if (object->type_info() == theArrayTypeInfo) {
            internal::processArrayInMark<VerificationMarkTraits>(&markQueue, object->array());
        } else {
            internal::processObjectInMark<VerificationMarkTraits>(&markQueue, object);
        }
    }
};

// must be called inside STW
inline void checkAllAliveObjectsMarked() {
    if (!compiler::gcCheckMarkCorrectness()) return;

    auto fakeHandle = GCHandle::createFakeForTests();
    VerificationMarkTraits::MarkQueue markQueue;
    gc::collectRootSet<VerificationMarkTraits>(fakeHandle, markQueue, [](mm::ThreadData&) { return true; });
    gc::Mark<VerificationMarkTraits>(fakeHandle, markQueue);
}

}
