import { Vector } from "../vector";
import { Vector2f, Vector2i, Vector2u } from "../vector2";
import { Vector3f, Vector3i, Vector3u } from "../vector3";
import { Vector4f } from "../vector4";
import { out2f, out2i, out2u, out3f, out3i, out3u, out4f } from "./out";

// swizzle 2f
export function xxf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.x, a.x);
}

export function xyf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.x, a.y);
}

export function xzf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.x, a.z);
}

export function xwf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.x, a.w);
}

export function yxf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.y, a.x);
}

export function yyf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.y, a.y);
}

export function yzf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.y, a.z);
}

export function ywf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.y, a.w);
}

export function zxf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.z, a.x);
}

export function zyf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.z, a.y);
}

export function zzf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.z, a.z);
}

export function zwf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.z, a.w);
}

export function wxf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.w, a.x);
}

export function wyf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.w, a.y);
}

export function wzf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.w, a.z);
}

export function wwf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.w, a.w);
}

// swizzle 2u
export function xxu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.x, a.x);
}

export function xyu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.x, a.y);
}

export function xzu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.x, a.z);
}

export function xwu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.x, a.w);
}

export function yxu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.y, a.x);
}

export function yyu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.y, a.y);
}

export function yzu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.y, a.z);
}

export function ywu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.y, a.w);
}

export function zxu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.z, a.x);
}

export function zyu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.z, a.y);
}

export function zzu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.z, a.z);
}

export function zwu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.z, a.w);
}

export function wxu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.w, a.x);
}

export function wyu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.w, a.y);
}

export function wzu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.w, a.z);
}

export function wwu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.w, a.w);
}

// swizzle 2i
export function xxi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.x, a.x);
}

export function xyi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.x, a.y);
}

export function xzi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.x, a.z);
}

export function xwi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.x, a.w);
}

export function yxi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.y, a.x);
}

export function yyi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.y, a.y);
}

export function yzi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.y, a.z);
}

export function ywi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.y, a.w);
}

export function zxi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.z, a.x);
}

export function zyi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.z, a.y);
}

export function zzi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.z, a.z);
}

export function zwi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.z, a.w);
}

export function wxi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.w, a.x);
}

export function wyi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.w, a.y);
}

export function wzi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.w, a.z);
}

export function wwi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.w, a.w);
}

// swizzle 3f
export function xxxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.x, a.x);
}

export function xxyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.x, a.y);
}

export function xxzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.x, a.z);
}

export function xxwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.x, a.w);
}

export function xyxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.y, a.x);
}

export function xyyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.y, a.y);
}

export function xyzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.y, a.z);
}

export function xywf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.y, a.w);
}

export function xzxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.z, a.x);
}

export function xzyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.z, a.y);
}

export function xzzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.z, a.z);
}

export function xzwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.z, a.w);
}

export function xwxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.w, a.x);
}

export function xwyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.w, a.y);
}

export function xwzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.w, a.z);
}

export function xwwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.w, a.w);
}

export function yxxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.x, a.x);
}

export function yxyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.x, a.y);
}

export function yxzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.x, a.z);
}

export function yxwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.x, a.w);
}

export function yyxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.y, a.x);
}

export function yyyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.y, a.y);
}

export function yyzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.y, a.z);
}

export function yywf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.y, a.w);
}

export function yzxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.z, a.x);
}

export function yzyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.z, a.y);
}

export function yzzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.z, a.z);
}

export function yzwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.z, a.w);
}

export function ywxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.w, a.x);
}

export function ywyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.w, a.y);
}

export function ywzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.w, a.z);
}

export function ywwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.w, a.w);
}

export function zxxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.x, a.x);
}

export function zxyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.x, a.y);
}

export function zxzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.x, a.z);
}

export function zxwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.x, a.w);
}

export function zyxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.y, a.x);
}

export function zyyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.y, a.y);
}

export function zyzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.y, a.z);
}

export function zywf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.y, a.w);
}

export function zzxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.z, a.x);
}

export function zzyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.z, a.y);
}

export function zzzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.z, a.z);
}

export function zzwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.z, a.w);
}

export function zwxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.w, a.x);
}

export function zwyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.w, a.y);
}

export function zwzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.w, a.z);
}

export function zwwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.w, a.w);
}

export function wxxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.x, a.x);
}

export function wxyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.x, a.y);
}

export function wxzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.x, a.z);
}

export function wxwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.x, a.w);
}

export function wyxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.y, a.x);
}

export function wyyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.y, a.y);
}

export function wyzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.y, a.z);
}

export function wywf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.y, a.w);
}

export function wzxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.z, a.x);
}

export function wzyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.z, a.y);
}

export function wzzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.z, a.z);
}

export function wzwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.z, a.w);
}

export function wwxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.w, a.x);
}

export function wwyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.w, a.y);
}

export function wwzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.w, a.z);
}

export function wwwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.w, a.w);
}

// swizzle 3u
export function xxxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.x, a.x);
}

export function xxyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.x, a.y);
}

export function xxzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.x, a.z);
}

