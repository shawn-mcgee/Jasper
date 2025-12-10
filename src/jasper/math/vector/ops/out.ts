import { Vector } from "../vector";
import { Vector2f, Vector2i, Vector2u } from "../vector2";
import { Vector3f, Vector3i, Vector3u } from "../vector3";
import { Vector4f, Vector4i, Vector4u } from "../vector4";

export function out2f(out: Vector2f.Mutable | undefined, x: number, y: number) {
  return out ? Vector.__set__.xy(out, x, y): new Vector2f(x, y);
}

export function out3f(out: Vector3f.Mutable | undefined, x: number, y: number, z: number) {
  return out ? Vector.__set__.xyz(out, x, y, z): new Vector3f(x, y, z);
}

export function out4f(out: Vector4f.Mutable | undefined, x: number, y: number, z: number, w: number) {
  return out ? Vector.__set__.xyzw(out, x, y, z, w): new Vector4f(x, y, z, w);
}

export function out2u(out: Vector2u.Mutable | undefined, x: number, y: number) {
  return out ? Vector.__set__.xy(out, x, y): new Vector2u(x, y);
}

export function out3u(out: Vector3u.Mutable | undefined, x: number, y: number, z: number) {
  return out ? Vector.__set__.xyz(out, x, y, z): new Vector3u(x, y, z);
}

export function out4u(out: Vector4u.Mutable | undefined, x: number, y: number, z: number, w: number) {
  return out ? Vector.__set__.xyzw(out, x, y, z, w): new Vector4u(x, y, z, w);
}

export function out2i(out: Vector2i.Mutable | undefined, x: number, y: number) {
  return out ? Vector.__set__.xy(out, x, y): new Vector2i(x, y);
}

export function out3i(out: Vector3i.Mutable | undefined, x: number, y: number, z: number) {
  return out ? Vector.__set__.xyz(out, x, y, z): new Vector3i(x, y, z);
}

export function out4i(out: Vector4i.Mutable | undefined, x: number, y: number, z: number, w: number) {
  return out ? Vector.__set__.xyzw(out, x, y, z, w): new Vector4i(x, y, z, w);
}
