import { Vector } from "../vector";
import { Vector2f, Vector2i, Vector2u } from "../vector2";
import { Vector3f, Vector3i, Vector3u } from "../vector3";
import { Vector4f, Vector4i, Vector4u } from "../vector4";
import { out2f, out2i, out2u, out3f, out3i, out3u, out4f, out4i, out4u } from "./out";

export function add2f(a: number | Vector, b: number | Vector, out ?: Vector2f.Mutable): Vector2f {
  if (typeof a === "number") if (typeof b === "number") return add2f.numberNumber(a, b, out);
                             else                       return add2f.numberVector(a, b, out);
  else                       if (typeof b === "number") return add2f.vectorNumber(a, b, out);
                             else                       return add2f.vectorVector(a, b, out);
}

add2f.numberNumber = function(a: number, b: number, out ?: Vector2f.Mutable) {
  return out2f(out,
    a + b, 
    a + b
  );
}

add2f.numberVector = function (a: number, b: Vector, out ?: Vector2f.Mutable) {
  return out2f(out,
    a + b.x,
    a + b.y,
  );
}

add2f.vectorNumber = function(a: Vector, b: number, out ?: Vector2f.Mutable) {
  return out2f(out,
    a.x + b,
    a.y + b,
  )
}

add2f.vectorVector = function(a: Vector, b: Vector, out ?: Vector2f.Mutable) {
  return out2f(out,
    a.x + b.x,
    a.y + b.y,
  )
}

export function add2u(a: number | Vector, b: number | Vector, out ?: Vector2u.Mutable): Vector2u {
  if (typeof a === "number") if (typeof b === "number") return add2u.numberNumber(a, b, out);
                             else                       return add2u.numberVector(a, b, out);
  else                       if (typeof b === "number") return add2u.vectorNumber(a, b, out);
                             else                       return add2u.vectorVector(a, b, out);
}

add2u.numberNumber = function(a: number, b: number, out ?: Vector2u.Mutable) {
  return out2u(out,
    a + b, 
    a + b
  );
}

add2u.numberVector = function (a: number, b: Vector, out ?: Vector2u.Mutable) {
  return out2u(out,
    a + b.x,
    a + b.y,
  );
}

add2u.vectorNumber = function(a: Vector, b: number, out ?: Vector2u.Mutable) {
  return out2u(out,
    a.x + b,
    a.y + b,
  )
}

add2u.vectorVector = function(a: Vector, b: Vector, out ?: Vector2u.Mutable) {
  return out2u(out,
    a.x + b.x,
    a.y + b.y,
  )
}

export function add2i(a: number | Vector, b: number | Vector, out ?: Vector2i.Mutable): Vector2i {
  if (typeof a === "number") if (typeof b === "number") return add2i.numberNumber(a, b, out);
                             else                       return add2i.numberVector(a, b, out);
  else                       if (typeof b === "number") return add2i.vectorNumber(a, b, out);
                             else                       return add2i.vectorVector(a, b, out);
}

add2i.numberNumber = function(a: number, b: number, out ?: Vector2i.Mutable) {
  return out2i(out,
    a + b, 
    a + b
  );
}

add2i.numberVector = function (a: number, b: Vector, out ?: Vector2i.Mutable) {
  return out2i(out,
    a + b.x,
    a + b.y,
  );
}

add2i.vectorNumber = function(a: Vector, b: number, out ?: Vector2i.Mutable) {
  return out2i(out,
    a.x + b,
    a.y + b,
  )
}

add2i.vectorVector = function(a: Vector, b: Vector, out ?: Vector2i.Mutable) {
  return Vector.__set__.xy(out ?? new Vector2i(), 
    a.x + b.x, 
    a.y + b.y
  );
}

export function add3f(a: number | Vector, b: number | Vector, out ?: Vector3f.Mutable): Vector3f {
  if (typeof a === "number") if (typeof b === "number") return add3f.numberNumber(a, b, out);
                             else                       return add3f.numberVector(a, b, out);
  else                       if (typeof b === "number") return add3f.vectorNumber(a, b, out);
                             else                       return add3f.vectorVector(a, b, out);
}

add3f.numberNumber = function(a: number, b: number, out ?: Vector3f.Mutable) {
  return out3f(out,
    a + b, 
    a + b,
    a + b
  );
}

add3f.numberVector = function (a: number, b: Vector, out ?: Vector3f.Mutable) {
  return out3f(out,
    a + b.x,
    a + b.y,
    a + b.z,
  );
}

add3f.vectorNumber = function(a: Vector, b: number, out ?: Vector3f.Mutable) {
  return out3f(out,
    a.x + b,
    a.y + b,
    a.z + b,
  )
}

add3f.vectorVector = function(a: Vector, b: Vector, out ?: Vector3f.Mutable) {
  return out3f(out,
    a.x + b.x,
    a.y + b.y,
    a.z + b.z,
  )
}

export function add3u(a: number | Vector, b: number | Vector, out ?: Vector3u.Mutable): Vector3u {
  if (typeof a === "number") if (typeof b === "number") return add3u.numberNumber(a, b, out);
                             else                       return add3u.numberVector(a, b, out);
  else                       if (typeof b === "number") return add3u.vectorNumber(a, b, out);
                             else                       return add3u.vectorVector(a, b, out);
}

add3u.numberNumber = function(a: number, b: number, out ?: Vector3u.Mutable) {
  return out3u(out,
    a + b, 
    a + b,
    a + b
  );
}

