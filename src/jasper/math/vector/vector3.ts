import { Constructor } from "../../util/types";
import { dot3 } from "./ops/dot";
import { mag3 } from "./ops/mag";
import { Vector } from "./vector";

export abstract class Vector3<T extends Vector.Type> extends Vector.Variant<T, 3> {
  constructor(T: Constructor<T>, x ?: number, y ?: number, z ?: number) {
    super(T, 3); 
    Vector.__set__.xyz(this, x, y, z);
  }

  dot(b: number | Vector = this) { return dot3(this, b); }
  mag(                         ) { return mag3(this   ); }
}

export class Vector3f extends Vector3<Float32Array> {
  constructor(x ?: number, y ?: number, z ?: number) {
    super(Float32Array, x, y, z);
  }

  static readonly Mutable = Vector.Mutable(Vector3f);
}

export class Vector3u extends Vector3<Uint32Array> {
  constructor(x ?: number, y ?: number, z ?: number) {
    super(Uint32Array, x, y, z);
  }

  static readonly Mutable = Vector.Mutable(Vector3u);
}

export class Vector3i extends Vector3<Int32Array> {
  constructor(x ?: number, y ?: number, z ?: number) {
    super(Int32Array, x, y, z);
  }

  static readonly Mutable = Vector.Mutable(Vector3i);
}

export namespace Vector3f {
  export type Mutable = InstanceType<typeof Vector3f.Mutable>;
}

export namespace Vector3u {
  export type Mutable = InstanceType<typeof Vector3u.Mutable>;
}

export namespace Vector3i {
  export type Mutable = InstanceType<typeof Vector3i.Mutable>;
}