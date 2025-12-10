import { Vector } from "../vector";
import { Vector2f, Vector2i, Vector2u } from "../vector2";
import { Vector3f, Vector3i, Vector3u } from "../vector3";
import { Vector4f, Vector4i, Vector4u } from "../vector4";
import { out2f, out2i, out2u, out3f, out3i, out3u, out4f, out4i, out4u } from "./out";

export function hmul2f(a: number | Vector, b: number | Vector, out ?: Vector2f.Mutable): Vector2f {
  if (typeof a === "number") if (typeof b === "number") return hmul2f.numberNumber(a, b, out);
                             else                       return hmul2f.numberVector(a, b, out);
  else                       if (typeof b === "number") return hmul2f.vectorNumber(a, b, out);
                             else                       return hmul2f.vectorVector(a, b, out);
}

hmul2f.numberNumber = function(a: number, b: number, out ?: Vector2f.Mutable) {
  return out2f(out,
    a * b, 
    a * b
  );
}

hmul2f.numberVector = function (a: number, b: Vector, out ?: Vector2f.Mutable) {
  return out2f(out,
    a * b.x,
    a * b.y,
  );
}

hmul2f.vectorNumber = function(a: Vector, b: number, out ?: Vector2f.Mutable) {
  return out2f(out,
    a.x * b,
    a.y * b,
  )
}

hmul2f.vectorVector = function(a: Vector, b: Vector, out ?: Vector2f.Mutable) {
  return out2f(out,
    a.x * b.x,
    a.y * b.y,
  )
}

export function hmul2u(a: number | Vector, b: number | Vector, out ?: Vector2u.Mutable): Vector2u {
  if (typeof a === "number") if (typeof b === "number") return hmul2u.numberNumber(a, b, out);
                             else                       return hmul2u.numberVector(a, b, out);
  else                       if (typeof b === "number") return hmul2u.vectorNumber(a, b, out);
                             else                       return hmul2u.vectorVector(a, b, out);
}

hmul2u.numberNumber = function(a: number, b: number, out ?: Vector2u.Mutable) {
  return out2u(out,
    a * b, 
    a * b
  );
}

hmul2u.numberVector = function (a: number, b: Vector, out ?: Vector2u.Mutable) {
  return out2u(out,
    a * b.x,
    a * b.y,
  );
}

hmul2u.vectorNumber = function(a: Vector, b: number, out ?: Vector2u.Mutable) {
  return out2u(out,
    a.x * b,
    a.y * b,
  )
}

hmul2u.vectorVector = function(a: Vector, b: Vector, out ?: Vector2u.Mutable) {
  return out2u(out,
    a.x * b.x,
    a.y * b.y,
  )
}

export function hmul2i(a: number | Vector, b: number | Vector, out ?: Vector2i.Mutable): Vector2i {
  if (typeof a === "number") if (typeof b === "number") return hmul2i.numberNumber(a, b, out);
                             else                       return hmul2i.numberVector(a, b, out);
  else                       if (typeof b === "number") return hmul2i.vectorNumber(a, b, out);
                             else                       return hmul2i.vectorVector(a, b, out);
}

hmul2i.numberNumber = function(a: number, b: number, out ?: Vector2i.Mutable) {
  return out2i(out,
    a * b, 
    a * b
  );
}

hmul2i.numberVector = function (a: number, b: Vector, out ?: Vector2i.Mutable) {
  return out2i(out,
    a * b.x,
    a * b.y,
  );
}

hmul2i.vectorNumber = function(a: Vector, b: number, out ?: Vector2i.Mutable) {
  return out2i(out,
    a.x * b,
    a.y * b,
  )
}

hmul2i.vectorVector = function(a: Vector, b: Vector, out ?: Vector2i.Mutable) {
  return Vector.__set__.xy(out ?? new Vector2i(), 
    a.x * b.x, 
    a.y * b.y
  );
}

export function hmul3f(a: number | Vector, b: number | Vector, out ?: Vector3f.Mutable): Vector3f {
  if (typeof a === "number") if (typeof b === "number") return hmul3f.numberNumber(a, b, out);
                             else                       return hmul3f.numberVector(a, b, out);
  else                       if (typeof b === "number") return hmul3f.vectorNumber(a, b, out);
                             else                       return hmul3f.vectorVector(a, b, out);
}

hmul3f.numberNumber = function(a: number, b: number, out ?: Vector3f.Mutable) {
  return out3f(out,
    a * b, 
    a * b,
    a * b
  );
}

hmul3f.numberVector = function (a: number, b: Vector, out ?: Vector3f.Mutable) {
  return out3f(out,
    a * b.x,
    a * b.y,
    a * b.z,
  );
}

hmul3f.vectorNumber = function(a: Vector, b: number, out ?: Vector3f.Mutable) {
  return out3f(out,
    a.x * b,
    a.y * b,
    a.z * b,
  )
}

hmul3f.vectorVector = function(a: Vector, b: Vector, out ?: Vector3f.Mutable) {
  return out3f(out,
    a.x * b.x,
    a.y * b.y,
    a.z * b.z,
  )
}

export function hmul3u(a: number | Vector, b: number | Vector, out ?: Vector3u.Mutable): Vector3u {
  if (typeof a === "number") if (typeof b === "number") return hmul3u.numberNumber(a, b, out);
                             else                       return hmul3u.numberVector(a, b, out);
  else                       if (typeof b === "number") return hmul3u.vectorNumber(a, b, out);
                             else                       return hmul3u.vectorVector(a, b, out);
}

hmul3u.numberNumber = function(a: number, b: number, out ?: Vector3u.Mutable) {
  return out3u(out,
    a * b, 
    a * b,
    a * b
  );
}

