type Nullable<T> = T | null | undefined
export declare function makeC(x: number): unknown;
export declare function getX(c: unknown): number;
export declare function getString(s: string): string;
export declare function isEven(x: number): boolean;
export declare function eiAsAny(ei: not.exported.EI): unknown;
export declare function anyAsEI(any: unknown): not.exported.EI;
export declare function provideUByte(): number;
export declare function provideNullableUByte(nullable: boolean): Nullable<number>;
export declare function consumeUByte(x: number): string;
export declare function consumeNullableUByte(x: Nullable<number>): Nullable<string>;
export declare function provideUShort(): number;
export declare function provideNullableUShort(nullable: boolean): Nullable<number>;
export declare function consumeUShort(x: number): string;
export declare function consumeNullableUShort(x: Nullable<number>): Nullable<string>;
export declare function provideUInt(): number;
export declare function provideNullableUInt(nullable: boolean): Nullable<number>;
export declare function consumeUInt(x: number): string;
export declare function consumeNullableUInt(x: Nullable<number>): Nullable<string>;
export declare function provideULong(): bigint;
export declare function provideNullableULong(nullable: boolean): Nullable<bigint>;
export declare function consumeULong(x: bigint): string;
export declare function consumeNullableULong(x: Nullable<bigint>): Nullable<string>;
export declare function box(): string;
namespace not.exported {
    interface EI {
    }
}