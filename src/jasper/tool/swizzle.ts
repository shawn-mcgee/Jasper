export function swizzles() {
  return swizzle2() + swizzle3() + swizzle4();
}

export function swizzle2() {
  return swizzle2f() + swizzle2u() + swizzle2i();
}

export function swizzle2f() {
  return swizzle("f", 2);
}

export function swizzle2u() {
  return swizzle("u", 2);
}

export function swizzle2i() {
  return swizzle("i", 2);
}

export function swizzle3() {
  return swizzle3f() + swizzle3u() + swizzle3i();
}

export function swizzle3f() {
  return swizzle("f", 3);
}

export function swizzle3u() {
  return swizzle("u", 3);
}

export function swizzle3i() {
  return swizzle("i", 3);
}

export function swizzle4() {
  return swizzle4f() + swizzle4u() + swizzle4i();
}

export function swizzle4f() {
  return swizzle("f", 4);
}

export function swizzle4u() {
  return swizzle("u", 4);
}

export function swizzle4i() {
  return swizzle("i", 4);
}

export function swizzle(
  t: "f" | "u" | "i",
  n:  2  |  3  |  4 
) {
  let out = `//swizzle${n}${t}\n`;
  let names: Array<string> = ["x", "y", "z", "w"];
  let parts: Array<number> = new Array(n).fill(0);

  while (parts.at(-1)! < 4) {
    const name = parts.map(i =>      names[i]  ).join(""  );
    const args = parts.map(i => `a.${names[i]}`).join(", ");

    let   i   = 0;
    parts[i] += 1;
    while (i < n - 1 && parts[i] > 3) {
      parts[i    ]  = 0;
      parts[i + 1] += 1;
      i += 1;
    }

    out += `export function ${name}${t}(a: Vector, out ?: Vector${n}${t}.Mutable) {\n`;
    out += `  return out${n}${t}(out, ${args});\n`;
    out += `}\n\n`;
  }

  return out;
}

import fs from "node:fs";

try {

  fs.writeFileSync("./swizzle.txt", swizzles());
} catch (e) {
  console.log(e);
}
