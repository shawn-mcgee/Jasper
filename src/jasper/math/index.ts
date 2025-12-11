import { Vector2f, Vector2u, Vector2i } from "./vector/vector2";
import { Vector3f, Vector3u, Vector3i } from "./vector/vector3";
import { Vector4f, Vector4u, Vector4i } from "./vector/vector4";

export const imm = {
  vec2f(x ?: number, y ?: number)                           { return new Vector2f(x, y); },
  vec3f(x ?: number, y ?: number, z ?: number)              { return new Vector3f(x, y, z); },
  vec4f(x ?: number, y ?: number, z ?: number, w ?: number) { return new Vector4f(x, y, z, w); },

  vec2u(x ?: number, y ?: number)                           { return new Vector2u(x, y); },
  vec3u(x ?: number, y ?: number, z ?: number)              { return new Vector3u(x, y, z); },
  vec4u(x ?: number, y ?: number, z ?: number, w ?: number) { return new Vector4u(x, y, z, w); },

  vec2i(x ?: number, y ?: number)                           { return new Vector2i(x, y); },
  vec3i(x ?: number, y ?: number, z ?: number)              { return new Vector3i(x, y, z); },
  vec4i(x ?: number, y ?: number, z ?: number, w ?: number) { return new Vector4i(x, y, z, w); },
} as const;

export const mut = {
  vec2f(x ?: number, y ?: number)                           { return new Vector2f.Mutable(x, y); },
  vec3f(x ?: number, y ?: number, z ?: number)              { return new Vector3f.Mutable(x, y, z); },
  vec4f(x ?: number, y ?: number, z ?: number, w ?: number) { return new Vector4f.Mutable(x, y, z, w); },

  vec2u(x ?: number, y ?: number)                           { return new Vector2u.Mutable(x, y); },
  vec3u(x ?: number, y ?: number, z ?: number)              { return new Vector3u.Mutable(x, y, z); },
  vec4u(x ?: number, y ?: number, z ?: number, w ?: number) { return new Vector4u.Mutable(x, y, z, w); },

  vec2i(x ?: number, y ?: number)                           { return new Vector2i.Mutable(x, y); },
  vec3i(x ?: number, y ?: number, z ?: number)              { return new Vector3i.Mutable(x, y, z); },
  vec4i(x ?: number, y ?: number, z ?: number, w ?: number) { return new Vector4i.Mutable(x, y, z, w); },
} as const;

export const vec2f = imm.vec2f;
export const vec3f = imm.vec3f;
export const vec4f = imm.vec4f;
export const vec2u = imm.vec2u;
export const vec3u = imm.vec3u;
export const vec4u = imm.vec4u;
export const vec2i = imm.vec2i;
export const vec3i = imm.vec3i;
export const vec4i = imm.vec4i;

// forward vector imports
export * from "./vector/vector";
export * from "./vector/vector2";
export * from "./vector/vector3";
export * from "./vector/vector4";
export * from "./vector/ops/add";
export * from "./vector/ops/sub";
export * from "./vector/ops/hmul";
export * from "./vector/ops/hdiv";
export * from "./vector/ops/dot";
export * from "./vector/ops/out";