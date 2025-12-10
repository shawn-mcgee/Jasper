import { Vector } from "../vector";
import { Vector2f, Vector2i, Vector2u } from "../vector2";
import { Vector3f, Vector3i, Vector3u } from "../vector3";
import { Vector4f, Vector4i, Vector4u } from "../vector4";
import { out2f, out2i, out2u, out3f, out3i, out3u, out4f, out4i, out4u } from "./out";

export function sub2f(a: number | Vector, b: number | Vector, out ?: Vector2f.Mutable): Vector2f {
  if (typeof a === "number") if (typeof b === "number") return sub2f.numberNumber(a, b, out);
                             else                       return sub2f.numberVector(a, b, out);
  else                       if (typeof b === "number") return sub2f.vectorNumber(a, b, out);
                             else                       return sub2f.vectorVector(a, b, out);
}

sub2f.numberNumber = function(a: number, b: number, out ?: Vector2f.Mutable) {
  return out2f(out,
    a - b, 
    a - b
  );
}

sub2f.numberVector = function (a: number, b: Vector, out ?: Vector2f.Mutable) {
  return out2f(out,
    a - b.x,
    a - b.y,
  );
}

sub2f.vectorNumber = function(a: Vector, b: number, out ?: Vector2f.Mutable) {
  return out2f(out,
    a.x - b,
    a.y - b,
  )
}

sub2f.vectorVector = function(a: Vector, b: Vector, out ?: Vector2f.Mutable) {
  return out2f(out,
    a.x - b.x,
    a.y - b.y,
  )
}

export function sub2u(a: number | Vector, b: number | Vector, out ?: Vector2u.Mutable): Vector2u {
  if (typeof a === "number") if (typeof b === "number") return sub2u.numberNumber(a, b, out);
                             else                       return sub2u.numberVector(a, b, out);
  else                       if (typeof b === "number") return sub2u.vectorNumber(a, b, out);
                             else                       return sub2u.vectorVector(a, b, out);
}

sub2u.numberNumber = function(a: number, b: number, out ?: Vector2u.Mutable) {
  return out2u(out,
    a - b, 
    a - b
  );
}

sub2u.numberVector = function (a: number, b: Vector, out ?: Vector2u.Mutable) {
  return out2u(out,
    a - b.x,
    a - b.y,
  );
}

sub2u.vectorNumber = function(a: Vector, b: number, out ?: Vector2u.Mutable) {
  return out2u(out,
    a.x - b,
    a.y - b,
  )
}

sub2u.vectorVector = function(a: Vector, b: Vector, out ?: Vector2u.Mutable) {
  return out2u(out,
    a.x - b.x,
    a.y - b.y,
  )
}

export function sub2i(a: number | Vector, b: number | Vector, out ?: Vector2i.Mutable): Vector2i {
  if (typeof a === "number") if (typeof b === "number") return sub2i.numberNumber(a, b, out);
                             else                       return sub2i.numberVector(a, b, out);
  else                       if (typeof b === "number") return sub2i.vectorNumber(a, b, out);
                             else                       return sub2i.vectorVector(a, b, out);
}

sub2i.numberNumber = function(a: number, b: number, out ?: Vector2i.Mutable) {
  return out2i(out,
    a - b, 
    a - b
  );
}

sub2i.numberVector = function (a: number, b: Vector, out ?: Vector2i.Mutable) {
  return out2i(out,
    a - b.x,
    a - b.y,
  );
}

sub2i.vectorNumber = function(a: Vector, b: number, out ?: Vector2i.Mutable) {
  return out2i(out,
    a.x - b,
    a.y - b,
  )
}

sub2i.vectorVector = function(a: Vector, b: Vector, out ?: Vector2i.Mutable) {
  return Vector.__set__.xy(out ?? new Vector2i(), 
    a.x - b.x, 
    a.y - b.y
  );
}

export function sub3f(a: number | Vector, b: number | Vector, out ?: Vector3f.Mutable): Vector3f {
  if (typeof a === "number") if (typeof b === "number") return sub3f.numberNumber(a, b, out);
                             else                       return sub3f.numberVector(a, b, out);
  else                       if (typeof b === "number") return sub3f.vectorNumber(a, b, out);
                             else                       return sub3f.vectorVector(a, b, out);
}

sub3f.numberNumber = function(a: number, b: number, out ?: Vector3f.Mutable) {
  return out3f(out,
    a - b, 
    a - b,
    a - b
  );
}

sub3f.numberVector = function (a: number, b: Vector, out ?: Vector3f.Mutable) {
  return out3f(out,
    a - b.x,
    a - b.y,
    a - b.z,
  );
}

sub3f.vectorNumber = function(a: Vector, b: number, out ?: Vector3f.Mutable) {
  return out3f(out,
    a.x - b,
    a.y - b,
    a.z - b,
  )
}

sub3f.vectorVector = function(a: Vector, b: Vector, out ?: Vector3f.Mutable) {
  return out3f(out,
    a.x - b.x,
    a.y - b.y,
    a.z - b.z,
  )
}

export function sub3u(a: number | Vector, b: number | Vector, out ?: Vector3u.Mutable): Vector3u {
  if (typeof a === "number") if (typeof b === "number") return sub3u.numberNumber(a, b, out);
                             else                       return sub3u.numberVector(a, b, out);
  else                       if (typeof b === "number") return sub3u.vectorNumber(a, b, out);
                             else                       return sub3u.vectorVector(a, b, out);
}

sub3u.numberNumber = function(a: number, b: number, out ?: Vector3u.Mutable) {
  return out3u(out,
    a - b, 
    a - b,
    a - b
  );
}

