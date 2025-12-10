import { Vector } from "../vector";
import { Vector3f, Vector3i, Vector3u } from "../vector3";
import { Vector4f, Vector4i, Vector4u } from "../vector4";
import { out3f, out3i, out3u, out4f, out4i, out4u } from "./out";

export function hom3f(a: number | Vector, out ?: Vector3f.Mutable): Vector3f {
  if (typeof a === "number") return hom3f.number(a, out);
  else                       return hom3f.vector(a, out);
}

hom3f.number = function(a: number, out ?: Vector3f.Mutable) {
  return out3f(out,
    a, 
    a, 
    1
  );
}

hom3f.vector = function(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out,
    a.x, 
    a.y, 
    1
  );
}

export function hom3u(a: number | Vector, out ?: Vector3u.Mutable): Vector3u {
  if (typeof a === "number") return hom3u.number(a, out);
  else                       return hom3u.vector(a, out);
}

hom3u.number = function(a: number, out ?: Vector3u.Mutable) {
  return out3u(out,
    a, 
    a, 
    1
  );
}

hom3u.vector = function(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out,
    a.x, 
    a.y, 
    1
  );
}

export function hom3i(a: number | Vector, out ?: Vector3i.Mutable): Vector3i {
  if (typeof a === "number") return hom3i.number(a, out);
  else                       return hom3i.vector(a, out);
}

hom3i.number = function(a: number, out ?: Vector3i.Mutable) {
  return out3i(out,
    a, 
    a, 
    1
  );
}

hom3i.vector = function(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out,
    a.x, 
    a.y, 
    1
  );
}

export function hom4f(a: number | Vector, out ?: Vector4f.Mutable): Vector4f {
  if (typeof a === "number") return hom4f.number(a, out);
  else                       return hom4f.vector(a, out);
}

hom4f.number = function(a: number, out ?: Vector4f.Mutable) {
  return out4f(out,
    a, 
    a, 
    a,
    1
  );
}

hom4f.vector = function(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out,
    a.x, 
    a.y, 
    a.z,
    1
  );
}

export function hom4u(a: number | Vector, out ?: Vector4u.Mutable): Vector4u {
  if (typeof a === "number") return hom4u.number(a, out);
  else                       return hom4u.vector(a, out);
}

hom4u.number = function(a: number, out ?: Vector4u.Mutable) {
  return out4u(out,
    a, 
    a, 
    a,
    1
  );
}

hom4u.vector = function(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out,
    a.x, 
    a.y, 
    a.z,
    1
  );
}

export function hom4i(a: number | Vector, out ?: Vector4i.Mutable): Vector4i {
  if (typeof a === "number") return hom4i.number(a, out);
  else                       return hom4i.vector(a, out);
}

hom4i.number = function(a: number, out ?: Vector4i.Mutable) {
  return out4i(out,
    a, 
    a, 
    a,
    1
  );
}

hom4i.vector = function(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out,
    a.x, 
    a.y, 
    a.z,
    1
  );
}



