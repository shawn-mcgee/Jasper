import { Vector } from "../vector";
import { Vector2f, Vector2i, Vector2u } from "../vector2";
import { Vector3f, Vector3i, Vector3u } from "../vector3";
import { Vector4f, Vector4i, Vector4u } from "../vector4";
import { out2f, out2i, out2u, out3f, out3i, out3u, out4f, out4i, out4u } from "./out";

//swizzle2f
export function xxf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.x, a.x);
}

export function yxf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.y, a.x);
}

export function zxf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.z, a.x);
}

export function wxf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.w, a.x);
}

export function xyf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.x, a.y);
}

export function yyf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.y, a.y);
}

export function zyf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.z, a.y);
}

export function wyf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.w, a.y);
}

export function xzf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.x, a.z);
}

export function yzf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.y, a.z);
}

export function zzf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.z, a.z);
}

export function wzf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.w, a.z);
}

export function xwf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.x, a.w);
}

export function ywf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.y, a.w);
}

export function zwf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.z, a.w);
}

export function wwf(a: Vector, out ?: Vector2f.Mutable) {
  return out2f(out, a.w, a.w);
}

//swizzle2u
export function xxu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.x, a.x);
}

export function yxu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.y, a.x);
}

export function zxu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.z, a.x);
}

export function wxu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.w, a.x);
}

export function xyu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.x, a.y);
}

export function yyu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.y, a.y);
}

export function zyu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.z, a.y);
}

export function wyu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.w, a.y);
}

export function xzu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.x, a.z);
}

export function yzu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.y, a.z);
}

export function zzu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.z, a.z);
}

export function wzu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.w, a.z);
}

export function xwu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.x, a.w);
}

export function ywu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.y, a.w);
}

export function zwu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.z, a.w);
}

export function wwu(a: Vector, out ?: Vector2u.Mutable) {
  return out2u(out, a.w, a.w);
}

//swizzle2i
export function xxi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.x, a.x);
}

export function yxi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.y, a.x);
}

export function zxi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.z, a.x);
}

export function wxi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.w, a.x);
}

export function xyi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.x, a.y);
}

export function yyi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.y, a.y);
}

export function zyi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.z, a.y);
}

export function wyi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.w, a.y);
}

export function xzi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.x, a.z);
}

export function yzi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.y, a.z);
}

export function zzi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.z, a.z);
}

export function wzi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.w, a.z);
}

export function xwi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.x, a.w);
}

export function ywi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.y, a.w);
}

export function zwi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.z, a.w);
}

export function wwi(a: Vector, out ?: Vector2i.Mutable) {
  return out2i(out, a.w, a.w);
}

//swizzle3f
export function xxxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.x, a.x);
}

export function yxxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.x, a.x);
}

export function zxxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.x, a.x);
}

export function wxxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.x, a.x);
}

export function xyxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.y, a.x);
}

export function yyxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.y, a.x);
}

export function zyxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.y, a.x);
}

export function wyxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.y, a.x);
}

export function xzxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.z, a.x);
}

export function yzxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.z, a.x);
}

export function zzxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.z, a.x);
}

export function wzxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.z, a.x);
}

export function xwxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.w, a.x);
}

export function ywxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.w, a.x);
}

export function zwxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.w, a.x);
}

export function wwxf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.w, a.x);
}

export function xxyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.x, a.y);
}

export function yxyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.x, a.y);
}

export function zxyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.x, a.y);
}

export function wxyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.x, a.y);
}

export function xyyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.y, a.y);
}

export function yyyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.y, a.y);
}

export function zyyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.y, a.y);
}

export function wyyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.y, a.y);
}

export function xzyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.z, a.y);
}

export function yzyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.z, a.y);
}

export function zzyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.z, a.y);
}

export function wzyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.z, a.y);
}

export function xwyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.w, a.y);
}

export function ywyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.w, a.y);
}

export function zwyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.w, a.y);
}

export function wwyf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.w, a.y);
}

export function xxzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.x, a.z);
}

export function yxzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.x, a.z);
}

export function zxzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.x, a.z);
}

export function wxzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.x, a.z);
}

export function xyzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.y, a.z);
}

export function yyzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.y, a.z);
}

export function zyzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.y, a.z);
}

export function wyzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.y, a.z);
}

export function xzzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.z, a.z);
}

export function yzzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.z, a.z);
}

export function zzzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.z, a.z);
}

export function wzzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.z, a.z);
}

export function xwzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.w, a.z);
}

export function ywzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.w, a.z);
}

export function zwzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.w, a.z);
}

export function wwzf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.w, a.z);
}

export function xxwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.x, a.w);
}

export function yxwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.x, a.w);
}

export function zxwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.x, a.w);
}

export function wxwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.x, a.w);
}

export function xywf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.y, a.w);
}

export function yywf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.y, a.w);
}

export function zywf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.y, a.w);
}

export function wywf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.y, a.w);
}

export function xzwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.z, a.w);
}

export function yzwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.z, a.w);
}

export function zzwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.z, a.w);
}

export function wzwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.z, a.w);
}

export function xwwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.x, a.w, a.w);
}

export function ywwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.y, a.w, a.w);
}

export function zwwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.z, a.w, a.w);
}

export function wwwf(a: Vector, out ?: Vector3f.Mutable) {
  return out3f(out, a.w, a.w, a.w);
}

