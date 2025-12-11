import { Constructor } from "../../util/types";

import * as swz from "./ops/swz";
import { Vector2f, Vector2i, Vector2u } from "./vector2";
import { Vector3f, Vector3i, Vector3u } from "./vector3";
import { Vector4f, Vector4i, Vector4u } from "./vector4";

export interface Vector extends Iterable<number> {
  get x(): number;
  get y(): number;
  get z(): number;
  get w(): number;
}

export namespace Vector {
  export type Type = Float32Array | Uint32Array | Int32Array;
  export type Size = 2 | 3 | 4;

  export interface OfType<T extends Type> {
    readonly __buffer__: T;
  }

  export interface OfSize<N extends Size> {
    get n(): N;
  }

  export interface Mutable extends Vector {
    set x(x: number);
    set y(y: number);
    set z(z: number);
    set w(w: number);
  }
}

export const __get__ = {
  x(a: Vector.OfType<any>) { return a.__buffer__[0] ?? 0; },
  y(a: Vector.OfType<any>) { return a.__buffer__[1] ?? 0; },
  z(a: Vector.OfType<any>) { return a.__buffer__[2] ?? 0; },
  w(a: Vector.OfType<any>) { return a.__buffer__[3] ?? 0; },
  n(a: Vector.OfType<any>) { return a.__buffer__.length;  },
} as const;

export const __set__ = {
  x(a: Vector.OfType<any>, x: number) { a.__buffer__[0] = x; },
  y(a: Vector.OfType<any>, y: number) { a.__buffer__[1] = y; },
  z(a: Vector.OfType<any>, z: number) { a.__buffer__[2] = z; },
  w(a: Vector.OfType<any>, w: number) { a.__buffer__[3] = w; },

  xy<T extends Vector.OfType<any>>(a: T, x ?: number, y ?: number) {
    const buffer = a.__buffer__;
    if (y === undefined) {
      x = x ?? 0;
      buffer[0] = x;
      buffer[1] = x;
    } else {
      buffer[0] = x ?? 0;
      buffer[1] = y ?? 0;
    }
    return a;
  },

  xyz<T extends Vector.OfType<any>>(a: T, x=0, y=x||0, z=y||0) {
    const buffer = a.__buffer__;
    if (
      y === undefined && 
      z === undefined
    ) {
      x = x ?? 0;
      buffer[0] = x;
      buffer[1] = x;
      buffer[2] = x;
    } else {
      buffer[0] = x ?? 0;
      buffer[1] = y ?? 0;
      buffer[2] = z ?? 0;
    }
    return a;
  },

  xyzw<T extends Vector.OfType<any>>(a: T, x=0, y=x, z=x, w=x) {
    const buffer = a.__buffer__;
    if (
      y === undefined && 
      z === undefined && 
      w === undefined
    ) {
      x = x ?? 0;
      buffer[0] = x;
      buffer[1] = x;
      buffer[2] = x;
      buffer[3] = x;
    } else {
      buffer[0] = x ?? 0;
      buffer[1] = y ?? 0;
      buffer[2] = z ?? 0;
      buffer[3] = w ?? 0;
    }
    return a;
  },
} as const;

export abstract class Variant<T extends Vector.Type, N extends Vector.Size>  {
  readonly __buffer__: T;

  constructor(T: Constructor<T>, n: N) {
    this.__buffer__ = new T(n);
  }

  get x(): number { return __get__.x(this); }
  get y(): number { return __get__.y(this); }
  get z(): number { return __get__.z(this); }
  get w(): number { return __get__.w(this); }
  get n(): N      { return __get__.n(this); }

  [Symbol.iterator](): Iterator<number> {
    return this.__buffer__.values();
  }

