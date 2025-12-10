import { Vector } from "../vector";

export function mag2(a: number | Vector): number {
  if (typeof a === "number") return mag2.number(a);
  else                       return mag2.vector(a);
}

mag2.number = function(a: number) {
  return Math.sqrt(a * a);
}

mag2.vector = function(a: Vector) {
  return mag2.number(a.x * a.x + a.y * a.y);
}

export function mag3(a: number | Vector): number {
  if (typeof a === "number") return mag3.number(a);
  else                       return mag3.vector(a);
}

mag3.number = function(a: number) {
  return Math.sqrt(a * a);
}

mag3.vector = function(a: Vector) {
  return mag3.number(a.x * a.x + a.y * a.y + a.z * a.z);
}

export function mag4(a: number | Vector): number {
  if (typeof a === "number") return mag4.number(a);
  else                       return mag4.vector(a);
}

mag4.number = function(a: number) {
  return Math.sqrt(a * a);
}

mag4.vector = function(a: Vector) {
  return mag4.number(a.x * a.x + a.y * a.y + a.z * a.z + a.w * a.w);
}