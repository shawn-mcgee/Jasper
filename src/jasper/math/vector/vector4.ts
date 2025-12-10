import { Constructor } from "../../util/types";
import { dot4 } from "./ops/dot";
import { mag4 } from "./ops/mag";
import { Vector } from "./vector";

export class Vector4<T extends Vector.Type> extends Vector.Variant<T, 4> {
  constructor(T: Constructor<T>, x ?: number, y ?: number, z ?: number, w ?: number) {
    super(T, 4);
    Vector.__set__.xyzw(this, x, y, z, w);
  }

  dot(b: number | Vector = this) { return dot4(this, b); }
  mag(                         ) { return mag4(this   ); }
}

export class Vector4f extends Vector4<Float32Array> {
  constructor(x ?: number, y ?: number, z ?: number, w ?: number) {
    super(Float32Array, x, y, z, w);
  }

  static readonly Mutable = Vector.Mutable(Vector4f);
}

export class Vector4u extends Vector4<Uint32Array> {
  constructor(x ?: number, y ?: number, z ?: number, w ?: number) {
    super(Uint32Array, x, y, z, w);
  }

  static readonly Mutable = Vector.Mutable(Vector4u);
}

export class Vector4i extends Vector4<Int32Array> {
  constructor(x ?: number, y ?: number, z ?: number, w ?: number) {
    super(Int32Array, x, y, z, w);
  }

  static readonly Mutable = Vector.Mutable(Vector4i);
}

export namespace Vector4f {
  export type Mutable = InstanceType<typeof Vector4f.Mutable>;
}

export namespace Vector4u {
  export type Mutable = InstanceType<typeof Vector4u.Mutable>;
}

export namespace Vector4i {
  export type Mutable = InstanceType<typeof Vector4i.Mutable>;
}