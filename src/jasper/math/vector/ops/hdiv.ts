import { Vector } from "../vector";
import { Vector2f, Vector2i, Vector2u } from "../vector2";
import { Vector3f, Vector3i, Vector3u } from "../vector3";
import { Vector4f, Vector4i, Vector4u } from "../vector4";
import { out2f, out2i, out2u, out3f, out3i, out3u, out4f, out4i, out4u } from "./out";

export function hdiv2f(a: number | Vector, b: number | Vector, out ?: Vector2f.Mutable): Vector2f {
  if (typeof a === "number") if (typeof b === "number") return hdiv2f.numberNumber(a, b, out);
                             else                       return hdiv2f.numberVector(a, b, out);
  else                       if (typeof b === "number") return hdiv2f.vectorNumber(a, b, out);
                             else                       return hdiv2f.vectorVector(a, b, out);
}

hdiv2f.numberNumber = function(a: number, b: number, out ?: Vector2f.Mutable) {
  return out2f(out,
    a / b, 
    a / b
  );
}

hdiv2f.numberVector = function (a: number, b: Vector, out ?: Vector2f.Mutable) {
  return out2f(out,
    a / b.x,
    a / b.y,
  );
}

hdiv2f.vectorNumber = function(a: Vector, b: number, out ?: Vector2f.Mutable) {
  return out2f(out,
    a.x / b,
    a.y / b,
  )
}

hdiv2f.vectorVector = function(a: Vector, b: Vector, out ?: Vector2f.Mutable) {
  return out2f(out,
    a.x / b.x,
    a.y / b.y,
  )
}

export function hdiv2u(a: number | Vector, b: number | Vector, out ?: Vector2u.Mutable): Vector2u {
  if (typeof a === "number") if (typeof b === "number") return hdiv2u.numberNumber(a, b, out);
                             else                       return hdiv2u.numberVector(a, b, out);
  else                       if (typeof b === "number") return hdiv2u.vectorNumber(a, b, out);
                             else                       return hdiv2u.vectorVector(a, b, out);
}

hdiv2u.numberNumber = function(a: number, b: number, out ?: Vector2u.Mutable) {
  return out2u(out,
    a / b, 
    a / b
  );
}

hdiv2u.numberVector = function (a: number, b: Vector, out ?: Vector2u.Mutable) {
  return out2u(out,
    a / b.x,
    a / b.y,
  );
}

hdiv2u.vectorNumber = function(a: Vector, b: number, out ?: Vector2u.Mutable) {
  return out2u(out,
    a.x / b,
    a.y / b,
  )
}

hdiv2u.vectorVector = function(a: Vector, b: Vector, out ?: Vector2u.Mutable) {
  return out2u(out,
    a.x / b.x,
    a.y / b.y,
  )
}

export function hdiv2i(a: number | Vector, b: number | Vector, out ?: Vector2i.Mutable): Vector2i {
  if (typeof a === "number") if (typeof b === "number") return hdiv2i.numberNumber(a, b, out);
                             else                       return hdiv2i.numberVector(a, b, out);
  else                       if (typeof b === "number") return hdiv2i.vectorNumber(a, b, out);
                             else                       return hdiv2i.vectorVector(a, b, out);
}

hdiv2i.numberNumber = function(a: number, b: number, out ?: Vector2i.Mutable) {
  return out2i(out,
    a / b, 
    a / b
  );
}

hdiv2i.numberVector = function (a: number, b: Vector, out ?: Vector2i.Mutable) {
  return out2i(out,
    a / b.x,
    a / b.y,
  );
}

hdiv2i.vectorNumber = function(a: Vector, b: number, out ?: Vector2i.Mutable) {
  return out2i(out,
    a.x / b,
    a.y / b,
  )
}

hdiv2i.vectorVector = function(a: Vector, b: Vector, out ?: Vector2i.Mutable) {
  return Vector.__set__.xy(out ?? new Vector2i(), 
    a.x / b.x, 
    a.y / b.y
  );
}