//swizzle3u
export function xxxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.x, a.x);
}

export function yxxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.x, a.x);
}

export function zxxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.x, a.x);
}

export function wxxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.x, a.x);
}

export function xyxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.y, a.x);
}

export function yyxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.y, a.x);
}

export function zyxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.y, a.x);
}

export function wyxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.y, a.x);
}

export function xzxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.z, a.x);
}

export function yzxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.z, a.x);
}

export function zzxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.z, a.x);
}

export function wzxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.z, a.x);
}

export function xwxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.w, a.x);
}

export function ywxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.w, a.x);
}

export function zwxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.w, a.x);
}

export function wwxu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.w, a.x);
}

export function xxyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.x, a.y);
}

export function yxyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.x, a.y);
}

export function zxyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.x, a.y);
}

export function wxyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.x, a.y);
}

export function xyyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.y, a.y);
}

export function yyyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.y, a.y);
}

export function zyyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.y, a.y);
}

export function wyyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.y, a.y);
}

export function xzyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.z, a.y);
}

export function yzyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.z, a.y);
}

export function zzyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.z, a.y);
}

export function wzyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.z, a.y);
}

export function xwyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.w, a.y);
}

export function ywyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.w, a.y);
}

export function zwyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.w, a.y);
}

export function wwyu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.w, a.y);
}

export function xxzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.x, a.z);
}

export function yxzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.x, a.z);
}

export function zxzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.x, a.z);
}

export function wxzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.x, a.z);
}

export function xyzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.y, a.z);
}

export function yyzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.y, a.z);
}

export function zyzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.y, a.z);
}

export function wyzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.y, a.z);
}

export function xzzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.z, a.z);
}

export function yzzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.z, a.z);
}

export function zzzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.z, a.z);
}

export function wzzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.z, a.z);
}

export function xwzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.w, a.z);
}

export function ywzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.w, a.z);
}

export function zwzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.w, a.z);
}

export function wwzu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.w, a.z);
}

export function xxwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.x, a.w);
}

export function yxwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.x, a.w);
}

export function zxwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.x, a.w);
}

export function wxwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.x, a.w);
}

export function xywu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.y, a.w);
}

export function yywu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.y, a.w);
}

export function zywu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.y, a.w);
}

export function wywu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.y, a.w);
}

export function xzwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.z, a.w);
}

export function yzwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.z, a.w);
}

export function zzwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.z, a.w);
}

export function wzwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.z, a.w);
}

export function xwwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.x, a.w, a.w);
}

export function ywwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.y, a.w, a.w);
}

export function zwwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.z, a.w, a.w);
}

export function wwwu(a: Vector, out ?: Vector3u.Mutable) {
  return out3u(out, a.w, a.w, a.w);
}

//swizzle3i
export function xxxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.x, a.x);
}

export function yxxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.x, a.x);
}

export function zxxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.x, a.x);
}

export function wxxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.x, a.x);
}

export function xyxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.y, a.x);
}

export function yyxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.y, a.x);
}

export function zyxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.y, a.x);
}

export function wyxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.y, a.x);
}

export function xzxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.z, a.x);
}

export function yzxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.z, a.x);
}

export function zzxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.z, a.x);
}

export function wzxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.z, a.x);
}

export function xwxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.w, a.x);
}

export function ywxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.w, a.x);
}

export function zwxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.w, a.x);
}

export function wwxi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.w, a.x);
}

export function xxyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.x, a.y);
}

export function yxyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.x, a.y);
}

export function zxyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.x, a.y);
}

export function wxyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.x, a.y);
}

export function xyyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.y, a.y);
}

export function yyyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.y, a.y);
}

export function zyyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.y, a.y);
}

export function wyyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.y, a.y);
}

export function xzyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.z, a.y);
}

export function yzyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.z, a.y);
}

export function zzyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.z, a.y);
}

export function wzyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.z, a.y);
}

export function xwyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.w, a.y);
}

export function ywyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.w, a.y);
}

export function zwyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.w, a.y);
}

export function wwyi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.w, a.y);
}

export function xxzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.x, a.z);
}

export function yxzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.x, a.z);
}

export function zxzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.x, a.z);
}

export function wxzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.x, a.z);
}

export function xyzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.y, a.z);
}

export function yyzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.y, a.z);
}

export function zyzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.y, a.z);
}

export function wyzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.y, a.z);
}

export function xzzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.z, a.z);
}

export function yzzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.z, a.z);
}

export function zzzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.z, a.z);
}

export function wzzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.z, a.z);
}

export function xwzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.w, a.z);
}

export function ywzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.w, a.z);
}

export function zwzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.w, a.z);
}

export function wwzi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.w, a.z);
}

export function xxwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.x, a.w);
}

export function yxwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.x, a.w);
}

export function zxwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.x, a.w);
}

export function wxwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.x, a.w);
}

export function xywi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.y, a.w);
}

export function yywi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.y, a.w);
}

export function zywi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.y, a.w);
}

export function wywi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.y, a.w);
}

export function xzwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.z, a.w);
}

export function yzwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.z, a.w);
}

export function zzwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.z, a.w);
}

export function wzwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.z, a.w);
}

export function xwwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.x, a.w, a.w);
}

export function ywwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.y, a.w, a.w);
}

export function zwwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.z, a.w, a.w);
}