  //swizzle2f
  get xxf(): Vector2f { return swz.xxf(this); }
  get yxf(): Vector2f { return swz.yxf(this); }
  get zxf(): Vector2f { return swz.zxf(this); }
  get wxf(): Vector2f { return swz.wxf(this); }
  get xyf(): Vector2f { return swz.xyf(this); }
  get yyf(): Vector2f { return swz.yyf(this); }
  get zyf(): Vector2f { return swz.zyf(this); }
  get wyf(): Vector2f { return swz.wyf(this); }
  get xzf(): Vector2f { return swz.xzf(this); }
  get yzf(): Vector2f { return swz.yzf(this); }
  get zzf(): Vector2f { return swz.zzf(this); }
  get wzf(): Vector2f { return swz.wzf(this); }
  get xwf(): Vector2f { return swz.xwf(this); }
  get ywf(): Vector2f { return swz.ywf(this); }
  get zwf(): Vector2f { return swz.zwf(this); }
  get wwf(): Vector2f { return swz.wwf(this); }
  //swizzle2u
  get xxu(): Vector2u { return swz.xxu(this); }
  get yxu(): Vector2u { return swz.yxu(this); }
  get zxu(): Vector2u { return swz.zxu(this); }
  get wxu(): Vector2u { return swz.wxu(this); }
  get xyu(): Vector2u { return swz.xyu(this); }
  get yyu(): Vector2u { return swz.yyu(this); }
  get zyu(): Vector2u { return swz.zyu(this); }
  get wyu(): Vector2u { return swz.wyu(this); }
  get xzu(): Vector2u { return swz.xzu(this); }
  get yzu(): Vector2u { return swz.yzu(this); }
  get zzu(): Vector2u { return swz.zzu(this); }
  get wzu(): Vector2u { return swz.wzu(this); }
  get xwu(): Vector2u { return swz.xwu(this); }
  get ywu(): Vector2u { return swz.ywu(this); }
  get zwu(): Vector2u { return swz.zwu(this); }
  get wwu(): Vector2u { return swz.wwu(this); }
  //swizzle2i
  get xxi(): Vector2i { return swz.xxi(this); }
  get yxi(): Vector2i { return swz.yxi(this); }
  get zxi(): Vector2i { return swz.zxi(this); }
  get wxi(): Vector2i { return swz.wxi(this); }
  get xyi(): Vector2i { return swz.xyi(this); }
  get yyi(): Vector2i { return swz.yyi(this); }
  get zyi(): Vector2i { return swz.zyi(this); }
  get wyi(): Vector2i { return swz.wyi(this); }
  get xzi(): Vector2i { return swz.xzi(this); }
  get yzi(): Vector2i { return swz.yzi(this); }
  get zzi(): Vector2i { return swz.zzi(this); }
  get wzi(): Vector2i { return swz.wzi(this); }
  get xwi(): Vector2i { return swz.xwi(this); }
  get ywi(): Vector2i { return swz.ywi(this); }
  get zwi(): Vector2i { return swz.zwi(this); }
  get wwi(): Vector2i { return swz.wwi(this); }
  //swizzle3f
  get xxxf(): Vector3f { return swz.xxxf(this); }
  get yxxf(): Vector3f { return swz.yxxf(this); }
  get zxxf(): Vector3f { return swz.zxxf(this); }
  get wxxf(): Vector3f { return swz.wxxf(this); }
  get xyxf(): Vector3f { return swz.xyxf(this); }
  get yyxf(): Vector3f { return swz.yyxf(this); }
  get zyxf(): Vector3f { return swz.zyxf(this); }
  get wyxf(): Vector3f { return swz.wyxf(this); }
  get xzxf(): Vector3f { return swz.xzxf(this); }
  get yzxf(): Vector3f { return swz.yzxf(this); }
  get zzxf(): Vector3f { return swz.zzxf(this); }
  get wzxf(): Vector3f { return swz.wzxf(this); }
  get xwxf(): Vector3f { return swz.xwxf(this); }
  get ywxf(): Vector3f { return swz.ywxf(this); }
  get zwxf(): Vector3f { return swz.zwxf(this); }
  get wwxf(): Vector3f { return swz.wwxf(this); }
  get xxyf(): Vector3f { return swz.xxyf(this); }
  get yxyf(): Vector3f { return swz.yxyf(this); }
  get zxyf(): Vector3f { return swz.zxyf(this); }
  get wxyf(): Vector3f { return swz.wxyf(this); }
  get xyyf(): Vector3f { return swz.xyyf(this); }
  get yyyf(): Vector3f { return swz.yyyf(this); }
  get zyyf(): Vector3f { return swz.zyyf(this); }
  get wyyf(): Vector3f { return swz.wyyf(this); }
  get xzyf(): Vector3f { return swz.xzyf(this); }
  get yzyf(): Vector3f { return swz.yzyf(this); }
  get zzyf(): Vector3f { return swz.zzyf(this); }
  get wzyf(): Vector3f { return swz.wzyf(this); }
  get xwyf(): Vector3f { return swz.xwyf(this); }
  get ywyf(): Vector3f { return swz.ywyf(this); }
  get zwyf(): Vector3f { return swz.zwyf(this); }
  get wwyf(): Vector3f { return swz.wwyf(this); }
  get xxzf(): Vector3f { return swz.xxzf(this); }
  get yxzf(): Vector3f { return swz.yxzf(this); }
  get zxzf(): Vector3f { return swz.zxzf(this); }
  get wxzf(): Vector3f { return swz.wxzf(this); }
  get xyzf(): Vector3f { return swz.xyzf(this); }
  get yyzf(): Vector3f { return swz.yyzf(this); }
  get zyzf(): Vector3f { return swz.zyzf(this); }
  get wyzf(): Vector3f { return swz.wyzf(this); }
  get xzzf(): Vector3f { return swz.xzzf(this); }
  get yzzf(): Vector3f { return swz.yzzf(this); }
  get zzzf(): Vector3f { return swz.zzzf(this); }
  get wzzf(): Vector3f { return swz.wzzf(this); }
  get xwzf(): Vector3f { return swz.xwzf(this); }
  get ywzf(): Vector3f { return swz.ywzf(this); }
  get zwzf(): Vector3f { return swz.zwzf(this); }
  get wwzf(): Vector3f { return swz.wwzf(this); }
  get xxwf(): Vector3f { return swz.xxwf(this); }
  get yxwf(): Vector3f { return swz.yxwf(this); }
  get zxwf(): Vector3f { return swz.zxwf(this); }
  get wxwf(): Vector3f { return swz.wxwf(this); }
  get xywf(): Vector3f { return swz.xywf(this); }
  get yywf(): Vector3f { return swz.yywf(this); }
  get zywf(): Vector3f { return swz.zywf(this); }
  get wywf(): Vector3f { return swz.wywf(this); }
  get xzwf(): Vector3f { return swz.xzwf(this); }
  get yzwf(): Vector3f { return swz.yzwf(this); }
  get zzwf(): Vector3f { return swz.zzwf(this); }
  get wzwf(): Vector3f { return swz.wzwf(this); }
  get xwwf(): Vector3f { return swz.xwwf(this); }
  get ywwf(): Vector3f { return swz.ywwf(this); }
  get zwwf(): Vector3f { return swz.zwwf(this); }
  get wwwf(): Vector3f { return swz.wwwf(this); }
  //swizzle3u
  get xxxu(): Vector3u { return swz.xxxu(this); }
  get yxxu(): Vector3u { return swz.yxxu(this); }
  get zxxu(): Vector3u { return swz.zxxu(this); }
  get wxxu(): Vector3u { return swz.wxxu(this); }
  get xyxu(): Vector3u { return swz.xyxu(this); }
  get yyxu(): Vector3u { return swz.yyxu(this); }
  get zyxu(): Vector3u { return swz.zyxu(this); }
  get wyxu(): Vector3u { return swz.wyxu(this); }
  get xzxu(): Vector3u { return swz.xzxu(this); }
  get yzxu(): Vector3u { return swz.yzxu(this); }
  get zzxu(): Vector3u { return swz.zzxu(this); }
  get wzxu(): Vector3u { return swz.wzxu(this); }
  get xwxu(): Vector3u { return swz.xwxu(this); }
  get ywxu(): Vector3u { return swz.ywxu(this); }
  get zwxu(): Vector3u { return swz.zwxu(this); }
  get wwxu(): Vector3u { return swz.wwxu(this); }
  get xxyu(): Vector3u { return swz.xxyu(this); }
  get yxyu(): Vector3u { return swz.yxyu(this); }
  get zxyu(): Vector3u { return swz.zxyu(this); }
  get wxyu(): Vector3u { return swz.wxyu(this); }
  get xyyu(): Vector3u { return swz.xyyu(this); }
  get yyyu(): Vector3u { return swz.yyyu(this); }
  get zyyu(): Vector3u { return swz.zyyu(this); }
  get wyyu(): Vector3u { return swz.wyyu(this); }
  get xzyu(): Vector3u { return swz.xzyu(this); }
  get yzyu(): Vector3u { return swz.yzyu(this); }
  get zzyu(): Vector3u { return swz.zzyu(this); }
  get wzyu(): Vector3u { return swz.wzyu(this); }
  get xwyu(): Vector3u { return swz.xwyu(this); }
  get ywyu(): Vector3u { return swz.ywyu(this); }
  get zwyu(): Vector3u { return swz.zwyu(this); }
  get wwyu(): Vector3u { return swz.wwyu(this); }
  get xxzu(): Vector3u { return swz.xxzu(this); }
  get yxzu(): Vector3u { return swz.yxzu(this); }
  get zxzu(): Vector3u { return swz.zxzu(this); }
  get wxzu(): Vector3u { return swz.wxzu(this); }
  get xyzu(): Vector3u { return swz.xyzu(this); }
  get yyzu(): Vector3u { return swz.yyzu(this); }
  get zyzu(): Vector3u { return swz.zyzu(this); }
  get wyzu(): Vector3u { return swz.wyzu(this); }
  get xzzu(): Vector3u { return swz.xzzu(this); }
  get yzzu(): Vector3u { return swz.yzzu(this); }
  get zzzu(): Vector3u { return swz.zzzu(this); }
  get wzzu(): Vector3u { return swz.wzzu(this); }
  get xwzu(): Vector3u { return swz.xwzu(this); }
  get ywzu(): Vector3u { return swz.ywzu(this); }
  get zwzu(): Vector3u { return swz.zwzu(this); }
  get wwzu(): Vector3u { return swz.wwzu(this); }
  get xxwu(): Vector3u { return swz.xxwu(this); }
  get yxwu(): Vector3u { return swz.yxwu(this); }
  get zxwu(): Vector3u { return swz.zxwu(this); }
  get wxwu(): Vector3u { return swz.wxwu(this); }
  get xywu(): Vector3u { return swz.xywu(this); }
  get yywu(): Vector3u { return swz.yywu(this); }
  get zywu(): Vector3u { return swz.zywu(this); }
  get wywu(): Vector3u { return swz.wywu(this); }
  get xzwu(): Vector3u { return swz.xzwu(this); }
  get yzwu(): Vector3u { return swz.yzwu(this); }
  get zzwu(): Vector3u { return swz.zzwu(this); }
  get wzwu(): Vector3u { return swz.wzwu(this); }
  get xwwu(): Vector3u { return swz.xwwu(this); }
  get ywwu(): Vector3u { return swz.ywwu(this); }
  get zwwu(): Vector3u { return swz.zwwu(this); }
  get wwwu(): Vector3u { return swz.wwwu(this); }
  //swizzle3i
  get xxxi(): Vector3i { return swz.xxxi(this); }
  get yxxi(): Vector3i { return swz.yxxi(this); }
  get zxxi(): Vector3i { return swz.zxxi(this); }
  get wxxi(): Vector3i { return swz.wxxi(this); }
  get xyxi(): Vector3i { return swz.xyxi(this); }
  get yyxi(): Vector3i { return swz.yyxi(this); }
  get zyxi(): Vector3i { return swz.zyxi(this); }
  get wyxi(): Vector3i { return swz.wyxi(this); }
  get xzxi(): Vector3i { return swz.xzxi(this); }
  get yzxi(): Vector3i { return swz.yzxi(this); }
  get zzxi(): Vector3i { return swz.zzxi(this); }
  get wzxi(): Vector3i { return swz.wzxi(this); }
  get xwxi(): Vector3i { return swz.xwxi(this); }
  get ywxi(): Vector3i { return swz.ywxi(this); }
  get zwxi(): Vector3i { return swz.zwxi(this); }
  get wwxi(): Vector3i { return swz.wwxi(this); }
  get xxyi(): Vector3i { return swz.xxyi(this); }
  get yxyi(): Vector3i { return swz.yxyi(this); }
  get zxyi(): Vector3i { return swz.zxyi(this); }
  get wxyi(): Vector3i { return swz.wxyi(this); }
  get xyyi(): Vector3i { return swz.xyyi(this); }
  get yyyi(): Vector3i { return swz.yyyi(this); }
  get zyyi(): Vector3i { return swz.zyyi(this); }
  get wyyi(): Vector3i { return swz.wyyi(this); }
  get xzyi(): Vector3i { return swz.xzyi(this); }
  get yzyi(): Vector3i { return swz.yzyi(this); }
  get zzyi(): Vector3i { return swz.zzyi(this); }
  get wzyi(): Vector3i { return swz.wzyi(this); }
  get xwyi(): Vector3i { return swz.xwyi(this); }
  get ywyi(): Vector3i { return swz.ywyi(this); }
  get zwyi(): Vector3i { return swz.zwyi(this); }
  get wwyi(): Vector3i { return swz.wwyi(this); }
  get xxzi(): Vector3i { return swz.xxzi(this); }
  get yxzi(): Vector3i { return swz.yxzi(this); }
  get zxzi(): Vector3i { return swz.zxzi(this); }
  get wxzi(): Vector3i { return swz.wxzi(this); }
  get xyzi(): Vector3i { return swz.xyzi(this); }
  get yyzi(): Vector3i { return swz.yyzi(this); }
  get zyzi(): Vector3i { return swz.zyzi(this); }
  get wyzi(): Vector3i { return swz.wyzi(this); }
  get xzzi(): Vector3i { return swz.xzzi(this); }
  get yzzi(): Vector3i { return swz.yzzi(this); }
  get zzzi(): Vector3i { return swz.zzzi(this); }
  get wzzi(): Vector3i { return swz.wzzi(this); }
  get xwzi(): Vector3i { return swz.xwzi(this); }
  get ywzi(): Vector3i { return swz.ywzi(this); }
  get zwzi(): Vector3i { return swz.zwzi(this); }
  get wwzi(): Vector3i { return swz.wwzi(this); }
  get xxwi(): Vector3i { return swz.xxwi(this); }
  get yxwi(): Vector3i { return swz.yxwi(this); }
  get zxwi(): Vector3i { return swz.zxwi(this); }
  get wxwi(): Vector3i { return swz.wxwi(this); }
  get xywi(): Vector3i { return swz.xywi(this); }
  get yywi(): Vector3i { return swz.yywi(this); }
  get zywi(): Vector3i { return swz.zywi(this); }
  get wywi(): Vector3i { return swz.wywi(this); }
  get xzwi(): Vector3i { return swz.xzwi(this); }
  get yzwi(): Vector3i { return swz.yzwi(this); }
  get zzwi(): Vector3i { return swz.zzwi(this); }
  get wzwi(): Vector3i { return swz.wzwi(this); }
  get xwwi(): Vector3i { return swz.xwwi(this); }
  get ywwi(): Vector3i { return swz.ywwi(this); }
  get zwwi(): Vector3i { return swz.zwwi(this); }
  get wwwi(): Vector3i { return swz.wwwi(this); }
  //swizzle4f
  get xxxxf(): Vector4f { return swz.xxxxf(this); }
  get yxxxf(): Vector4f { return swz.yxxxf(this); }
  get zxxxf(): Vector4f { return swz.zxxxf(this); }
  get wxxxf(): Vector4f { return swz.wxxxf(this); }
  get xyxxf(): Vector4f { return swz.xyxxf(this); }
  get yyxxf(): Vector4f { return swz.yyxxf(this); }
  get zyxxf(): Vector4f { return swz.zyxxf(this); }
  get wyxxf(): Vector4f { return swz.wyxxf(this); }
  get xzxxf(): Vector4f { return swz.xzxxf(this); }
  get yzxxf(): Vector4f { return swz.yzxxf(this); }
  get zzxxf(): Vector4f { return swz.zzxxf(this); }
  get wzxxf(): Vector4f { return swz.wzxxf(this); }
  get xwxxf(): Vector4f { return swz.xwxxf(this); }
  get ywxxf(): Vector4f { return swz.ywxxf(this); }
  get zwxxf(): Vector4f { return swz.zwxxf(this); }
  get wwxxf(): Vector4f { return swz.wwxxf(this); }
  get xxyxf(): Vector4f { return swz.xxyxf(this); }
  get yxyxf(): Vector4f { return swz.yxyxf(this); }
  get zxyxf(): Vector4f { return swz.zxyxf(this); }
  get wxyxf(): Vector4f { return swz.wxyxf(this); }
  get xyyxf(): Vector4f { return swz.xyyxf(this); }
  get yyyxf(): Vector4f { return swz.yyyxf(this); }
  get zyyxf(): Vector4f { return swz.zyyxf(this); }
  get wyyxf(): Vector4f { return swz.wyyxf(this); }
  get xzyxf(): Vector4f { return swz.xzyxf(this); }
  get yzyxf(): Vector4f { return swz.yzyxf(this); }
  get zzyxf(): Vector4f { return swz.zzyxf(this); }
  get wzyxf(): Vector4f { return swz.wzyxf(this); }
  get xwyxf(): Vector4f { return swz.xwyxf(this); }
  get ywyxf(): Vector4f { return swz.ywyxf(this); }
  get zwyxf(): Vector4f { return swz.zwyxf(this); }
  get wwyxf(): Vector4f { return swz.wwyxf(this); }
  get xxzxf(): Vector4f { return swz.xxzxf(this); }
  get yxzxf(): Vector4f { return swz.yxzxf(this); }
  get zxzxf(): Vector4f { return swz.zxzxf(this); }
  get wxzxf(): Vector4f { return swz.wxzxf(this); }
  get xyzxf(): Vector4f { return swz.xyzxf(this); }
  get yyzxf(): Vector4f { return swz.yyzxf(this); }
  get zyzxf(): Vector4f { return swz.zyzxf(this); }
  get wyzxf(): Vector4f { return swz.wyzxf(this); }
  get xzzxf(): Vector4f { return swz.xzzxf(this); }
  get yzzxf(): Vector4f { return swz.yzzxf(this); }
  get zzzxf(): Vector4f { return swz.zzzxf(this); }
  get wzzxf(): Vector4f { return swz.wzzxf(this); }
  get xwzxf(): Vector4f { return swz.xwzxf(this); }
  get ywzxf(): Vector4f { return swz.ywzxf(this); }
  get zwzxf(): Vector4f { return swz.zwzxf(this); }
  get wwzxf(): Vector4f { return swz.wwzxf(this); }
  get xxwxf(): Vector4f { return swz.xxwxf(this); }
  get yxwxf(): Vector4f { return swz.yxwxf(this); }
  get zxwxf(): Vector4f { return swz.zxwxf(this); }
  get wxwxf(): Vector4f { return swz.wxwxf(this); }
  get xywxf(): Vector4f { return swz.xywxf(this); }
  get yywxf(): Vector4f { return swz.yywxf(this); }
  get zywxf(): Vector4f { return swz.zywxf(this); }
  get wywxf(): Vector4f { return swz.wywxf(this); }
  get xzwxf(): Vector4f { return swz.xzwxf(this); }
  get yzwxf(): Vector4f { return swz.yzwxf(this); }
  get zzwxf(): Vector4f { return swz.zzwxf(this); }
  get wzwxf(): Vector4f { return swz.wzwxf(this); }
  get xwwxf(): Vector4f { return swz.xwwxf(this); }
  get ywwxf(): Vector4f { return swz.ywwxf(this); }
  get zwwxf(): Vector4f { return swz.zwwxf(this); }
  get wwwxf(): Vector4f { return swz.wwwxf(this); }
  get xxxyf(): Vector4f { return swz.xxxyf(this); }
  get yxxyf(): Vector4f { return swz.yxxyf(this); }
  get zxxyf(): Vector4f { return swz.zxxyf(this); }
  get wxxyf(): Vector4f { return swz.wxxyf(this); }
  get xyxyf(): Vector4f { return swz.xyxyf(this); }
  get yyxyf(): Vector4f { return swz.yyxyf(this); }
  get zyxyf(): Vector4f { return swz.zyxyf(this); }
  get wyxyf(): Vector4f { return swz.wyxyf(this); }
  get xzxyf(): Vector4f { return swz.xzxyf(this); }
  get yzxyf(): Vector4f { return swz.yzxyf(this); }
  get zzxyf(): Vector4f { return swz.zzxyf(this); }
  get wzxyf(): Vector4f { return swz.wzxyf(this); }
  get xwxyf(): Vector4f { return swz.xwxyf(this); }
  get ywxyf(): Vector4f { return swz.ywxyf(this); }
  get zwxyf(): Vector4f { return swz.zwxyf(this); }
  get wwxyf(): Vector4f { return swz.wwxyf(this); }
  get xxyyf(): Vector4f { return swz.xxyyf(this); }
  get yxyyf(): Vector4f { return swz.yxyyf(this); }
  get zxyyf(): Vector4f { return swz.zxyyf(this); }
  get wxyyf(): Vector4f { return swz.wxyyf(this); }
  get xyyyf(): Vector4f { return swz.xyyyf(this); }
  get yyyyf(): Vector4f { return swz.yyyyf(this); }
  get zyyyf(): Vector4f { return swz.zyyyf(this); }
  get wyyyf(): Vector4f { return swz.wyyyf(this); }
  get xzyyf(): Vector4f { return swz.xzyyf(this); }
  get yzyyf(): Vector4f { return swz.yzyyf(this); }
  get zzyyf(): Vector4f { return swz.zzyyf(this); }
  get wzyyf(): Vector4f { return swz.wzyyf(this); }
  get xwyyf(): Vector4f { return swz.xwyyf(this); }
  get ywyyf(): Vector4f { return swz.ywyyf(this); }
  get zwyyf(): Vector4f { return swz.zwyyf(this); }
  get wwyyf(): Vector4f { return swz.wwyyf(this); }
  get xxzyf(): Vector4f { return swz.xxzyf(this); }
  get yxzyf(): Vector4f { return swz.yxzyf(this); }
  get zxzyf(): Vector4f { return swz.zxzyf(this); }
  get wxzyf(): Vector4f { return swz.wxzyf(this); }
  get xyzyf(): Vector4f { return swz.xyzyf(this); }
  get yyzyf(): Vector4f { return swz.yyzyf(this); }
  get zyzyf(): Vector4f { return swz.zyzyf(this); }
  get wyzyf(): Vector4f { return swz.wyzyf(this); }
  get xzzyf(): Vector4f { return swz.xzzyf(this); }
  get yzzyf(): Vector4f { return swz.yzzyf(this); }
  get zzzyf(): Vector4f { return swz.zzzyf(this); }
  get wzzyf(): Vector4f { return swz.wzzyf(this); }
  get xwzyf(): Vector4f { return swz.xwzyf(this); }
  get ywzyf(): Vector4f { return swz.ywzyf(this); }
  get zwzyf(): Vector4f { return swz.zwzyf(this); }
  get wwzyf(): Vector4f { return swz.wwzyf(this); }
  get xxwyf(): Vector4f { return swz.xxwyf(this); }
  get yxwyf(): Vector4f { return swz.yxwyf(this); }
  get zxwyf(): Vector4f { return swz.zxwyf(this); }
  get wxwyf(): Vector4f { return swz.wxwyf(this); }
  get xywyf(): Vector4f { return swz.xywyf(this); }
  get yywyf(): Vector4f { return swz.yywyf(this); }
  get zywyf(): Vector4f { return swz.zywyf(this); }
  get wywyf(): Vector4f { return swz.wywyf(this); }
  get xzwyf(): Vector4f { return swz.xzwyf(this); }
  get yzwyf(): Vector4f { return swz.yzwyf(this); }
  get zzwyf(): Vector4f { return swz.zzwyf(this); }
  get wzwyf(): Vector4f { return swz.wzwyf(this); }
  get xwwyf(): Vector4f { return swz.xwwyf(this); }
  get ywwyf(): Vector4f { return swz.ywwyf(this); }
  get zwwyf(): Vector4f { return swz.zwwyf(this); }
  get wwwyf(): Vector4f { return swz.wwwyf(this); }
  get xxxzf(): Vector4f { return swz.xxxzf(this); }
  get yxxzf(): Vector4f { return swz.yxxzf(this); }
  get zxxzf(): Vector4f { return swz.zxxzf(this); }
  get wxxzf(): Vector4f { return swz.wxxzf(this); }
  get xyxzf(): Vector4f { return swz.xyxzf(this); }
  get yyxzf(): Vector4f { return swz.yyxzf(this); }
  get zyxzf(): Vector4f { return swz.zyxzf(this); }
  get wyxzf(): Vector4f { return swz.wyxzf(this); }
  get xzxzf(): Vector4f { return swz.xzxzf(this); }
  get yzxzf(): Vector4f { return swz.yzxzf(this); }
  get zzxzf(): Vector4f { return swz.zzxzf(this); }
  get wzxzf(): Vector4f { return swz.wzxzf(this); }
  get xwxzf(): Vector4f { return swz.xwxzf(this); }
  get ywxzf(): Vector4f { return swz.ywxzf(this); }
  get zwxzf(): Vector4f { return swz.zwxzf(this); }
  get wwxzf(): Vector4f { return swz.wwxzf(this); }
  get xxyzf(): Vector4f { return swz.xxyzf(this); }
  get yxyzf(): Vector4f { return swz.yxyzf(this); }
  get zxyzf(): Vector4f { return swz.zxyzf(this); }
  get wxyzf(): Vector4f { return swz.wxyzf(this); }
  get xyyzf(): Vector4f { return swz.xyyzf(this); }
  get yyyzf(): Vector4f { return swz.yyyzf(this); }
  get zyyzf(): Vector4f { return swz.zyyzf(this); }
  get wyyzf(): Vector4f { return swz.wyyzf(this); }
  get xzyzf(): Vector4f { return swz.xzyzf(this); }
  get yzyzf(): Vector4f { return swz.yzyzf(this); }
  get zzyzf(): Vector4f { return swz.zzyzf(this); }
  get wzyzf(): Vector4f { return swz.wzyzf(this); }
  get xwyzf(): Vector4f { return swz.xwyzf(this); }
  get ywyzf(): Vector4f { return swz.ywyzf(this); }
  get zwyzf(): Vector4f { return swz.zwyzf(this); }
  get wwyzf(): Vector4f { return swz.wwyzf(this); }
  get xxzzf(): Vector4f { return swz.xxzzf(this); }
  get yxzzf(): Vector4f { return swz.yxzzf(this); }
  get zxzzf(): Vector4f { return swz.zxzzf(this); }
  get wxzzf(): Vector4f { return swz.wxzzf(this); }
  get xyzzf(): Vector4f { return swz.xyzzf(this); }
  get yyzzf(): Vector4f { return swz.yyzzf(this); }
  get zyzzf(): Vector4f { return swz.zyzzf(this); }
  get wyzzf(): Vector4f { return swz.wyzzf(this); }
  get xzzzf(): Vector4f { return swz.xzzzf(this); }
  get yzzzf(): Vector4f { return swz.yzzzf(this); }
  get zzzzf(): Vector4f { return swz.zzzzf(this); }
  get wzzzf(): Vector4f { return swz.wzzzf(this); }
  get xwzzf(): Vector4f { return swz.xwzzf(this); }
  get ywzzf(): Vector4f { return swz.ywzzf(this); }
  get zwzzf(): Vector4f { return swz.zwzzf(this); }
  get wwzzf(): Vector4f { return swz.wwzzf(this); }
  get xxwzf(): Vector4f { return swz.xxwzf(this); }
  get yxwzf(): Vector4f { return swz.yxwzf(this); }
  get zxwzf(): Vector4f { return swz.zxwzf(this); }
  get wxwzf(): Vector4f { return swz.wxwzf(this); }
  get xywzf(): Vector4f { return swz.xywzf(this); }
  get yywzf(): Vector4f { return swz.yywzf(this); }
  get zywzf(): Vector4f { return swz.zywzf(this); }
  get wywzf(): Vector4f { return swz.wywzf(this); }
  get xzwzf(): Vector4f { return swz.xzwzf(this); }
  get yzwzf(): Vector4f { return swz.yzwzf(this); }
  get zzwzf(): Vector4f { return swz.zzwzf(this); }
  get wzwzf(): Vector4f { return swz.wzwzf(this); }
  get xwwzf(): Vector4f { return swz.xwwzf(this); }
  get ywwzf(): Vector4f { return swz.ywwzf(this); }
  get zwwzf(): Vector4f { return swz.zwwzf(this); }
  get wwwzf(): Vector4f { return swz.wwwzf(this); }
  get xxxwf(): Vector4f { return swz.xxxwf(this); }
  get yxxwf(): Vector4f { return swz.yxxwf(this); }
  get zxxwf(): Vector4f { return swz.zxxwf(this); }
  get wxxwf(): Vector4f { return swz.wxxwf(this); }
  get xyxwf(): Vector4f { return swz.xyxwf(this); }
  get yyxwf(): Vector4f { return swz.yyxwf(this); }
  get zyxwf(): Vector4f { return swz.zyxwf(this); }
  get wyxwf(): Vector4f { return swz.wyxwf(this); }
  get xzxwf(): Vector4f { return swz.xzxwf(this); }
  get yzxwf(): Vector4f { return swz.yzxwf(this); }
  get zzxwf(): Vector4f { return swz.zzxwf(this); }
  get wzxwf(): Vector4f { return swz.wzxwf(this); }
  get xwxwf(): Vector4f { return swz.xwxwf(this); }
  get ywxwf(): Vector4f { return swz.ywxwf(this); }
  get zwxwf(): Vector4f { return swz.zwxwf(this); }
  get wwxwf(): Vector4f { return swz.wwxwf(this); }
  get xxywf(): Vector4f { return swz.xxywf(this); }
  get yxywf(): Vector4f { return swz.yxywf(this); }
  get zxywf(): Vector4f { return swz.zxywf(this); }
  get wxywf(): Vector4f { return swz.wxywf(this); }
  get xyywf(): Vector4f { return swz.xyywf(this); }
  get yyywf(): Vector4f { return swz.yyywf(this); }
  get zyywf(): Vector4f { return swz.zyywf(this); }
  get wyywf(): Vector4f { return swz.wyywf(this); }
  get xzywf(): Vector4f { return swz.xzywf(this); }
  get yzywf(): Vector4f { return swz.yzywf(this); }
  get zzywf(): Vector4f { return swz.zzywf(this); }
  get wzywf(): Vector4f { return swz.wzywf(this); }
  get xwywf(): Vector4f { return swz.xwywf(this); }
  get ywywf(): Vector4f { return swz.ywywf(this); }
  get zwywf(): Vector4f { return swz.zwywf(this); }
  get wwywf(): Vector4f { return swz.wwywf(this); }
  get xxzwf(): Vector4f { return swz.xxzwf(this); }
  get yxzwf(): Vector4f { return swz.yxzwf(this); }
  get zxzwf(): Vector4f { return swz.zxzwf(this); }
  get wxzwf(): Vector4f { return swz.wxzwf(this); }
  get xyzwf(): Vector4f { return swz.xyzwf(this); }
  get yyzwf(): Vector4f { return swz.yyzwf(this); }
  get zyzwf(): Vector4f { return swz.zyzwf(this); }
  get wyzwf(): Vector4f { return swz.wyzwf(this); }
  get xzzwf(): Vector4f { return swz.xzzwf(this); }
  get yzzwf(): Vector4f { return swz.yzzwf(this); }
  get zzzwf(): Vector4f { return swz.zzzwf(this); }
  get wzzwf(): Vector4f { return swz.wzzwf(this); }
  get xwzwf(): Vector4f { return swz.xwzwf(this); }
  get ywzwf(): Vector4f { return swz.ywzwf(this); }
  get zwzwf(): Vector4f { return swz.zwzwf(this); }
  get wwzwf(): Vector4f { return swz.wwzwf(this); }
  get xxwwf(): Vector4f { return swz.xxwwf(this); }
  get yxwwf(): Vector4f { return swz.yxwwf(this); }
  get zxwwf(): Vector4f { return swz.zxwwf(this); }
  get wxwwf(): Vector4f { return swz.wxwwf(this); }
  get xywwf(): Vector4f { return swz.xywwf(this); }
  get yywwf(): Vector4f { return swz.yywwf(this); }
  get zywwf(): Vector4f { return swz.zywwf(this); }
  get wywwf(): Vector4f { return swz.wywwf(this); }
  get xzwwf(): Vector4f { return swz.xzwwf(this); }
  get yzwwf(): Vector4f { return swz.yzwwf(this); }
  get zzwwf(): Vector4f { return swz.zzwwf(this); }
  get wzwwf(): Vector4f { return swz.wzwwf(this); }
  get xwwwf(): Vector4f { return swz.xwwwf(this); }
  get ywwwf(): Vector4f { return swz.ywwwf(this); }
  get zwwwf(): Vector4f { return swz.zwwwf(this); }
  get wwwwf(): Vector4f { return swz.wwwwf(this); }
  //swizzle4u
  get xxxxu(): Vector4u { return swz.xxxxu(this); }
  get yxxxu(): Vector4u { return swz.yxxxu(this); }
  get zxxxu(): Vector4u { return swz.zxxxu(this); }
  get wxxxu(): Vector4u { return swz.wxxxu(this); }
  get xyxxu(): Vector4u { return swz.xyxxu(this); }
  get yyxxu(): Vector4u { return swz.yyxxu(this); }
  get zyxxu(): Vector4u { return swz.zyxxu(this); }
  get wyxxu(): Vector4u { return swz.wyxxu(this); }
  get xzxxu(): Vector4u { return swz.xzxxu(this); }
  get yzxxu(): Vector4u { return swz.yzxxu(this); }
  get zzxxu(): Vector4u { return swz.zzxxu(this); }
  get wzxxu(): Vector4u { return swz.wzxxu(this); }
  get xwxxu(): Vector4u { return swz.xwxxu(this); }
  get ywxxu(): Vector4u { return swz.ywxxu(this); }
  get zwxxu(): Vector4u { return swz.zwxxu(this); }
  get wwxxu(): Vector4u { return swz.wwxxu(this); }
  get xxyxu(): Vector4u { return swz.xxyxu(this); }
  get yxyxu(): Vector4u { return swz.yxyxu(this); }
  get zxyxu(): Vector4u { return swz.zxyxu(this); }
  get wxyxu(): Vector4u { return swz.wxyxu(this); }
  get xyyxu(): Vector4u { return swz.xyyxu(this); }
  get yyyxu(): Vector4u { return swz.yyyxu(this); }
  get zyyxu(): Vector4u { return swz.zyyxu(this); }
  get wyyxu(): Vector4u { return swz.wyyxu(this); }
  get xzyxu(): Vector4u { return swz.xzyxu(this); }
  get yzyxu(): Vector4u { return swz.yzyxu(this); }
  get zzyxu(): Vector4u { return swz.zzyxu(this); }
  get wzyxu(): Vector4u { return swz.wzyxu(this); }
  get xwyxu(): Vector4u { return swz.xwyxu(this); }
  get ywyxu(): Vector4u { return swz.ywyxu(this); }
  get zwyxu(): Vector4u { return swz.zwyxu(this); }
  get wwyxu(): Vector4u { return swz.wwyxu(this); }
  get xxzxu(): Vector4u { return swz.xxzxu(this); }
  get yxzxu(): Vector4u { return swz.yxzxu(this); }
  get zxzxu(): Vector4u { return swz.zxzxu(this); }
  get wxzxu(): Vector4u { return swz.wxzxu(this); }
  get xyzxu(): Vector4u { return swz.xyzxu(this); }
  get yyzxu(): Vector4u { return swz.yyzxu(this); }
  get zyzxu(): Vector4u { return swz.zyzxu(this); }
  get wyzxu(): Vector4u { return swz.wyzxu(this); }
  get xzzxu(): Vector4u { return swz.xzzxu(this); }
  get yzzxu(): Vector4u { return swz.yzzxu(this); }
  get zzzxu(): Vector4u { return swz.zzzxu(this); }
  get wzzxu(): Vector4u { return swz.wzzxu(this); }
  get xwzxu(): Vector4u { return swz.xwzxu(this); }
  get ywzxu(): Vector4u { return swz.ywzxu(this); }
  get zwzxu(): Vector4u { return swz.zwzxu(this); }
  get wwzxu(): Vector4u { return swz.wwzxu(this); }
  get xxwxu(): Vector4u { return swz.xxwxu(this); }
  get yxwxu(): Vector4u { return swz.yxwxu(this); }
  get zxwxu(): Vector4u { return swz.zxwxu(this); }
  get wxwxu(): Vector4u { return swz.wxwxu(this); }
  get xywxu(): Vector4u { return swz.xywxu(this); }
  get yywxu(): Vector4u { return swz.yywxu(this); }
  get zywxu(): Vector4u { return swz.zywxu(this); }
  get wywxu(): Vector4u { return swz.wywxu(this); }
  get xzwxu(): Vector4u { return swz.xzwxu(this); }
  get yzwxu(): Vector4u { return swz.yzwxu(this); }
  get zzwxu(): Vector4u { return swz.zzwxu(this); }
  get wzwxu(): Vector4u { return swz.wzwxu(this); }
  get xwwxu(): Vector4u { return swz.xwwxu(this); }
  get ywwxu(): Vector4u { return swz.ywwxu(this); }
  get zwwxu(): Vector4u { return swz.zwwxu(this); }
  get wwwxu(): Vector4u { return swz.wwwxu(this); }
  get xxxyu(): Vector4u { return swz.xxxyu(this); }
  get yxxyu(): Vector4u { return swz.yxxyu(this); }
  get zxxyu(): Vector4u { return swz.zxxyu(this); }
  get wxxyu(): Vector4u { return swz.wxxyu(this); }
  get xyxyu(): Vector4u { return swz.xyxyu(this); }
  get yyxyu(): Vector4u { return swz.yyxyu(this); }
  get zyxyu(): Vector4u { return swz.zyxyu(this); }
  get wyxyu(): Vector4u { return swz.wyxyu(this); }
  get xzxyu(): Vector4u { return swz.xzxyu(this); }
  get yzxyu(): Vector4u { return swz.yzxyu(this); }
  get zzxyu(): Vector4u { return swz.zzxyu(this); }
  get wzxyu(): Vector4u { return swz.wzxyu(this); }
  get xwxyu(): Vector4u { return swz.xwxyu(this); }
  get ywxyu(): Vector4u { return swz.ywxyu(this); }
  get zwxyu(): Vector4u { return swz.zwxyu(this); }
  get wwxyu(): Vector4u { return swz.wwxyu(this); }
  get xxyyu(): Vector4u { return swz.xxyyu(this); }
  get yxyyu(): Vector4u { return swz.yxyyu(this); }
  get zxyyu(): Vector4u { return swz.zxyyu(this); }
  get wxyyu(): Vector4u { return swz.wxyyu(this); }
  get xyyyu(): Vector4u { return swz.xyyyu(this); }
  get yyyyu(): Vector4u { return swz.yyyyu(this); }
  get zyyyu(): Vector4u { return swz.zyyyu(this); }
  get wyyyu(): Vector4u { return swz.wyyyu(this); }
  get xzyyu(): Vector4u { return swz.xzyyu(this); }
  get yzyyu(): Vector4u { return swz.yzyyu(this); }
  get zzyyu(): Vector4u { return swz.zzyyu(this); }
  get wzyyu(): Vector4u { return swz.wzyyu(this); }
  get xwyyu(): Vector4u { return swz.xwyyu(this); }
  get ywyyu(): Vector4u { return swz.ywyyu(this); }
  get zwyyu(): Vector4u { return swz.zwyyu(this); }
  get wwyyu(): Vector4u { return swz.wwyyu(this); }
  get xxzyu(): Vector4u { return swz.xxzyu(this); }
  get yxzyu(): Vector4u { return swz.yxzyu(this); }
  get zxzyu(): Vector4u { return swz.zxzyu(this); }
  get wxzyu(): Vector4u { return swz.wxzyu(this); }
  get xyzyu(): Vector4u { return swz.xyzyu(this); }
  get yyzyu(): Vector4u { return swz.yyzyu(this); }
  get zyzyu(): Vector4u { return swz.zyzyu(this); }
  get wyzyu(): Vector4u { return swz.wyzyu(this); }
  get xzzyu(): Vector4u { return swz.xzzyu(this); }
  get yzzyu(): Vector4u { return swz.yzzyu(this); }
  get zzzyu(): Vector4u { return swz.zzzyu(this); }
  get wzzyu(): Vector4u { return swz.wzzyu(this); }
  get xwzyu(): Vector4u { return swz.xwzyu(this); }
  get ywzyu(): Vector4u { return swz.ywzyu(this); }
  get zwzyu(): Vector4u { return swz.zwzyu(this); }
  get wwzyu(): Vector4u { return swz.wwzyu(this); }
  get xxwyu(): Vector4u { return swz.xxwyu(this); }
  get yxwyu(): Vector4u { return swz.yxwyu(this); }
  get zxwyu(): Vector4u { return swz.zxwyu(this); }
  get wxwyu(): Vector4u { return swz.wxwyu(this); }
  get xywyu(): Vector4u { return swz.xywyu(this); }
  get yywyu(): Vector4u { return swz.yywyu(this); }
  get zywyu(): Vector4u { return swz.zywyu(this); }
  get wywyu(): Vector4u { return swz.wywyu(this); }
  get xzwyu(): Vector4u { return swz.xzwyu(this); }
  get yzwyu(): Vector4u { return swz.yzwyu(this); }
  get zzwyu(): Vector4u { return swz.zzwyu(this); }
  get wzwyu(): Vector4u { return swz.wzwyu(this); }
  get xwwyu(): Vector4u { return swz.xwwyu(this); }
  get ywwyu(): Vector4u { return swz.ywwyu(this); }
  get zwwyu(): Vector4u { return swz.zwwyu(this); }
  get wwwyu(): Vector4u { return swz.wwwyu(this); }
  get xxxzu(): Vector4u { return swz.xxxzu(this); }
  get yxxzu(): Vector4u { return swz.yxxzu(this); }
  get zxxzu(): Vector4u { return swz.zxxzu(this); }
  get wxxzu(): Vector4u { return swz.wxxzu(this); }
  get xyxzu(): Vector4u { return swz.xyxzu(this); }
  get yyxzu(): Vector4u { return swz.yyxzu(this); }
  get zyxzu(): Vector4u { return swz.zyxzu(this); }
  get wyxzu(): Vector4u { return swz.wyxzu(this); }
  get xzxzu(): Vector4u { return swz.xzxzu(this); }
  get yzxzu(): Vector4u { return swz.yzxzu(this); }
  get zzxzu(): Vector4u { return swz.zzxzu(this); }
  get wzxzu(): Vector4u { return swz.wzxzu(this); }
  get xwxzu(): Vector4u { return swz.xwxzu(this); }
  get ywxzu(): Vector4u { return swz.ywxzu(this); }
  get zwxzu(): Vector4u { return swz.zwxzu(this); }
  get wwxzu(): Vector4u { return swz.wwxzu(this); }
  get xxyzu(): Vector4u { return swz.xxyzu(this); }
  get yxyzu(): Vector4u { return swz.yxyzu(this); }
  get zxyzu(): Vector4u { return swz.zxyzu(this); }
  get wxyzu(): Vector4u { return swz.wxyzu(this); }
  get xyyzu(): Vector4u { return swz.xyyzu(this); }
  get yyyzu(): Vector4u { return swz.yyyzu(this); }
  get zyyzu(): Vector4u { return swz.zyyzu(this); }
  get wyyzu(): Vector4u { return swz.wyyzu(this); }
  get xzyzu(): Vector4u { return swz.xzyzu(this); }
  get yzyzu(): Vector4u { return swz.yzyzu(this); }
  get zzyzu(): Vector4u { return swz.zzyzu(this); }
  get wzyzu(): Vector4u { return swz.wzyzu(this); }
  get xwyzu(): Vector4u { return swz.xwyzu(this); }
  get ywyzu(): Vector4u { return swz.ywyzu(this); }
  get zwyzu(): Vector4u { return swz.zwyzu(this); }
  get wwyzu(): Vector4u { return swz.wwyzu(this); }
  get xxzzu(): Vector4u { return swz.xxzzu(this); }
  get yxzzu(): Vector4u { return swz.yxzzu(this); }
  get zxzzu(): Vector4u { return swz.zxzzu(this); }
  get wxzzu(): Vector4u { return swz.wxzzu(this); }
  get xyzzu(): Vector4u { return swz.xyzzu(this); }
  get yyzzu(): Vector4u { return swz.yyzzu(this); }
  get zyzzu(): Vector4u { return swz.zyzzu(this); }
  get wyzzu(): Vector4u { return swz.wyzzu(this); }
  get xzzzu(): Vector4u { return swz.xzzzu(this); }
  get yzzzu(): Vector4u { return swz.yzzzu(this); }
  get zzzzu(): Vector4u { return swz.zzzzu(this); }
  get wzzzu(): Vector4u { return swz.wzzzu(this); }
  get xwzzu(): Vector4u { return swz.xwzzu(this); }
  get ywzzu(): Vector4u { return swz.ywzzu(this); }
  get zwzzu(): Vector4u { return swz.zwzzu(this); }
  get wwzzu(): Vector4u { return swz.wwzzu(this); }
  get xxwzu(): Vector4u { return swz.xxwzu(this); }
  get yxwzu(): Vector4u { return swz.yxwzu(this); }
  get zxwzu(): Vector4u { return swz.zxwzu(this); }
  get wxwzu(): Vector4u { return swz.wxwzu(this); }
  get xywzu(): Vector4u { return swz.xywzu(this); }
  get yywzu(): Vector4u { return swz.yywzu(this); }
  get zywzu(): Vector4u { return swz.zywzu(this); }
  get wywzu(): Vector4u { return swz.wywzu(this); }
  get xzwzu(): Vector4u { return swz.xzwzu(this); }
  get yzwzu(): Vector4u { return swz.yzwzu(this); }
  get zzwzu(): Vector4u { return swz.zzwzu(this); }
  get wzwzu(): Vector4u { return swz.wzwzu(this); }
  get xwwzu(): Vector4u { return swz.xwwzu(this); }
  get ywwzu(): Vector4u { return swz.ywwzu(this); }
  get zwwzu(): Vector4u { return swz.zwwzu(this); }
  get wwwzu(): Vector4u { return swz.wwwzu(this); }
  get xxxwu(): Vector4u { return swz.xxxwu(this); }
  get yxxwu(): Vector4u { return swz.yxxwu(this); }
  get zxxwu(): Vector4u { return swz.zxxwu(this); }
  get wxxwu(): Vector4u { return swz.wxxwu(this); }
  get xyxwu(): Vector4u { return swz.xyxwu(this); }
  get yyxwu(): Vector4u { return swz.yyxwu(this); }
  get zyxwu(): Vector4u { return swz.zyxwu(this); }
  get wyxwu(): Vector4u { return swz.wyxwu(this); }
  get xzxwu(): Vector4u { return swz.xzxwu(this); }
  get yzxwu(): Vector4u { return swz.yzxwu(this); }
  get zzxwu(): Vector4u { return swz.zzxwu(this); }
  get wzxwu(): Vector4u { return swz.wzxwu(this); }
  get xwxwu(): Vector4u { return swz.xwxwu(this); }
  get ywxwu(): Vector4u { return swz.ywxwu(this); }
  get zwxwu(): Vector4u { return swz.zwxwu(this); }
  get wwxwu(): Vector4u { return swz.wwxwu(this); }
  get xxywu(): Vector4u { return swz.xxywu(this); }
  get yxywu(): Vector4u { return swz.yxywu(this); }
  get zxywu(): Vector4u { return swz.zxywu(this); }
  get wxywu(): Vector4u { return swz.wxywu(this); }
  get xyywu(): Vector4u { return swz.xyywu(this); }
  get yyywu(): Vector4u { return swz.yyywu(this); }
  get zyywu(): Vector4u { return swz.zyywu(this); }
  get wyywu(): Vector4u { return swz.wyywu(this); }
  get xzywu(): Vector4u { return swz.xzywu(this); }
  get yzywu(): Vector4u { return swz.yzywu(this); }
  get zzywu(): Vector4u { return swz.zzywu(this); }
  get wzywu(): Vector4u { return swz.wzywu(this); }
  get xwywu(): Vector4u { return swz.xwywu(this); }
  get ywywu(): Vector4u { return swz.ywywu(this); }
  get zwywu(): Vector4u { return swz.zwywu(this); }
  get wwywu(): Vector4u { return swz.wwywu(this); }
  get xxzwu(): Vector4u { return swz.xxzwu(this); }
  get yxzwu(): Vector4u { return swz.yxzwu(this); }
  get zxzwu(): Vector4u { return swz.zxzwu(this); }
  get wxzwu(): Vector4u { return swz.wxzwu(this); }
  get xyzwu(): Vector4u { return swz.xyzwu(this); }
  get yyzwu(): Vector4u { return swz.yyzwu(this); }
  get zyzwu(): Vector4u { return swz.zyzwu(this); }
  get wyzwu(): Vector4u { return swz.wyzwu(this); }
  get xzzwu(): Vector4u { return swz.xzzwu(this); }
  get yzzwu(): Vector4u { return swz.yzzwu(this); }
  get zzzwu(): Vector4u { return swz.zzzwu(this); }
  get wzzwu(): Vector4u { return swz.wzzwu(this); }
  get xwzwu(): Vector4u { return swz.xwzwu(this); }
  get ywzwu(): Vector4u { return swz.ywzwu(this); }
  get zwzwu(): Vector4u { return swz.zwzwu(this); }
  get wwzwu(): Vector4u { return swz.wwzwu(this); }
  get xxwwu(): Vector4u { return swz.xxwwu(this); }
  get yxwwu(): Vector4u { return swz.yxwwu(this); }
  get zxwwu(): Vector4u { return swz.zxwwu(this); }
  get wxwwu(): Vector4u { return swz.wxwwu(this); }
  get xywwu(): Vector4u { return swz.xywwu(this); }
  get yywwu(): Vector4u { return swz.yywwu(this); }
  get zywwu(): Vector4u { return swz.zywwu(this); }
  get wywwu(): Vector4u { return swz.wywwu(this); }
  get xzwwu(): Vector4u { return swz.xzwwu(this); }
  get yzwwu(): Vector4u { return swz.yzwwu(this); }
  get zzwwu(): Vector4u { return swz.zzwwu(this); }
  get wzwwu(): Vector4u { return swz.wzwwu(this); }
  get xwwwu(): Vector4u { return swz.xwwwu(this); }
  get ywwwu(): Vector4u { return swz.ywwwu(this); }
  get zwwwu(): Vector4u { return swz.zwwwu(this); }
  get wwwwu(): Vector4u { return swz.wwwwu(this); }
  //swizzle4i
  get xxxxi(): Vector4i { return swz.xxxxi(this); }
  get yxxxi(): Vector4i { return swz.yxxxi(this); }
  get zxxxi(): Vector4i { return swz.zxxxi(this); }
  get wxxxi(): Vector4i { return swz.wxxxi(this); }
  get xyxxi(): Vector4i { return swz.xyxxi(this); }
  get yyxxi(): Vector4i { return swz.yyxxi(this); }
  get zyxxi(): Vector4i { return swz.zyxxi(this); }
  get wyxxi(): Vector4i { return swz.wyxxi(this); }
  get xzxxi(): Vector4i { return swz.xzxxi(this); }
  get yzxxi(): Vector4i { return swz.yzxxi(this); }
  get zzxxi(): Vector4i { return swz.zzxxi(this); }
  get wzxxi(): Vector4i { return swz.wzxxi(this); }
  get xwxxi(): Vector4i { return swz.xwxxi(this); }
  get ywxxi(): Vector4i { return swz.ywxxi(this); }
  get zwxxi(): Vector4i { return swz.zwxxi(this); }
  get wwxxi(): Vector4i { return swz.wwxxi(this); }
  get xxyxi(): Vector4i { return swz.xxyxi(this); }
  get yxyxi(): Vector4i { return swz.yxyxi(this); }
  get zxyxi(): Vector4i { return swz.zxyxi(this); }
  get wxyxi(): Vector4i { return swz.wxyxi(this); }
  get xyyxi(): Vector4i { return swz.xyyxi(this); }
  get yyyxi(): Vector4i { return swz.yyyxi(this); }
  get zyyxi(): Vector4i { return swz.zyyxi(this); }
  get wyyxi(): Vector4i { return swz.wyyxi(this); }
  get xzyxi(): Vector4i { return swz.xzyxi(this); }
  get yzyxi(): Vector4i { return swz.yzyxi(this); }
  get zzyxi(): Vector4i { return swz.zzyxi(this); }
  get wzyxi(): Vector4i { return swz.wzyxi(this); }
  get xwyxi(): Vector4i { return swz.xwyxi(this); }
  get ywyxi(): Vector4i { return swz.ywyxi(this); }
  get zwyxi(): Vector4i { return swz.zwyxi(this); }
  get wwyxi(): Vector4i { return swz.wwyxi(this); }
  get xxzxi(): Vector4i { return swz.xxzxi(this); }
  get yxzxi(): Vector4i { return swz.yxzxi(this); }
  get zxzxi(): Vector4i { return swz.zxzxi(this); }
  get wxzxi(): Vector4i { return swz.wxzxi(this); }
  get xyzxi(): Vector4i { return swz.xyzxi(this); }
  get yyzxi(): Vector4i { return swz.yyzxi(this); }
  get zyzxi(): Vector4i { return swz.zyzxi(this); }
  get wyzxi(): Vector4i { return swz.wyzxi(this); }
  get xzzxi(): Vector4i { return swz.xzzxi(this); }
  get yzzxi(): Vector4i { return swz.yzzxi(this); }
  get zzzxi(): Vector4i { return swz.zzzxi(this); }
  get wzzxi(): Vector4i { return swz.wzzxi(this); }
  get xwzxi(): Vector4i { return swz.xwzxi(this); }
  get ywzxi(): Vector4i { return swz.ywzxi(this); }
  get zwzxi(): Vector4i { return swz.zwzxi(this); }
  get wwzxi(): Vector4i { return swz.wwzxi(this); }
  get xxwxi(): Vector4i { return swz.xxwxi(this); }
  get yxwxi(): Vector4i { return swz.yxwxi(this); }
  get zxwxi(): Vector4i { return swz.zxwxi(this); }
  get wxwxi(): Vector4i { return swz.wxwxi(this); }
  get xywxi(): Vector4i { return swz.xywxi(this); }
  get yywxi(): Vector4i { return swz.yywxi(this); }
  get zywxi(): Vector4i { return swz.zywxi(this); }
  get wywxi(): Vector4i { return swz.wywxi(this); }
  get xzwxi(): Vector4i { return swz.xzwxi(this); }
  get yzwxi(): Vector4i { return swz.yzwxi(this); }
  get zzwxi(): Vector4i { return swz.zzwxi(this); }
  get wzwxi(): Vector4i { return swz.wzwxi(this); }
  get xwwxi(): Vector4i { return swz.xwwxi(this); }
  get ywwxi(): Vector4i { return swz.ywwxi(this); }
  get zwwxi(): Vector4i { return swz.zwwxi(this); }
  get wwwxi(): Vector4i { return swz.wwwxi(this); }
  get xxxyi(): Vector4i { return swz.xxxyi(this); }
  get yxxyi(): Vector4i { return swz.yxxyi(this); }
  get zxxyi(): Vector4i { return swz.zxxyi(this); }
  get wxxyi(): Vector4i { return swz.wxxyi(this); }
  get xyxyi(): Vector4i { return swz.xyxyi(this); }
  get yyxyi(): Vector4i { return swz.yyxyi(this); }
  get zyxyi(): Vector4i { return swz.zyxyi(this); }
  get wyxyi(): Vector4i { return swz.wyxyi(this); }
  get xzxyi(): Vector4i { return swz.xzxyi(this); }
  get yzxyi(): Vector4i { return swz.yzxyi(this); }
  get zzxyi(): Vector4i { return swz.zzxyi(this); }
  get wzxyi(): Vector4i { return swz.wzxyi(this); }
  get xwxyi(): Vector4i { return swz.xwxyi(this); }
  get ywxyi(): Vector4i { return swz.ywxyi(this); }
  get zwxyi(): Vector4i { return swz.zwxyi(this); }
  get wwxyi(): Vector4i { return swz.wwxyi(this); }
  get xxyyi(): Vector4i { return swz.xxyyi(this); }
  get yxyyi(): Vector4i { return swz.yxyyi(this); }
  get zxyyi(): Vector4i { return swz.zxyyi(this); }
  get wxyyi(): Vector4i { return swz.wxyyi(this); }
  get xyyyi(): Vector4i { return swz.xyyyi(this); }
  get yyyyi(): Vector4i { return swz.yyyyi(this); }
  get zyyyi(): Vector4i { return swz.zyyyi(this); }
  get wyyyi(): Vector4i { return swz.wyyyi(this); }
  get xzyyi(): Vector4i { return swz.xzyyi(this); }
  get yzyyi(): Vector4i { return swz.yzyyi(this); }
  get zzyyi(): Vector4i { return swz.zzyyi(this); }
  get wzyyi(): Vector4i { return swz.wzyyi(this); }
  get xwyyi(): Vector4i { return swz.xwyyi(this); }
  get ywyyi(): Vector4i { return swz.ywyyi(this); }
  get zwyyi(): Vector4i { return swz.zwyyi(this); }
  get wwyyi(): Vector4i { return swz.wwyyi(this); }
  get xxzyi(): Vector4i { return swz.xxzyi(this); }
  get yxzyi(): Vector4i { return swz.yxzyi(this); }
  get zxzyi(): Vector4i { return swz.zxzyi(this); }
  get wxzyi(): Vector4i { return swz.wxzyi(this); }
  get xyzyi(): Vector4i { return swz.xyzyi(this); }
  get yyzyi(): Vector4i { return swz.yyzyi(this); }
  get zyzyi(): Vector4i { return swz.zyzyi(this); }
  get wyzyi(): Vector4i { return swz.wyzyi(this); }
  get xzzyi(): Vector4i { return swz.xzzyi(this); }
  get yzzyi(): Vector4i { return swz.yzzyi(this); }
  get zzzyi(): Vector4i { return swz.zzzyi(this); }
  get wzzyi(): Vector4i { return swz.wzzyi(this); }
  get xwzyi(): Vector4i { return swz.xwzyi(this); }
  get ywzyi(): Vector4i { return swz.ywzyi(this); }
  get zwzyi(): Vector4i { return swz.zwzyi(this); }
  get wwzyi(): Vector4i { return swz.wwzyi(this); }
  get xxwyi(): Vector4i { return swz.xxwyi(this); }
  get yxwyi(): Vector4i { return swz.yxwyi(this); }
  get zxwyi(): Vector4i { return swz.zxwyi(this); }
  get wxwyi(): Vector4i { return swz.wxwyi(this); }
  get xywyi(): Vector4i { return swz.xywyi(this); }
  get yywyi(): Vector4i { return swz.yywyi(this); }
  get zywyi(): Vector4i { return swz.zywyi(this); }
  get wywyi(): Vector4i { return swz.wywyi(this); }
  get xzwyi(): Vector4i { return swz.xzwyi(this); }
  get yzwyi(): Vector4i { return swz.yzwyi(this); }
  get zzwyi(): Vector4i { return swz.zzwyi(this); }
  get wzwyi(): Vector4i { return swz.wzwyi(this); }
  get xwwyi(): Vector4i { return swz.xwwyi(this); }
  get ywwyi(): Vector4i { return swz.ywwyi(this); }
  get zwwyi(): Vector4i { return swz.zwwyi(this); }
  get wwwyi(): Vector4i { return swz.wwwyi(this); }
  get xxxzi(): Vector4i { return swz.xxxzi(this); }
  get yxxzi(): Vector4i { return swz.yxxzi(this); }
  get zxxzi(): Vector4i { return swz.zxxzi(this); }
  get wxxzi(): Vector4i { return swz.wxxzi(this); }
  get xyxzi(): Vector4i { return swz.xyxzi(this); }
  get yyxzi(): Vector4i { return swz.yyxzi(this); }
  get zyxzi(): Vector4i { return swz.zyxzi(this); }
  get wyxzi(): Vector4i { return swz.wyxzi(this); }
  get xzxzi(): Vector4i { return swz.xzxzi(this); }
  get yzxzi(): Vector4i { return swz.yzxzi(this); }
  get zzxzi(): Vector4i { return swz.zzxzi(this); }
  get wzxzi(): Vector4i { return swz.wzxzi(this); }
  get xwxzi(): Vector4i { return swz.xwxzi(this); }
  get ywxzi(): Vector4i { return swz.ywxzi(this); }
  get zwxzi(): Vector4i { return swz.zwxzi(this); }
  get wwxzi(): Vector4i { return swz.wwxzi(this); }
  get xxyzi(): Vector4i { return swz.xxyzi(this); }
  get yxyzi(): Vector4i { return swz.yxyzi(this); }
  get zxyzi(): Vector4i { return swz.zxyzi(this); }
  get wxyzi(): Vector4i { return swz.wxyzi(this); }
  get xyyzi(): Vector4i { return swz.xyyzi(this); }
  get yyyzi(): Vector4i { return swz.yyyzi(this); }
  get zyyzi(): Vector4i { return swz.zyyzi(this); }
  get wyyzi(): Vector4i { return swz.wyyzi(this); }
  get xzyzi(): Vector4i { return swz.xzyzi(this); }
  get yzyzi(): Vector4i { return swz.yzyzi(this); }
  get zzyzi(): Vector4i { return swz.zzyzi(this); }
  get wzyzi(): Vector4i { return swz.wzyzi(this); }
  get xwyzi(): Vector4i { return swz.xwyzi(this); }
  get ywyzi(): Vector4i { return swz.ywyzi(this); }
  get zwyzi(): Vector4i { return swz.zwyzi(this); }
  get wwyzi(): Vector4i { return swz.wwyzi(this); }
  get xxzzi(): Vector4i { return swz.xxzzi(this); }
  get yxzzi(): Vector4i { return swz.yxzzi(this); }
  get zxzzi(): Vector4i { return swz.zxzzi(this); }
  get wxzzi(): Vector4i { return swz.wxzzi(this); }
  get xyzzi(): Vector4i { return swz.xyzzi(this); }
  get yyzzi(): Vector4i { return swz.yyzzi(this); }
  get zyzzi(): Vector4i { return swz.zyzzi(this); }
  get wyzzi(): Vector4i { return swz.wyzzi(this); }
  get xzzzi(): Vector4i { return swz.xzzzi(this); }
  get yzzzi(): Vector4i { return swz.yzzzi(this); }
  get zzzzi(): Vector4i { return swz.zzzzi(this); }
  get wzzzi(): Vector4i { return swz.wzzzi(this); }
  get xwzzi(): Vector4i { return swz.xwzzi(this); }
  get ywzzi(): Vector4i { return swz.ywzzi(this); }
  get zwzzi(): Vector4i { return swz.zwzzi(this); }
  get wwzzi(): Vector4i { return swz.wwzzi(this); }
  get xxwzi(): Vector4i { return swz.xxwzi(this); }
  get yxwzi(): Vector4i { return swz.yxwzi(this); }
  get zxwzi(): Vector4i { return swz.zxwzi(this); }
  get wxwzi(): Vector4i { return swz.wxwzi(this); }
  get xywzi(): Vector4i { return swz.xywzi(this); }
  get yywzi(): Vector4i { return swz.yywzi(this); }
  get zywzi(): Vector4i { return swz.zywzi(this); }
  get wywzi(): Vector4i { return swz.wywzi(this); }
  get xzwzi(): Vector4i { return swz.xzwzi(this); }
  get yzwzi(): Vector4i { return swz.yzwzi(this); }
  get zzwzi(): Vector4i { return swz.zzwzi(this); }
  get wzwzi(): Vector4i { return swz.wzwzi(this); }
  get xwwzi(): Vector4i { return swz.xwwzi(this); }
  get ywwzi(): Vector4i { return swz.ywwzi(this); }
  get zwwzi(): Vector4i { return swz.zwwzi(this); }
  get wwwzi(): Vector4i { return swz.wwwzi(this); }
  get xxxwi(): Vector4i { return swz.xxxwi(this); }
  get yxxwi(): Vector4i { return swz.yxxwi(this); }
  get zxxwi(): Vector4i { return swz.zxxwi(this); }
  get wxxwi(): Vector4i { return swz.wxxwi(this); }
  get xyxwi(): Vector4i { return swz.xyxwi(this); }
  get yyxwi(): Vector4i { return swz.yyxwi(this); }
  get zyxwi(): Vector4i { return swz.zyxwi(this); }
  get wyxwi(): Vector4i { return swz.wyxwi(this); }
  get xzxwi(): Vector4i { return swz.xzxwi(this); }
  get yzxwi(): Vector4i { return swz.yzxwi(this); }
  get zzxwi(): Vector4i { return swz.zzxwi(this); }
  get wzxwi(): Vector4i { return swz.wzxwi(this); }
  get xwxwi(): Vector4i { return swz.xwxwi(this); }
  get ywxwi(): Vector4i { return swz.ywxwi(this); }
  get zwxwi(): Vector4i { return swz.zwxwi(this); }
  get wwxwi(): Vector4i { return swz.wwxwi(this); }
  get xxywi(): Vector4i { return swz.xxywi(this); }
  get yxywi(): Vector4i { return swz.yxywi(this); }
  get zxywi(): Vector4i { return swz.zxywi(this); }
  get wxywi(): Vector4i { return swz.wxywi(this); }
  get xyywi(): Vector4i { return swz.xyywi(this); }
  get yyywi(): Vector4i { return swz.yyywi(this); }
  get zyywi(): Vector4i { return swz.zyywi(this); }
  get wyywi(): Vector4i { return swz.wyywi(this); }
  get xzywi(): Vector4i { return swz.xzywi(this); }
  get yzywi(): Vector4i { return swz.yzywi(this); }
  get zzywi(): Vector4i { return swz.zzywi(this); }
  get wzywi(): Vector4i { return swz.wzywi(this); }
  get xwywi(): Vector4i { return swz.xwywi(this); }
  get ywywi(): Vector4i { return swz.ywywi(this); }
  get zwywi(): Vector4i { return swz.zwywi(this); }
  get wwywi(): Vector4i { return swz.wwywi(this); }
  get xxzwi(): Vector4i { return swz.xxzwi(this); }
  get yxzwi(): Vector4i { return swz.yxzwi(this); }
  get zxzwi(): Vector4i { return swz.zxzwi(this); }
  get wxzwi(): Vector4i { return swz.wxzwi(this); }
  get xyzwi(): Vector4i { return swz.xyzwi(this); }
  get yyzwi(): Vector4i { return swz.yyzwi(this); }
  get zyzwi(): Vector4i { return swz.zyzwi(this); }
  get wyzwi(): Vector4i { return swz.wyzwi(this); }
  get xzzwi(): Vector4i { return swz.xzzwi(this); }
  get yzzwi(): Vector4i { return swz.yzzwi(this); }
  get zzzwi(): Vector4i { return swz.zzzwi(this); }
  get wzzwi(): Vector4i { return swz.wzzwi(this); }
  get xwzwi(): Vector4i { return swz.xwzwi(this); }
  get ywzwi(): Vector4i { return swz.ywzwi(this); }
  get zwzwi(): Vector4i { return swz.zwzwi(this); }
  get wwzwi(): Vector4i { return swz.wwzwi(this); }
  get xxwwi(): Vector4i { return swz.xxwwi(this); }
  get yxwwi(): Vector4i { return swz.yxwwi(this); }
  get zxwwi(): Vector4i { return swz.zxwwi(this); }
  get wxwwi(): Vector4i { return swz.wxwwi(this); }
  get xywwi(): Vector4i { return swz.xywwi(this); }
  get yywwi(): Vector4i { return swz.yywwi(this); }
  get zywwi(): Vector4i { return swz.zywwi(this); }
  get wywwi(): Vector4i { return swz.wywwi(this); }
  get xzwwi(): Vector4i { return swz.xzwwi(this); }
  get yzwwi(): Vector4i { return swz.yzwwi(this); }
  get zzwwi(): Vector4i { return swz.zzwwi(this); }
  get wzwwi(): Vector4i { return swz.wzwwi(this); }
  get xwwwi(): Vector4i { return swz.xwwwi(this); }
  get ywwwi(): Vector4i { return swz.ywwwi(this); }
  get zwwwi(): Vector4i { return swz.zwwwi(this); }
  get wwwwi(): Vector4i { return swz.wwwwi(this); }
}

export function Mutable<T extends Vector.Type, N extends Vector.Size, V extends Constructor<Variant<T, N>>>(Variant: V){
  return class Mutable extends Variant implements Vector.Mutable {
    set x(x: number) { __set__.x(this, x); }
    set y(y: number) { __set__.y(this, y); }
    set z(z: number) { __set__.z(this, z); }
    set w(w: number) { __set__.w(this, w); }
  }
}

export const Vector = {
  __get__,
  __set__,
  Variant,
  Mutable
}