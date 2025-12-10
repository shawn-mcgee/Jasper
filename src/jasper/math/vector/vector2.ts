import { Constructor } from "../../util/types";
import { dot2  } from "./ops/dot";
import { mag2  } from "./ops/mag";
import { add2f, add2i, add2u } from "./ops/add";
import { sub2f, sub2i, sub2u } from "./ops/sub";
import { Vector } from "./vector";

export abstract class Vector2<T extends Vector.Type> extends Vector.Variant<T, 2> {
  constructor(T: Constructor<T>, x ?: number, y ?: number) {
    super(T, 2);
    Vector.__set__.xy(this, x, y);
  }

  dot(b: number | Vector = this) { return dot2(this, b); }
  mag(                         ) { return mag2(this   ); }

  add2f(b: number | Vector = this) { return add2f(this, b); }
  add2i(b: number | Vector = this) { return add2i(this, b); }
  add2u(b: number | Vector = this) { return add2u(this, b); }

  sub2f(b: number | Vector = this) { return sub2f(this, b); }
  sub2i(b: number | Vector = this) { return sub2i(this, b); }
  sub2u(b: number | Vector = this) { return sub2u(this, b); }
}

export class Vector2f extends Vector2<Float32Array> {
  constructor(x ?: number, y ?: number) {
    super(Float32Array, x, y);
  }

  static readonly Mutable = Vector.Mutable(Vector2f);
}

export class Vector2u extends Vector2<Uint32Array> {
  constructor(x ?: number, y ?: number) {
    super(Uint32Array, x, y);
  }

  static readonly Mutable = Vector.Mutable(Vector2u);
}

export class Vector2i extends Vector2<Int32Array> {
  constructor(x ?: number, y ?: number) {
    super(Int32Array, x, y);
  }

  static readonly Mutable = Vector.Mutable(Vector2i);
}

export namespace Vector2f {
  export type Mutable = InstanceType<typeof Vector2f.Mutable>;
}

export namespace Vector2u {
  export type Mutable = InstanceType<typeof Vector2u.Mutable>;
}

export namespace Vector2i {
  export type Mutable = InstanceType<typeof Vector2i.Mutable>;
}