export function wwwi(a: Vector, out ?: Vector3i.Mutable) {
  return out3i(out, a.w, a.w, a.w);
}

//swizzle4f
export function xxxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.x, a.x);
}

export function yxxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.x, a.x);
}

export function zxxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.x, a.x);
}

export function wxxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.x, a.x);
}

export function xyxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.x, a.x);
}

export function yyxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.x, a.x);
}

export function zyxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.x, a.x);
}

export function wyxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.x, a.x);
}

export function xzxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.x, a.x);
}

export function yzxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.x, a.x);
}

export function zzxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.x, a.x);
}

export function wzxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.x, a.x);
}

export function xwxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.x, a.x);
}

export function ywxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.x, a.x);
}

export function zwxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.x, a.x);
}

export function wwxxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.x, a.x);
}

export function xxyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.y, a.x);
}

export function yxyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.y, a.x);
}

export function zxyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.y, a.x);
}

export function wxyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.y, a.x);
}

export function xyyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.y, a.x);
}

export function yyyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.y, a.x);
}

export function zyyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.y, a.x);
}

export function wyyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.y, a.x);
}

export function xzyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.y, a.x);
}

export function yzyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.y, a.x);
}

export function zzyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.y, a.x);
}

export function wzyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.y, a.x);
}

export function xwyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.y, a.x);
}

export function ywyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.y, a.x);
}

export function zwyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.y, a.x);
}

export function wwyxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.y, a.x);
}

export function xxzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.z, a.x);
}

export function yxzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.z, a.x);
}

export function zxzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.z, a.x);
}

export function wxzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.z, a.x);
}

export function xyzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.z, a.x);
}

export function yyzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.z, a.x);
}

export function zyzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.z, a.x);
}

export function wyzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.z, a.x);
}

export function xzzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.z, a.x);
}

export function yzzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.z, a.x);
}

export function zzzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.z, a.x);
}

export function wzzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.z, a.x);
}

export function xwzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.z, a.x);
}

export function ywzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.z, a.x);
}

export function zwzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.z, a.x);
}

export function wwzxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.z, a.x);
}

export function xxwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.w, a.x);
}

export function yxwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.w, a.x);
}

export function zxwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.w, a.x);
}

export function wxwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.w, a.x);
}

export function xywxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.w, a.x);
}

export function yywxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.w, a.x);
}

export function zywxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.w, a.x);
}

export function wywxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.w, a.x);
}

export function xzwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.w, a.x);
}

export function yzwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.w, a.x);
}

export function zzwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.w, a.x);
}

export function wzwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.w, a.x);
}

export function xwwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.w, a.x);
}

export function ywwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.w, a.x);
}

export function zwwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.w, a.x);
}

export function wwwxf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.w, a.x);
}

export function xxxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.x, a.y);
}

export function yxxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.x, a.y);
}

export function zxxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.x, a.y);
}

export function wxxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.x, a.y);
}

export function xyxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.x, a.y);
}

export function yyxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.x, a.y);
}

export function zyxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.x, a.y);
}

export function wyxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.x, a.y);
}

export function xzxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.x, a.y);
}

export function yzxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.x, a.y);
}

export function zzxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.x, a.y);
}

export function wzxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.x, a.y);
}

export function xwxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.x, a.y);
}

export function ywxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.x, a.y);
}

export function zwxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.x, a.y);
}

export function wwxyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.x, a.y);
}

export function xxyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.y, a.y);
}

export function yxyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.y, a.y);
}

export function zxyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.y, a.y);
}

export function wxyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.y, a.y);
}

export function xyyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.y, a.y);
}

export function yyyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.y, a.y);
}

export function zyyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.y, a.y);
}

export function wyyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.y, a.y);
}

export function xzyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.y, a.y);
}

export function yzyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.y, a.y);
}

export function zzyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.y, a.y);
}

export function wzyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.y, a.y);
}

export function xwyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.y, a.y);
}

export function ywyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.y, a.y);
}

export function zwyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.y, a.y);
}

export function wwyyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.y, a.y);
}

export function xxzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.z, a.y);
}

export function yxzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.z, a.y);
}

export function zxzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.z, a.y);
}

export function wxzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.z, a.y);
}

export function xyzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.z, a.y);
}

export function yyzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.z, a.y);
}

export function zyzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.z, a.y);
}

export function wyzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.z, a.y);
}

export function xzzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.z, a.y);
}

export function yzzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.z, a.y);
}

export function zzzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.z, a.y);
}

export function wzzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.z, a.y);
}

export function xwzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.z, a.y);
}

export function ywzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.z, a.y);
}

export function zwzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.z, a.y);
}

export function wwzyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.z, a.y);
}

export function xxwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.w, a.y);
}

export function yxwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.w, a.y);
}

export function zxwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.w, a.y);
}

export function wxwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.w, a.y);
}

export function xywyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.w, a.y);
}

export function yywyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.w, a.y);
}

export function zywyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.w, a.y);
}

export function wywyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.w, a.y);
}

export function xzwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.w, a.y);
}

export function yzwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.w, a.y);
}

export function zzwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.w, a.y);
}

export function wzwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.w, a.y);
}

export function xwwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.w, a.y);
}

export function ywwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.w, a.y);
}

export function zwwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.w, a.y);
}

export function wwwyf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.w, a.y);
}

export function xxxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.x, a.z);
}

export function yxxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.x, a.z);
}

