import { Vector } from "../vector";

export function dot2(a: number | Vector, b: number | Vector = a): number {
  if (typeof a === "number") if (typeof b === "number") return dot2.numberNumber(a, b);
                             else                       return dot2.numberVector(a, b);
  else                       if (typeof b === "number") return dot2.vectorNumber(a, b);
                             else                       return dot2.vectorVector(a, b);
}

dot2.numberNumber = function(a: number, b: number = a) {
  return a * b;
}

dot2.numberVector = function(a: number, b: Vector) {
  return a * b.x;
}

dot2.vectorNumber = function(a: Vector, b: number) {
  return a.x * b;
}

dot2.vectorVector = function(a: Vector, b: Vector = a) {
  return a.x * b.x + a.y * b.y;
}

export function dot3(a: number | Vector, b: number | Vector = a): number {
  if (typeof a === "number") if (typeof b === "number") return dot3.numberNumber(a, b);
                             else                       return dot3.numberVector(a, b);
  else                       if (typeof b === "number") return dot3.vectorNumber(a, b);
                             else                       return dot3.vectorVector(a, b);
}

dot3.numberNumber = function(a: number, b: number = a) {
  return a * b;
}

dot3.numberVector = function(a: number, b: Vector) {
  return a * b.x;
}

dot3.vectorNumber = function(a: Vector, b: number) {
  return a.x * b;
}

dot3.vectorVector = function(a: Vector, b: Vector = a) {
  return a.x * b.x + a.y * b.y + a.z * b.z;
}

export function dot4(a: number | Vector, b: number | Vector = a): number {
  if (typeof a === "number") if (typeof b === "number") return dot4.numberNumber(a, b);
                             else                       return dot4.numberVector(a, b);
  else                       if (typeof b === "number") return dot4.vectorNumber(a, b);
                             else                       return dot4.vectorVector(a, b);
}

dot4.numberNumber = function(a: number, b: number = a) {
  return a * b;
}

dot4.numberVector = function(a: number, b: Vector) {
  return a * b.x;
}

dot4.vectorNumber = function(a: Vector, b: number) {
  return a.x * b;
}

dot4.vectorVector = function(a: Vector, b: Vector = a) {
  return a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w;
}