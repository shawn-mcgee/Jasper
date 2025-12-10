import { Constructor } from "../../util/types";

export interface Vector extends Iterable<number> {
  get x(): number;
  get y(): number;
  get z(): number;
  get w(): number;
}

export namespace Vector {
  export type Type = Float32Array | Uint32Array | Int32Array;
  export type Size = 2 | 3 | 4;

  export interface OfType<T extends Type> {
    readonly __buffer__: T;
  }

  export interface OfSize<N extends Size> {
    get n(): N;
  }

  export interface Mutable extends Vector {
    set x(x: number);
    set y(y: number);
    set z(z: number);
    set w(w: number);
  }
}

export const __get__ = {
  x(a: Vector.OfType<any>) { return a.__buffer__[0] ?? 0; },
  y(a: Vector.OfType<any>) { return a.__buffer__[1] ?? 0; },
  z(a: Vector.OfType<any>) { return a.__buffer__[2] ?? 0; },
  w(a: Vector.OfType<any>) { return a.__buffer__[3] ?? 0; },
  n(a: Vector.OfType<any>) { return a.__buffer__.length;  },
} as const;

export const __set__ = {
  x(a: Vector.OfType<any>, x: number) { a.__buffer__[0] = x; },
  y(a: Vector.OfType<any>, y: number) { a.__buffer__[1] = y; },
  z(a: Vector.OfType<any>, z: number) { a.__buffer__[2] = z; },
  w(a: Vector.OfType<any>, w: number) { a.__buffer__[3] = w; },

  xy<T extends Vector.OfType<any>>(a: T, x ?: number, y ?: number) {
    const buffer = a.__buffer__;
    if (y === undefined) {
      x = x ?? 0;
      buffer[0] = x;
      buffer[1] = x;
    } else {
      buffer[0] = x ?? 0;
      buffer[1] = y ?? 0;
    }
    return a;
  },
  xyz<T extends Vector.OfType<any>>(a: T, x=0, y=x||0, z=y||0) {
    const buffer = a.__buffer__;
    if (
      y === undefined && 
      z === undefined
    ) {
      x = x ?? 0;
      buffer[0] = x;
      buffer[1] = x;
      buffer[2] = x;
    } else {
      buffer[0] = x ?? 0;
      buffer[1] = y ?? 0;
      buffer[2] = z ?? 0;
    }
    return a;
  },
  xyzw<T extends Vector.OfType<any>>(a: T, x=0, y=x, z=x, w=x) {
    const buffer = a.__buffer__;
    if (
      y === undefined && 
      z === undefined && 
      w === undefined
    ) {
      x = x ?? 0;
      buffer[0] = x;
      buffer[1] = x;
      buffer[2] = x;
      buffer[3] = x;
    } else {
      buffer[0] = x ?? 0;
      buffer[1] = y ?? 0;
      buffer[2] = z ?? 0;
      buffer[3] = w ?? 0;
    }
    return a;
  },
} as const;

export abstract class Variant<T extends Vector.Type, N extends Vector.Size>  {
  readonly __buffer__: T;

  constructor(T: Constructor<T>, n: N) {
    this.__buffer__ = new T(n);
  }

  get x(): number { return __get__.x(this); }
  get y(): number { return __get__.y(this); }
  get z(): number { return __get__.z(this); }
  get w(): number { return __get__.w(this); }
  get n(): N      { return __get__.n(this); }

  [Symbol.iterator](): Iterator<number> {
    return this.__buffer__.values();
  }
}

export function Mutable<T extends Vector.Type, N extends Vector.Size, V extends Constructor<Variant<T, N>>>(Variant: V){
  return class Mutable extends Variant implements Vector.Mutable {
    set x(x: number) { __set__.x(this, x); }
    set y(y: number) { __set__.y(this, y); }
    set z(z: number) { __set__.z(this, z); }
    set w(w: number) { __set__.w(this, w); }
  }
}

export const Vector = {
  __get__,
  __set__,
  Variant,
  Mutable
}