export function zxxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.x, a.z);
}

export function wxxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.x, a.z);
}

export function xyxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.x, a.z);
}

export function yyxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.x, a.z);
}

export function zyxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.x, a.z);
}

export function wyxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.x, a.z);
}

export function xzxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.x, a.z);
}

export function yzxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.x, a.z);
}

export function zzxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.x, a.z);
}

export function wzxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.x, a.z);
}

export function xwxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.x, a.z);
}

export function ywxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.x, a.z);
}

export function zwxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.x, a.z);
}

export function wwxzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.x, a.z);
}

export function xxyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.y, a.z);
}

export function yxyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.y, a.z);
}

export function zxyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.y, a.z);
}

export function wxyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.y, a.z);
}

export function xyyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.y, a.z);
}

export function yyyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.y, a.z);
}

export function zyyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.y, a.z);
}

export function wyyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.y, a.z);
}

export function xzyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.y, a.z);
}

export function yzyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.y, a.z);
}

export function zzyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.y, a.z);
}

export function wzyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.y, a.z);
}

export function xwyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.y, a.z);
}

export function ywyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.y, a.z);
}

export function zwyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.y, a.z);
}

export function wwyzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.y, a.z);
}

export function xxzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.z, a.z);
}

export function yxzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.z, a.z);
}

export function zxzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.z, a.z);
}

export function wxzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.z, a.z);
}

export function xyzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.z, a.z);
}

export function yyzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.z, a.z);
}

export function zyzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.z, a.z);
}

export function wyzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.z, a.z);
}

export function xzzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.z, a.z);
}

export function yzzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.z, a.z);
}

export function zzzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.z, a.z);
}

export function wzzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.z, a.z);
}

export function xwzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.z, a.z);
}

export function ywzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.z, a.z);
}

export function zwzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.z, a.z);
}

export function wwzzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.z, a.z);
}

export function xxwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.w, a.z);
}

export function yxwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.w, a.z);
}

export function zxwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.w, a.z);
}

export function wxwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.w, a.z);
}

export function xywzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.w, a.z);
}

export function yywzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.w, a.z);
}

export function zywzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.w, a.z);
}

export function wywzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.w, a.z);
}

export function xzwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.w, a.z);
}

export function yzwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.w, a.z);
}

export function zzwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.w, a.z);
}

export function wzwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.w, a.z);
}

export function xwwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.w, a.z);
}

export function ywwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.w, a.z);
}

export function zwwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.w, a.z);
}

export function wwwzf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.w, a.z);
}

export function xxxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.x, a.w);
}

export function yxxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.x, a.w);
}

export function zxxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.x, a.w);
}

export function wxxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.x, a.w);
}

export function xyxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.x, a.w);
}

export function yyxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.x, a.w);
}

export function zyxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.x, a.w);
}

export function wyxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.x, a.w);
}

export function xzxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.x, a.w);
}

export function yzxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.x, a.w);
}

export function zzxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.x, a.w);
}

export function wzxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.x, a.w);
}

export function xwxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.x, a.w);
}

export function ywxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.x, a.w);
}

export function zwxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.x, a.w);
}

export function wwxwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.x, a.w);
}

export function xxywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.y, a.w);
}

export function yxywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.y, a.w);
}

export function zxywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.y, a.w);
}

export function wxywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.y, a.w);
}

export function xyywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.y, a.w);
}

export function yyywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.y, a.w);
}

export function zyywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.y, a.w);
}

export function wyywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.y, a.w);
}

export function xzywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.y, a.w);
}

export function yzywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.y, a.w);
}

export function zzywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.y, a.w);
}

export function wzywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.y, a.w);
}

export function xwywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.y, a.w);
}

export function ywywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.y, a.w);
}

export function zwywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.y, a.w);
}

export function wwywf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.y, a.w);
}

export function xxzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.z, a.w);
}

export function yxzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.z, a.w);
}

export function zxzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.z, a.w);
}

export function wxzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.z, a.w);
}

export function xyzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.z, a.w);
}

export function yyzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.z, a.w);
}

export function zyzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.z, a.w);
}

export function wyzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.z, a.w);
}

export function xzzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.z, a.w);
}

export function yzzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.z, a.w);
}

export function zzzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.z, a.w);
}

export function wzzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.z, a.w);
}

export function xwzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.z, a.w);
}

export function ywzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.z, a.w);
}

export function zwzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.z, a.w);
}

export function wwzwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.z, a.w);
}

export function xxwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.x, a.w, a.w);
}

export function yxwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.x, a.w, a.w);
}

export function zxwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.x, a.w, a.w);
}

export function wxwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.x, a.w, a.w);
}

export function xywwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.y, a.w, a.w);
}

export function yywwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.y, a.w, a.w);
}

export function zywwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.y, a.w, a.w);
}

export function wywwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.y, a.w, a.w);
}

export function xzwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.z, a.w, a.w);
}

export function yzwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.z, a.w, a.w);
}

export function zzwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.z, a.w, a.w);
}

export function wzwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.z, a.w, a.w);
}

export function xwwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.x, a.w, a.w, a.w);
}

export function ywwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.y, a.w, a.w, a.w);
}

export function zwwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.z, a.w, a.w, a.w);
}

export function wwwwf(a: Vector, out ?: Vector4f.Mutable) {
  return out4f(out, a.w, a.w, a.w, a.w);
}