add3u.numberVector = function (a: number, b: Vector, out ?: Vector3u.Mutable) {
  return out3u(out,
    a + b.x,
    a + b.y,
    a + b.z,
  );
}

add3u.vectorNumber = function(a: Vector, b: number, out ?: Vector3u.Mutable) {
  return out3u(out,
    a.x + b,
    a.y + b,
    a.z + b,
  )
}

add3u.vectorVector = function(a: Vector, b: Vector, out ?: Vector3u.Mutable) {
  return out3u(out,
    a.x + b.x,
    a.y + b.y,
    a.z + b.z,
  )
}

export function add3i(a: number | Vector, b: number | Vector, out ?: Vector3i.Mutable): Vector3i {
  if (typeof a === "number") if (typeof b === "number") return add3i.numberNumber(a, b, out);
                             else                       return add3i.numberVector(a, b, out);
  else                       if (typeof b === "number") return add3i.vectorNumber(a, b, out);
                             else                       return add3i.vectorVector(a, b, out);
}

add3i.numberNumber = function(a: number, b: number, out ?: Vector3i.Mutable) {
  return out3i(out,
    a + b, 
    a + b,
    a + b
  );
}

add3i.numberVector = function (a: number, b: Vector, out ?: Vector3i.Mutable) {
  return out3i(out,
    a + b.x,
    a + b.y,
    a + b.z,
  );
}

add3i.vectorNumber = function(a: Vector, b: number, out ?: Vector3i.Mutable) {
  return out3i(out,
    a.x + b,
    a.y + b,
    a.z + b,
  )
}

add3i.vectorVector = function(a: Vector, b: Vector, out ?: Vector3i.Mutable) {
  return out3i(out,
    a.x + b.x,
    a.y + b.y,
    a.z + b.z,
  )
}

export function add4f(a: number | Vector, b: number | Vector, out ?: Vector4f.Mutable): Vector4f {
  if (typeof a === "number") if (typeof b === "number") return add4f.numberNumber(a, b, out);
                             else                       return add4f.numberVector(a, b, out);
  else                       if (typeof b === "number") return add4f.vectorNumber(a, b, out);
                             else                       return add4f.vectorVector(a, b, out);
}

add4f.numberNumber = function(a: number, b: number, out ?: Vector4f.Mutable) {
  return out4f(out,
    a + b, 
    a + b,
    a + b,
    a + b
  );
}

add4f.numberVector = function (a: number, b: Vector, out ?: Vector4f.Mutable) {
  return out4f(out,
    a + b.x,
    a + b.y,
    a + b.z,
    a + b.w,
  );
}

add4f.vectorNumber = function(a: Vector, b: number, out ?: Vector4f.Mutable) {
  return out4f(out,
    a.x + b,
    a.y + b,
    a.z + b,
    a.w + b,
  )
}

add4f.vectorVector = function(a: Vector, b: Vector, out ?: Vector4f.Mutable) {
  return out4f(out,
    a.x + b.x,
    a.y + b.y,
    a.z + b.z,
    a.w + b.w,
  )
}

export function add4u(a: number | Vector, b: number | Vector, out ?: Vector4u.Mutable): Vector4u {
  if (typeof a === "number") if (typeof b === "number") return add4u.numberNumber(a, b, out);
                             else                       return add4u.numberVector(a, b, out);
  else                       if (typeof b === "number") return add4u.vectorNumber(a, b, out);
                             else                       return add4u.vectorVector(a, b, out);
}

add4u.numberNumber = function(a: number, b: number, out ?: Vector4u.Mutable) {
  return out4u(out,
    a + b, 
    a + b,
    a + b,
    a + b
  );
}

add4u.numberVector = function (a: number, b: Vector, out ?: Vector4u.Mutable) {
  return out4u(out,
    a + b.x,
    a + b.y,
    a + b.z,
    a + b.w,
  );
}

add4u.vectorNumber = function(a: Vector, b: number, out ?: Vector4u.Mutable) {
  return out4u(out,
    a.x + b,
    a.y + b,
    a.z + b,
    a.w + b,
  )
}

add4u.vectorVector = function(a: Vector, b: Vector, out ?: Vector4u.Mutable) {
  return out4u(out,
    a.x + b.x,
    a.y + b.y,
    a.z + b.z,
    a.w + b.w,
  )
}

export function add4i(a: number | Vector, b: number | Vector, out ?: Vector4i.Mutable): Vector4i {
  if (typeof a === "number") if (typeof b === "number") return add4i.numberNumber(a, b, out);
                             else                       return add4i.numberVector(a, b, out);
  else                       if (typeof b === "number") return add4i.vectorNumber(a, b, out);
                             else                       return add4i.vectorVector(a, b, out);
}

add4i.numberNumber = function(a: number, b: number, out ?: Vector4i.Mutable) {
  return out4i(out,
    a + b, 
    a + b,
    a + b,
    a + b
  );
}

add4i.numberVector = function (a: number, b: Vector, out ?: Vector4i.Mutable) {
  return out4i(out,
    a + b.x,
    a + b.y,
    a + b.z,
    a + b.w,
  );
}

add4i.vectorNumber = function(a: Vector, b: number, out ?: Vector4i.Mutable) {
  return out4i(out,
    a.x + b,
    a.y + b,
    a.z + b,
    a.w + b,
  )
}

add4i.vectorVector = function(a: Vector, b: Vector, out ?: Vector4i.Mutable) {
  return out4i(out,
    a.x + b.x,
    a.y + b.y,
    a.z + b.z,
    a.w + b.w,
  )
}