export function hdiv3f(a: number | Vector, b: number | Vector, out ?: Vector3f.Mutable): Vector3f {
  if (typeof a === "number") if (typeof b === "number") return hdiv3f.numberNumber(a, b, out);
                             else                       return hdiv3f.numberVector(a, b, out);
  else                       if (typeof b === "number") return hdiv3f.vectorNumber(a, b, out);
                             else                       return hdiv3f.vectorVector(a, b, out);
}

hdiv3f.numberNumber = function(a: number, b: number, out ?: Vector3f.Mutable) {
  return out3f(out,
    a / b, 
    a / b,
    a / b
  );
}

hdiv3f.numberVector = function (a: number, b: Vector, out ?: Vector3f.Mutable) {
  return out3f(out,
    a / b.x,
    a / b.y,
    a / b.z,
  );
}

hdiv3f.vectorNumber = function(a: Vector, b: number, out ?: Vector3f.Mutable) {
  return out3f(out,
    a.x / b,
    a.y / b,
    a.z / b,
  )
}

hdiv3f.vectorVector = function(a: Vector, b: Vector, out ?: Vector3f.Mutable) {
  return out3f(out,
    a.x / b.x,
    a.y / b.y,
    a.z / b.z,
  )
}

export function hdiv3u(a: number | Vector, b: number | Vector, out ?: Vector3u.Mutable): Vector3u {
  if (typeof a === "number") if (typeof b === "number") return hdiv3u.numberNumber(a, b, out);
                             else                       return hdiv3u.numberVector(a, b, out);
  else                       if (typeof b === "number") return hdiv3u.vectorNumber(a, b, out);
                             else                       return hdiv3u.vectorVector(a, b, out);
}

hdiv3u.numberNumber = function(a: number, b: number, out ?: Vector3u.Mutable) {
  return out3u(out,
    a / b, 
    a / b,
    a / b
  );
}

hdiv3u.numberVector = function (a: number, b: Vector, out ?: Vector3u.Mutable) {
  return out3u(out,
    a / b.x,
    a / b.y,
    a / b.z,
  );
}

hdiv3u.vectorNumber = function(a: Vector, b: number, out ?: Vector3u.Mutable) {
  return out3u(out,
    a.x / b,
    a.y / b,
    a.z / b,
  )
}

hdiv3u.vectorVector = function(a: Vector, b: Vector, out ?: Vector3u.Mutable) {
  return out3u(out,
    a.x / b.x,
    a.y / b.y,
    a.z / b.z,
  )
}

export function hdiv3i(a: number | Vector, b: number | Vector, out ?: Vector3i.Mutable): Vector3i {
  if (typeof a === "number") if (typeof b === "number") return hdiv3i.numberNumber(a, b, out);
                             else                       return hdiv3i.numberVector(a, b, out);
  else                       if (typeof b === "number") return hdiv3i.vectorNumber(a, b, out);
                             else                       return hdiv3i.vectorVector(a, b, out);
}

hdiv3i.numberNumber = function(a: number, b: number, out ?: Vector3i.Mutable) {
  return out3i(out,
    a / b, 
    a / b,
    a / b
  );
}

hdiv3i.numberVector = function (a: number, b: Vector, out ?: Vector3i.Mutable) {
  return out3i(out,
    a / b.x,
    a / b.y,
    a / b.z,
  );
}

hdiv3i.vectorNumber = function(a: Vector, b: number, out ?: Vector3i.Mutable) {
  return out3i(out,
    a.x / b,
    a.y / b,
    a.z / b,
  )
}

hdiv3i.vectorVector = function(a: Vector, b: Vector, out ?: Vector3i.Mutable) {
  return out3i(out,
    a.x / b.x,
    a.y / b.y,
    a.z / b.z,
  )
}