sub3u.numberVector = function (a: number, b: Vector, out ?: Vector3u.Mutable) {
  return out3u(out,
    a - b.x,
    a - b.y,
    a - b.z,
  );
}

sub3u.vectorNumber = function(a: Vector, b: number, out ?: Vector3u.Mutable) {
  return out3u(out,
    a.x - b,
    a.y - b,
    a.z - b,
  )
}

sub3u.vectorVector = function(a: Vector, b: Vector, out ?: Vector3u.Mutable) {
  return out3u(out,
    a.x - b.x,
    a.y - b.y,
    a.z - b.z,
  )
}

export function sub3i(a: number | Vector, b: number | Vector, out ?: Vector3i.Mutable): Vector3i {
  if (typeof a === "number") if (typeof b === "number") return sub3i.numberNumber(a, b, out);
                             else                       return sub3i.numberVector(a, b, out);
  else                       if (typeof b === "number") return sub3i.vectorNumber(a, b, out);
                             else                       return sub3i.vectorVector(a, b, out);
}

sub3i.numberNumber = function(a: number, b: number, out ?: Vector3i.Mutable) {
  return out3i(out,
    a - b, 
    a - b,
    a - b
  );
}

sub3i.numberVector = function (a: number, b: Vector, out ?: Vector3i.Mutable) {
  return out3i(out,
    a - b.x,
    a - b.y,
    a - b.z,
  );
}

sub3i.vectorNumber = function(a: Vector, b: number, out ?: Vector3i.Mutable) {
  return out3i(out,
    a.x - b,
    a.y - b,
    a.z - b,
  )
}

sub3i.vectorVector = function(a: Vector, b: Vector, out ?: Vector3i.Mutable) {
  return out3i(out,
    a.x - b.x,
    a.y - b.y,
    a.z - b.z,
  )
}

export function sub4f(a: number | Vector, b: number | Vector, out ?: Vector4f.Mutable): Vector4f {
  if (typeof a === "number") if (typeof b === "number") return sub4f.numberNumber(a, b, out);
                             else                       return sub4f.numberVector(a, b, out);
  else                       if (typeof b === "number") return sub4f.vectorNumber(a, b, out);
                             else                       return sub4f.vectorVector(a, b, out);
}

sub4f.numberNumber = function(a: number, b: number, out ?: Vector4f.Mutable) {
  return out4f(out,
    a - b, 
    a - b,
    a - b,
    a - b
  );
}

sub4f.numberVector = function (a: number, b: Vector, out ?: Vector4f.Mutable) {
  return out4f(out,
    a - b.x,
    a - b.y,
    a - b.z,
    a - b.w,
  );
}

sub4f.vectorNumber = function(a: Vector, b: number, out ?: Vector4f.Mutable) {
  return out4f(out,
    a.x - b,
    a.y - b,
    a.z - b,
    a.w - b,
  )
}

sub4f.vectorVector = function(a: Vector, b: Vector, out ?: Vector4f.Mutable) {
  return out4f(out,
    a.x - b.x,
    a.y - b.y,
    a.z - b.z,
    a.w - b.w,
  )
}

export function sub4u(a: number | Vector, b: number | Vector, out ?: Vector4u.Mutable): Vector4u {
  if (typeof a === "number") if (typeof b === "number") return sub4u.numberNumber(a, b, out);
                             else                       return sub4u.numberVector(a, b, out);
  else                       if (typeof b === "number") return sub4u.vectorNumber(a, b, out);
                             else                       return sub4u.vectorVector(a, b, out);
}

sub4u.numberNumber = function(a: number, b: number, out ?: Vector4u.Mutable) {
  return out4u(out,
    a - b, 
    a - b,
    a - b,
    a - b
  );
}

sub4u.numberVector = function (a: number, b: Vector, out ?: Vector4u.Mutable) {
  return out4u(out,
    a - b.x,
    a - b.y,
    a - b.z,
    a - b.w,
  );
}

sub4u.vectorNumber = function(a: Vector, b: number, out ?: Vector4u.Mutable) {
  return out4u(out,
    a.x - b,
    a.y - b,
    a.z - b,
    a.w - b,
  )
}

sub4u.vectorVector = function(a: Vector, b: Vector, out ?: Vector4u.Mutable) {
  return out4u(out,
    a.x - b.x,
    a.y - b.y,
    a.z - b.z,
    a.w - b.w,
  )
}

export function sub4i(a: number | Vector, b: number | Vector, out ?: Vector4i.Mutable): Vector4i {
  if (typeof a === "number") if (typeof b === "number") return sub4i.numberNumber(a, b, out);
                             else                       return sub4i.numberVector(a, b, out);
  else                       if (typeof b === "number") return sub4i.vectorNumber(a, b, out);
                             else                       return sub4i.vectorVector(a, b, out);
}

sub4i.numberNumber = function(a: number, b: number, out ?: Vector4i.Mutable) {
  return out4i(out,
    a - b, 
    a - b,
    a - b,
    a - b
  );
}

sub4i.numberVector = function (a: number, b: Vector, out ?: Vector4i.Mutable) {
  return out4i(out,
    a - b.x,
    a - b.y,
    a - b.z,
    a - b.w,
  );
}

sub4i.vectorNumber = function(a: Vector, b: number, out ?: Vector4i.Mutable) {
  return out4i(out,
    a.x - b,
    a.y - b,
    a.z - b,
    a.w - b,
  )
}

sub4i.vectorVector = function(a: Vector, b: Vector, out ?: Vector4i.Mutable) {
  return out4i(out,
    a.x - b.x,
    a.y - b.y,
    a.z - b.z,
    a.w - b.w,
  )
}