//swizzle4u
export function xxxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.x, a.x);
}

export function yxxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.x, a.x);
}

export function zxxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.x, a.x);
}

export function wxxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.x, a.x);
}

export function xyxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.x, a.x);
}

export function yyxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.x, a.x);
}

export function zyxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.x, a.x);
}

export function wyxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.x, a.x);
}

export function xzxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.x, a.x);
}

export function yzxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.x, a.x);
}

export function zzxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.x, a.x);
}

export function wzxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.x, a.x);
}

export function xwxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.x, a.x);
}

export function ywxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.x, a.x);
}

export function zwxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.x, a.x);
}

export function wwxxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.x, a.x);
}

export function xxyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.y, a.x);
}

export function yxyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.y, a.x);
}

export function zxyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.y, a.x);
}

export function wxyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.y, a.x);
}

export function xyyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.y, a.x);
}

export function yyyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.y, a.x);
}

export function zyyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.y, a.x);
}

export function wyyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.y, a.x);
}

export function xzyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.y, a.x);
}

export function yzyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.y, a.x);
}

export function zzyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.y, a.x);
}

export function wzyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.y, a.x);
}

export function xwyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.y, a.x);
}

export function ywyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.y, a.x);
}

export function zwyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.y, a.x);
}

export function wwyxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.y, a.x);
}

export function xxzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.z, a.x);
}

export function yxzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.z, a.x);
}

export function zxzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.z, a.x);
}

export function wxzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.z, a.x);
}

export function xyzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.z, a.x);
}

export function yyzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.z, a.x);
}

export function zyzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.z, a.x);
}

export function wyzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.z, a.x);
}

export function xzzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.z, a.x);
}

export function yzzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.z, a.x);
}

export function zzzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.z, a.x);
}

export function wzzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.z, a.x);
}

export function xwzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.z, a.x);
}

export function ywzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.z, a.x);
}

export function zwzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.z, a.x);
}

export function wwzxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.z, a.x);
}

export function xxwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.w, a.x);
}

export function yxwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.w, a.x);
}

export function zxwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.w, a.x);
}

export function wxwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.w, a.x);
}

export function xywxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.w, a.x);
}

export function yywxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.w, a.x);
}

export function zywxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.w, a.x);
}

export function wywxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.w, a.x);
}

export function xzwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.w, a.x);
}

export function yzwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.w, a.x);
}

export function zzwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.w, a.x);
}

export function wzwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.w, a.x);
}

export function xwwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.w, a.x);
}

export function ywwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.w, a.x);
}

export function zwwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.w, a.x);
}

export function wwwxu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.w, a.x);
}

export function xxxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.x, a.y);
}

export function yxxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.x, a.y);
}

export function zxxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.x, a.y);
}

export function wxxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.x, a.y);
}

export function xyxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.x, a.y);
}

export function yyxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.x, a.y);
}

export function zyxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.x, a.y);
}

export function wyxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.x, a.y);
}

export function xzxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.x, a.y);
}

export function yzxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.x, a.y);
}

export function zzxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.x, a.y);
}

export function wzxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.x, a.y);
}

export function xwxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.x, a.y);
}

export function ywxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.x, a.y);
}

export function zwxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.x, a.y);
}

export function wwxyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.x, a.y);
}

export function xxyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.y, a.y);
}

export function yxyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.y, a.y);
}

export function zxyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.y, a.y);
}

export function wxyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.y, a.y);
}

export function xyyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.y, a.y);
}

export function yyyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.y, a.y);
}

export function zyyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.y, a.y);
}

export function wyyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.y, a.y);
}

export function xzyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.y, a.y);
}

export function yzyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.y, a.y);
}

export function zzyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.y, a.y);
}

export function wzyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.y, a.y);
}

export function xwyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.y, a.y);
}

export function ywyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.y, a.y);
}

export function zwyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.y, a.y);
}

export function wwyyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.y, a.y);
}

export function xxzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.z, a.y);
}

export function yxzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.z, a.y);
}

export function zxzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.z, a.y);
}

export function wxzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.z, a.y);
}

export function xyzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.z, a.y);
}

export function yyzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.z, a.y);
}

export function zyzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.z, a.y);
}

export function wyzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.z, a.y);
}

export function xzzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.z, a.y);
}

export function yzzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.z, a.y);
}

export function zzzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.z, a.y);
}

export function wzzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.z, a.y);
}

export function xwzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.z, a.y);
}

export function ywzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.z, a.y);
}

export function zwzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.z, a.y);
}

export function wwzyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.z, a.y);
}

export function xxwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.w, a.y);
}

export function yxwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.w, a.y);
}

export function zxwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.w, a.y);
}

export function wxwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.w, a.y);
}

export function xywyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.w, a.y);
}

export function yywyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.w, a.y);
}

export function zywyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.w, a.y);
}

export function wywyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.w, a.y);
}

export function xzwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.w, a.y);
}

export function yzwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.w, a.y);
}

export function zzwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.w, a.y);
}

export function wzwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.w, a.y);
}

export function xwwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.w, a.y);
}

export function ywwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.w, a.y);
}

export function zwwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.w, a.y);
}

export function wwwyu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.w, a.y);
}

export function xxxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.x, a.z);
}

export function yxxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.x, a.z);
}

export function zxxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.x, a.z);
}