export function hdiv4f(a: number | Vector, b: number | Vector, out ?: Vector4f.Mutable): Vector4f {
  if (typeof a === "number") if (typeof b === "number") return hdiv4f.numberNumber(a, b, out);
                             else                       return hdiv4f.numberVector(a, b, out);
  else                       if (typeof b === "number") return hdiv4f.vectorNumber(a, b, out);
                             else                       return hdiv4f.vectorVector(a, b, out);
}

hdiv4f.numberNumber = function(a: number, b: number, out ?: Vector4f.Mutable) {
  return out4f(out,
    a / b, 
    a / b,
    a / b,
    a / b
  );
}

hdiv4f.numberVector = function (a: number, b: Vector, out ?: Vector4f.Mutable) {
  return out4f(out,
    a / b.x,
    a / b.y,
    a / b.z,
    a / b.w,
  );
}

hdiv4f.vectorNumber = function(a: Vector, b: number, out ?: Vector4f.Mutable) {
  return out4f(out,
    a.x / b,
    a.y / b,
    a.z / b,
    a.w / b,
  )
}

hdiv4f.vectorVector = function(a: Vector, b: Vector, out ?: Vector4f.Mutable) {
  return out4f(out,
    a.x / b.x,
    a.y / b.y,
    a.z / b.z,
    a.w / b.w,
  )
}

export function hdiv4u(a: number | Vector, b: number | Vector, out ?: Vector4u.Mutable): Vector4u {
  if (typeof a === "number") if (typeof b === "number") return hdiv4u.numberNumber(a, b, out);
                             else                       return hdiv4u.numberVector(a, b, out);
  else                       if (typeof b === "number") return hdiv4u.vectorNumber(a, b, out);
                             else                       return hdiv4u.vectorVector(a, b, out);
}

hdiv4u.numberNumber = function(a: number, b: number, out ?: Vector4u.Mutable) {
  return out4u(out,
    a / b, 
    a / b,
    a / b,
    a / b
  );
}

hdiv4u.numberVector = function (a: number, b: Vector, out ?: Vector4u.Mutable) {
  return out4u(out,
    a / b.x,
    a / b.y,
    a / b.z,
    a / b.w,
  );
}

hdiv4u.vectorNumber = function(a: Vector, b: number, out ?: Vector4u.Mutable) {
  return out4u(out,
    a.x / b,
    a.y / b,
    a.z / b,
    a.w / b,
  )
}

hdiv4u.vectorVector = function(a: Vector, b: Vector, out ?: Vector4u.Mutable) {
  return out4u(out,
    a.x / b.x,
    a.y / b.y,
    a.z / b.z,
    a.w / b.w,
  )
}

export function hdiv4i(a: number | Vector, b: number | Vector, out ?: Vector4i.Mutable): Vector4i {
  if (typeof a === "number") if (typeof b === "number") return hdiv4i.numberNumber(a, b, out);
                             else                       return hdiv4i.numberVector(a, b, out);
  else                       if (typeof b === "number") return hdiv4i.vectorNumber(a, b, out);
                             else                       return hdiv4i.vectorVector(a, b, out);
}

hdiv4i.numberNumber = function(a: number, b: number, out ?: Vector4i.Mutable) {
  return out4i(out,
    a / b, 
    a / b,
    a / b,
    a / b
  );
}

hdiv4i.numberVector = function (a: number, b: Vector, out ?: Vector4i.Mutable) {
  return out4i(out,
    a / b.x,
    a / b.y,
    a / b.z,
    a / b.w,
  );
}

hdiv4i.vectorNumber = function(a: Vector, b: number, out ?: Vector4i.Mutable) {
  return out4i(out,
    a.x / b,
    a.y / b,
    a.z / b,
    a.w / b,
  )
}

hdiv4i.vectorVector = function(a: Vector, b: Vector, out ?: Vector4i.Mutable) {
  return out4i(out,
    a.x / b.x,
    a.y / b.y,
    a.z / b.z,
    a.w / b.w,
  )
}