hmul3u.numberVector = function (a: number, b: Vector, out ?: Vector3u.Mutable) {
  return out3u(out,
    a * b.x,
    a * b.y,
    a * b.z,
  );
}

hmul3u.vectorNumber = function(a: Vector, b: number, out ?: Vector3u.Mutable) {
  return out3u(out,
    a.x * b,
    a.y * b,
    a.z * b,
  )
}

hmul3u.vectorVector = function(a: Vector, b: Vector, out ?: Vector3u.Mutable) {
  return out3u(out,
    a.x * b.x,
    a.y * b.y,
    a.z * b.z,
  )
}

export function hmul3i(a: number | Vector, b: number | Vector, out ?: Vector3i.Mutable): Vector3i {
  if (typeof a === "number") if (typeof b === "number") return hmul3i.numberNumber(a, b, out);
                             else                       return hmul3i.numberVector(a, b, out);
  else                       if (typeof b === "number") return hmul3i.vectorNumber(a, b, out);
                             else                       return hmul3i.vectorVector(a, b, out);
}

hmul3i.numberNumber = function(a: number, b: number, out ?: Vector3i.Mutable) {
  return out3i(out,
    a * b, 
    a * b,
    a * b
  );
}

hmul3i.numberVector = function (a: number, b: Vector, out ?: Vector3i.Mutable) {
  return out3i(out,
    a * b.x,
    a * b.y,
    a * b.z,
  );
}

hmul3i.vectorNumber = function(a: Vector, b: number, out ?: Vector3i.Mutable) {
  return out3i(out,
    a.x * b,
    a.y * b,
    a.z * b,
  )
}

hmul3i.vectorVector = function(a: Vector, b: Vector, out ?: Vector3i.Mutable) {
  return out3i(out,
    a.x * b.x,
    a.y * b.y,
    a.z * b.z,
  )
}

export function hmul4f(a: number | Vector, b: number | Vector, out ?: Vector4f.Mutable): Vector4f {
  if (typeof a === "number") if (typeof b === "number") return hmul4f.numberNumber(a, b, out);
                             else                       return hmul4f.numberVector(a, b, out);
  else                       if (typeof b === "number") return hmul4f.vectorNumber(a, b, out);
                             else                       return hmul4f.vectorVector(a, b, out);
}

hmul4f.numberNumber = function(a: number, b: number, out ?: Vector4f.Mutable) {
  return out4f(out,
    a * b, 
    a * b,
    a * b,
    a * b
  );
}

hmul4f.numberVector = function (a: number, b: Vector, out ?: Vector4f.Mutable) {
  return out4f(out,
    a * b.x,
    a * b.y,
    a * b.z,
    a * b.w,
  );
}

hmul4f.vectorNumber = function(a: Vector, b: number, out ?: Vector4f.Mutable) {
  return out4f(out,
    a.x * b,
    a.y * b,
    a.z * b,
    a.w * b,
  )
}

hmul4f.vectorVector = function(a: Vector, b: Vector, out ?: Vector4f.Mutable) {
  return out4f(out,
    a.x * b.x,
    a.y * b.y,
    a.z * b.z,
    a.w * b.w,
  )
}

export function hmul4u(a: number | Vector, b: number | Vector, out ?: Vector4u.Mutable): Vector4u {
  if (typeof a === "number") if (typeof b === "number") return hmul4u.numberNumber(a, b, out);
                             else                       return hmul4u.numberVector(a, b, out);
  else                       if (typeof b === "number") return hmul4u.vectorNumber(a, b, out);
                             else                       return hmul4u.vectorVector(a, b, out);
}

hmul4u.numberNumber = function(a: number, b: number, out ?: Vector4u.Mutable) {
  return out4u(out,
    a * b, 
    a * b,
    a * b,
    a * b
  );
}

hmul4u.numberVector = function (a: number, b: Vector, out ?: Vector4u.Mutable) {
  return out4u(out,
    a * b.x,
    a * b.y,
    a * b.z,
    a * b.w,
  );
}

hmul4u.vectorNumber = function(a: Vector, b: number, out ?: Vector4u.Mutable) {
  return out4u(out,
    a.x * b,
    a.y * b,
    a.z * b,
    a.w * b,
  )
}

hmul4u.vectorVector = function(a: Vector, b: Vector, out ?: Vector4u.Mutable) {
  return out4u(out,
    a.x * b.x,
    a.y * b.y,
    a.z * b.z,
    a.w * b.w,
  )
}

export function hmul4i(a: number | Vector, b: number | Vector, out ?: Vector4i.Mutable): Vector4i {
  if (typeof a === "number") if (typeof b === "number") return hmul4i.numberNumber(a, b, out);
                             else                       return hmul4i.numberVector(a, b, out);
  else                       if (typeof b === "number") return hmul4i.vectorNumber(a, b, out);
                             else                       return hmul4i.vectorVector(a, b, out);
}

hmul4i.numberNumber = function(a: number, b: number, out ?: Vector4i.Mutable) {
  return out4i(out,
    a * b, 
    a * b,
    a * b,
    a * b
  );
}

hmul4i.numberVector = function (a: number, b: Vector, out ?: Vector4i.Mutable) {
  return out4i(out,
    a * b.x,
    a * b.y,
    a * b.z,
    a * b.w,
  );
}

hmul4i.vectorNumber = function(a: Vector, b: number, out ?: Vector4i.Mutable) {
  return out4i(out,
    a.x * b,
    a.y * b,
    a.z * b,
    a.w * b,
  )
}

hmul4i.vectorVector = function(a: Vector, b: Vector, out ?: Vector4i.Mutable) {
  return out4i(out,
    a.x * b.x,
    a.y * b.y,
    a.z * b.z,
    a.w * b.w,
  )
}