export function wxxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.x, a.z);
}

export function xyxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.x, a.z);
}

export function yyxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.x, a.z);
}

export function zyxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.x, a.z);
}

export function wyxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.x, a.z);
}

export function xzxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.x, a.z);
}

export function yzxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.x, a.z);
}

export function zzxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.x, a.z);
}

export function wzxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.x, a.z);
}

export function xwxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.x, a.z);
}

export function ywxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.x, a.z);
}

export function zwxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.x, a.z);
}

export function wwxzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.x, a.z);
}

export function xxyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.y, a.z);
}

export function yxyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.y, a.z);
}

export function zxyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.y, a.z);
}

export function wxyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.y, a.z);
}

export function xyyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.y, a.z);
}

export function yyyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.y, a.z);
}

export function zyyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.y, a.z);
}

export function wyyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.y, a.z);
}

export function xzyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.y, a.z);
}

export function yzyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.y, a.z);
}

export function zzyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.y, a.z);
}

export function wzyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.y, a.z);
}

export function xwyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.y, a.z);
}

export function ywyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.y, a.z);
}

export function zwyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.y, a.z);
}

export function wwyzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.y, a.z);
}

export function xxzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.z, a.z);
}

export function yxzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.z, a.z);
}

export function zxzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.z, a.z);
}

export function wxzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.z, a.z);
}

export function xyzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.z, a.z);
}

export function yyzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.z, a.z);
}

export function zyzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.z, a.z);
}

export function wyzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.z, a.z);
}

export function xzzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.z, a.z);
}

export function yzzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.z, a.z);
}

export function zzzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.z, a.z);
}

export function wzzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.z, a.z);
}

export function xwzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.z, a.z);
}

export function ywzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.z, a.z);
}

export function zwzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.z, a.z);
}

export function wwzzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.z, a.z);
}

export function xxwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.w, a.z);
}

export function yxwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.w, a.z);
}

export function zxwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.w, a.z);
}

export function wxwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.w, a.z);
}

export function xywzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.w, a.z);
}

export function yywzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.w, a.z);
}

export function zywzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.w, a.z);
}

export function wywzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.w, a.z);
}

export function xzwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.w, a.z);
}

export function yzwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.w, a.z);
}

export function zzwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.w, a.z);
}

export function wzwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.w, a.z);
}

export function xwwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.w, a.z);
}

export function ywwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.w, a.z);
}

export function zwwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.w, a.z);
}

export function wwwzu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.w, a.z);
}

export function xxxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.x, a.w);
}

export function yxxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.x, a.w);
}

export function zxxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.x, a.w);
}

export function wxxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.x, a.w);
}

export function xyxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.x, a.w);
}

export function yyxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.x, a.w);
}

export function zyxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.x, a.w);
}

export function wyxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.x, a.w);
}

export function xzxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.x, a.w);
}

export function yzxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.x, a.w);
}

export function zzxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.x, a.w);
}

export function wzxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.x, a.w);
}

export function xwxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.x, a.w);
}

export function ywxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.x, a.w);
}

export function zwxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.x, a.w);
}

export function wwxwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.x, a.w);
}

export function xxywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.y, a.w);
}

export function yxywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.y, a.w);
}

export function zxywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.y, a.w);
}

export function wxywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.y, a.w);
}

export function xyywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.y, a.w);
}

export function yyywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.y, a.w);
}

export function zyywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.y, a.w);
}

export function wyywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.y, a.w);
}

export function xzywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.y, a.w);
}

export function yzywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.y, a.w);
}

export function zzywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.y, a.w);
}

export function wzywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.y, a.w);
}

export function xwywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.y, a.w);
}

export function ywywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.y, a.w);
}

export function zwywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.y, a.w);
}

export function wwywu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.y, a.w);
}

export function xxzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.z, a.w);
}

export function yxzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.z, a.w);
}

export function zxzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.z, a.w);
}

export function wxzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.z, a.w);
}

export function xyzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.z, a.w);
}

export function yyzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.z, a.w);
}

export function zyzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.z, a.w);
}

export function wyzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.z, a.w);
}

export function xzzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.z, a.w);
}

export function yzzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.z, a.w);
}

export function zzzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.z, a.w);
}

export function wzzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.z, a.w);
}

export function xwzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.z, a.w);
}

export function ywzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.z, a.w);
}

export function zwzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.z, a.w);
}

export function wwzwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.z, a.w);
}

export function xxwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.x, a.w, a.w);
}

export function yxwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.x, a.w, a.w);
}

export function zxwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.x, a.w, a.w);
}

export function wxwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.x, a.w, a.w);
}

export function xywwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.y, a.w, a.w);
}

export function yywwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.y, a.w, a.w);
}

export function zywwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.y, a.w, a.w);
}

export function wywwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.y, a.w, a.w);
}

export function xzwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.z, a.w, a.w);
}

export function yzwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.z, a.w, a.w);
}

export function zzwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.z, a.w, a.w);
}

export function wzwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.z, a.w, a.w);
}

export function xwwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.x, a.w, a.w, a.w);
}

export function ywwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.y, a.w, a.w, a.w);
}

export function zwwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.z, a.w, a.w, a.w);
}

export function wwwwu(a: Vector, out ?: Vector4u.Mutable) {
  return out4u(out, a.w, a.w, a.w, a.w);
}