export function xxwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.x, a.w);
}

export function xyxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.y, a.x);
}

export function xyyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.y, a.y);
}

export function xyzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.y, a.z);
}

export function xywu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.y, a.w);
}

export function xzxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.z, a.x);
}

export function xzyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.z, a.y);
}

export function xzzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.z, a.z);
}

export function xzwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.z, a.w);
}

export function xwxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.w, a.x);
}

export function xwyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.w, a.y);
}

export function xwzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.w, a.z);
}

export function xwwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.w, a.w);
}

export function yxxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.x, a.x);
}

export function yxyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.x, a.y);
}

export function yxzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.x, a.z);
}

export function yxwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.x, a.w);
}

export function yyxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.y, a.x);
}

export function yyyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.y, a.y);
}

export function yyzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.y, a.z);
}

export function yywu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.y, a.w);
}

export function yzxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.z, a.x);
}

export function yzyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.z, a.y);
}

export function yzzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.z, a.z);
}

export function yzwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.z, a.w);
}

export function ywxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.w, a.x);
}

export function ywyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.w, a.y);
}

export function ywzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.w, a.z);
}

export function ywwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.w, a.w);
}

export function zxxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.x, a.x);
}

export function zxyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.x, a.y);
}

export function zxzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.x, a.z);
}

export function zxwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.x, a.w);
}

export function zyxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.y, a.x);
}

export function zyyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.y, a.y);
}

export function zyzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.y, a.z);
}

export function zywu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.y, a.w);
}

export function zzxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.z, a.x);
}

export function zzyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.z, a.y);
}

export function zzzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.z, a.z);
}

export function zzwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.z, a.w);
}

export function zwxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.w, a.x);
}

export function zwyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.w, a.y);
}

export function zwzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.w, a.z);
}

export function zwwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.w, a.w);
}

export function wxxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.x, a.x);
}

export function wxyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.x, a.y);
}

export function wxzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.x, a.z);
}

export function wxwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.x, a.w);
}

export function wyxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.y, a.x);
}

export function wyyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.y, a.y);
}

export function wyzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.y, a.z);
}

export function wywu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.y, a.w);
}

export function wzxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.z, a.x);
}

export function wzyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.z, a.y);
}

export function wzzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.z, a.z);
}

export function wzwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.z, a.w);
}

export function wwxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.w, a.x);
}

export function wwyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.w, a.y);
}

export function wwzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.w, a.z);
}

export function wwwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.w, a.w);
}

// swizzle 3i
export function xxxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.x, a.x);
}

export function xxyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.x, a.y);
}

export function xxzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.x, a.z);
}

export function xxwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.x, a.w);
}

export function xyxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.y, a.x);
}

export function xyyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.y, a.y);
}

export function xyzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.y, a.z);
}

export function xywi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.y, a.w);
}

export function xzxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.z, a.x);
}

export function xzyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.z, a.y);
}

export function xzzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.z, a.z);
}

export function xzwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.z, a.w);
}

export function xwxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.w, a.x);
}

export function xwyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.w, a.y);
}

export function xwzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.w, a.z);
}

export function xwwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.w, a.w);
}

export function yxxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.x, a.x);
}

export function yxyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.x, a.y);
}

export function yxzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.x, a.z);
}

export function yxwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.x, a.w);
}

export function yyxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.y, a.x);
}

export function yyyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.y, a.y);
}

export function yyzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.y, a.z);
}

export function yywi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.y, a.w);
}

export function yzxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.z, a.x);
}

export function yzyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.z, a.y);
}

export function yzzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.z, a.z);
}

export function yzwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.z, a.w);
}

export function ywxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.w, a.x);
}

export function ywyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.w, a.y);
}

export function ywzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.w, a.z);
}

export function ywwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.w, a.w);
}

export function zxxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.x, a.x);
}

export function zxyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.x, a.y);
}

export function zxzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.x, a.z);
}

export function zxwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.x, a.w);
}

export function zyxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.y, a.x);
}

export function zyyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.y, a.y);
}

export function zyzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.y, a.z);
}

export function zywi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.y, a.w);
}

export function zzxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.z, a.x);
}

export function zzyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.z, a.y);
}

export function zzzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.z, a.z);
}

export function zzwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.z, a.w);
}

export function zwxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.w, a.x);
}

export function zwyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.w, a.y);
}

export function zwzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.w, a.z);
}

export function zwwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.w, a.w);
}

export function wxxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.x, a.x);
}

export function wxyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.x, a.y);
}

export function wxzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.x, a.z);
}

export function wxwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.x, a.w);
}

export function wyxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.y, a.x);
}

export function wyyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.y, a.y);
}

export function wyzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.y, a.z);
}

export function wywi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.y, a.w);
}

export function wzxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.z, a.x);
}

export function wzyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.z, a.y);
}

export function wzzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.z, a.z);
}

export function wzwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.z, a.w);
}

export function wwxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.w, a.x);
}

export function wwyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.w, a.y);
}

export function wwzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.w, a.z);
}

export function wwwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.w, a.w);
}