//swizzle4i
export function xxxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.x, a.x);
}

export function yxxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.x, a.x);
}

export function zxxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.x, a.x);
}

export function wxxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.x, a.x);
}

export function xyxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.x, a.x);
}

export function yyxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.x, a.x);
}

export function zyxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.x, a.x);
}

export function wyxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.x, a.x);
}

export function xzxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.x, a.x);
}

export function yzxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.x, a.x);
}

export function zzxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.x, a.x);
}

export function wzxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.x, a.x);
}

export function xwxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.x, a.x);
}

export function ywxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.x, a.x);
}

export function zwxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.x, a.x);
}

export function wwxxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.x, a.x);
}

export function xxyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.y, a.x);
}

export function yxyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.y, a.x);
}

export function zxyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.y, a.x);
}

export function wxyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.y, a.x);
}

export function xyyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.y, a.x);
}

export function yyyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.y, a.x);
}

export function zyyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.y, a.x);
}

export function wyyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.y, a.x);
}

export function xzyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.y, a.x);
}

export function yzyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.y, a.x);
}

export function zzyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.y, a.x);
}

export function wzyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.y, a.x);
}

export function xwyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.y, a.x);
}

export function ywyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.y, a.x);
}

export function zwyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.y, a.x);
}

export function wwyxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.y, a.x);
}

export function xxzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.z, a.x);
}

export function yxzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.z, a.x);
}

export function zxzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.z, a.x);
}

export function wxzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.z, a.x);
}

export function xyzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.z, a.x);
}

export function yyzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.z, a.x);
}

export function zyzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.z, a.x);
}

export function wyzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.z, a.x);
}

export function xzzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.z, a.x);
}

export function yzzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.z, a.x);
}

export function zzzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.z, a.x);
}

export function wzzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.z, a.x);
}

export function xwzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.z, a.x);
}

export function ywzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.z, a.x);
}

export function zwzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.z, a.x);
}

export function wwzxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.z, a.x);
}

export function xxwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.w, a.x);
}

export function yxwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.w, a.x);
}

export function zxwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.w, a.x);
}

export function wxwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.w, a.x);
}

export function xywxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.w, a.x);
}

export function yywxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.w, a.x);
}

export function zywxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.w, a.x);
}

export function wywxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.w, a.x);
}

export function xzwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.w, a.x);
}

export function yzwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.w, a.x);
}

export function zzwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.w, a.x);
}

export function wzwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.w, a.x);
}

export function xwwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.w, a.x);
}

export function ywwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.w, a.x);
}

export function zwwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.w, a.x);
}

export function wwwxi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.w, a.x);
}

export function xxxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.x, a.y);
}

export function yxxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.x, a.y);
}

export function zxxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.x, a.y);
}

export function wxxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.x, a.y);
}

export function xyxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.x, a.y);
}

export function yyxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.x, a.y);
}

export function zyxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.x, a.y);
}

export function wyxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.x, a.y);
}

export function xzxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.x, a.y);
}

export function yzxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.x, a.y);
}

export function zzxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.x, a.y);
}

export function wzxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.x, a.y);
}

export function xwxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.x, a.y);
}

export function ywxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.x, a.y);
}

export function zwxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.x, a.y);
}

export function wwxyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.x, a.y);
}

export function xxyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.y, a.y);
}

export function yxyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.y, a.y);
}

export function zxyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.y, a.y);
}

export function wxyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.y, a.y);
}

export function xyyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.y, a.y);
}

export function yyyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.y, a.y);
}

export function zyyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.y, a.y);
}

export function wyyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.y, a.y);
}

export function xzyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.y, a.y);
}

export function yzyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.y, a.y);
}

export function zzyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.y, a.y);
}

export function wzyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.y, a.y);
}

export function xwyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.y, a.y);
}

export function ywyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.y, a.y);
}

export function zwyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.y, a.y);
}

export function wwyyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.y, a.y);
}

export function xxzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.z, a.y);
}

export function yxzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.z, a.y);
}

export function zxzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.z, a.y);
}

export function wxzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.z, a.y);
}

export function xyzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.z, a.y);
}

export function yyzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.z, a.y);
}

export function zyzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.z, a.y);
}

export function wyzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.z, a.y);
}

export function xzzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.z, a.y);
}

export function yzzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.z, a.y);
}

export function zzzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.z, a.y);
}

export function wzzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.z, a.y);
}

export function xwzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.z, a.y);
}

export function ywzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.z, a.y);
}

export function zwzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.z, a.y);
}

export function wwzyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.z, a.y);
}

export function xxwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.w, a.y);
}

export function yxwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.w, a.y);
}

export function zxwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.w, a.y);
}

export function wxwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.w, a.y);
}

export function xywyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.w, a.y);
}

export function yywyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.w, a.y);
}

export function zywyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.w, a.y);
}

export function wywyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.w, a.y);
}

export function xzwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.w, a.y);
}

export function yzwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.w, a.y);
}

export function zzwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.w, a.y);
}

export function wzwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.w, a.y);
}

export function xwwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.w, a.y);
}

export function ywwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.w, a.y);
}

export function zwwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.w, a.y);
}

export function wwwyi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.w, a.y);
}

export function xxxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.x, a.z);
}

export function yxxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.x, a.z);
}

export function zxxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.x, a.z);
}

export function wxxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.x, a.z);
}

export function xyxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.x, a.z);
}

export function yyxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.x, a.z);
}

export function zyxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.x, a.z);
}

export function wyxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.x, a.z);
}

export function xzxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.x, a.z);
}

export function yzxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.x, a.z);
}

export function zzxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.x, a.z);
}

export function wzxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.x, a.z);
}

export function xwxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.x, a.z);
}

export function ywxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.x, a.z);
}

export function zwxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.x, a.z);
}

export function wwxzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.x, a.z);
}

export function xxyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.y, a.z);
}

export function yxyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.y, a.z);
}

export function zxyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.y, a.z);
}

export function wxyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.y, a.z);
}

export function xyyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.y, a.z);
}

export function yyyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.y, a.z);
}

export function zyyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.y, a.z);
}

export function wyyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.y, a.z);
}

export function xzyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.y, a.z);
}

export function yzyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.y, a.z);
}

export function zzyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.y, a.z);
}

export function wzyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.y, a.z);
}

export function xwyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.y, a.z);
}

export function ywyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.y, a.z);
}

export function zwyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.y, a.z);
}

export function wwyzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.y, a.z);
}

export function xxzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.z, a.z);
}

export function yxzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.z, a.z);
}

export function zxzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.z, a.z);
}

export function wxzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.z, a.z);
}

export function xyzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.z, a.z);
}

export function yyzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.z, a.z);
}

export function zyzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.z, a.z);
}

export function wyzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.z, a.z);
}

export function xzzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.z, a.z);
}

export function yzzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.z, a.z);
}

export function zzzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.z, a.z);
}

export function wzzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.z, a.z);
}

export function xwzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.z, a.z);
}

export function ywzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.z, a.z);
}

export function zwzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.z, a.z);
}

export function wwzzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.z, a.z);
}

export function xxwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.w, a.z);
}

export function yxwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.w, a.z);
}

export function zxwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.w, a.z);
}

export function wxwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.w, a.z);
}

export function xywzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.w, a.z);
}

export function yywzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.w, a.z);
}

export function zywzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.w, a.z);
}

export function wywzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.w, a.z);
}

export function xzwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.w, a.z);
}

export function yzwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.w, a.z);
}

export function zzwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.w, a.z);
}

export function wzwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.w, a.z);
}

export function xwwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.w, a.z);
}

export function ywwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.w, a.z);
}

export function zwwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.w, a.z);
}

export function wwwzi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.w, a.z);
}

export function xxxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.x, a.w);
}

export function yxxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.x, a.w);
}

export function zxxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.x, a.w);
}

export function wxxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.x, a.w);
}

export function xyxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.x, a.w);
}

export function yyxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.x, a.w);
}

export function zyxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.x, a.w);
}

export function wyxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.x, a.w);
}

export function xzxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.x, a.w);
}

export function yzxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.x, a.w);
}

export function zzxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.x, a.w);
}

export function wzxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.x, a.w);
}

export function xwxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.x, a.w);
}

export function ywxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.x, a.w);
}

export function zwxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.x, a.w);
}

export function wwxwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.x, a.w);
}

export function xxywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.y, a.w);
}

export function yxywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.y, a.w);
}

export function zxywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.y, a.w);
}

export function wxywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.y, a.w);
}

export function xyywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.y, a.w);
}

export function yyywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.y, a.w);
}

export function zyywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.y, a.w);
}

export function wyywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.y, a.w);
}

export function xzywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.y, a.w);
}

export function yzywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.y, a.w);
}

export function zzywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.y, a.w);
}

export function wzywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.y, a.w);
}

export function xwywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.y, a.w);
}

export function ywywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.y, a.w);
}

export function zwywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.y, a.w);
}

export function wwywi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.y, a.w);
}

export function xxzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.z, a.w);
}

export function yxzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.z, a.w);
}

export function zxzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.z, a.w);
}

export function wxzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.z, a.w);
}

export function xyzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.z, a.w);
}

export function yyzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.z, a.w);
}

export function zyzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.z, a.w);
}

export function wyzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.z, a.w);
}

export function xzzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.z, a.w);
}

export function yzzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.z, a.w);
}

export function zzzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.z, a.w);
}

export function wzzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.z, a.w);
}

export function xwzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.z, a.w);
}

export function ywzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.z, a.w);
}

export function zwzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.z, a.w);
}

export function wwzwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.z, a.w);
}

export function xxwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.x, a.w, a.w);
}

export function yxwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.x, a.w, a.w);
}

export function zxwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.x, a.w, a.w);
}

export function wxwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.x, a.w, a.w);
}

export function xywwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.y, a.w, a.w);
}

export function yywwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.y, a.w, a.w);
}

export function zywwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.y, a.w, a.w);
}

export function wywwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.y, a.w, a.w);
}

export function xzwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.z, a.w, a.w);
}

export function yzwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.z, a.w, a.w);
}

export function zzwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.z, a.w, a.w);
}

export function wzwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.z, a.w, a.w);
}

export function xwwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.x, a.w, a.w, a.w);
}

export function ywwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.y, a.w, a.w, a.w);
}

export function zwwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.z, a.w, a.w, a.w);
}

export function wwwwi(a: Vector, out ?: Vector4i.Mutable) {
  return out4i(out, a.w, a.w, a.w, a.w);
}