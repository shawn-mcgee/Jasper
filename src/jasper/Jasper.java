package jasper;

import jasper.util.Console;
import jasper.util.Version;

import java.util.Arrays;

public class Jasper {
    public static final Version
        VERSION = new Version("Jasper", 0, 1, 0);

    public static void main(String[] args) {
        Console.info(VERSION);

//        Console.info();
//        test(1000, "ArrayList.add", () -> {
//            ArrayList<Integer> a = new ArrayList<>();
//            for(int i = 0; i < 100000; i ++)
//                a.add(i);
//        });
//        test(1000, "ArrayList.add", () -> {
//            ArrayList<Integer> a = new ArrayList<>();
//            for(int i = 0; i < 100000; i ++)
//                a.add(i);
//        });
//
//        Console.info();
//        test(1000, "ArrayStack.push", () -> {
//            ArrayStack<Integer> a = new ArrayStack<>();
//            for(int i = 0; i < 100000; i ++)
//                a.push(i);
//        });
//        test(1000, "ArrayStack.push", () -> {
//            ArrayStack<Integer> a = new ArrayStack<>();
//            for(int i = 0; i < 100000; i ++)
//                a.push(i);
//        });
//
//        Console.info();
//        test(1000, "ArrayDeque.pushHead", () -> {
//            ArrayDeque<Integer> a = new ArrayDeque<>();
//            for(int i = 0; i < 100000; i ++)
//                a.pushHead(i);
//        });
//        test(1000, "ArrayDeque.pushHead", () -> {
//            ArrayDeque<Integer> a = new ArrayDeque<>();
//            for(int i = 0; i < 100000; i ++)
//                a.pushHead(i);
//        });
//
//        Console.info();
//        test(1000, "ArrayDeque.pushTail", () -> {
//            ArrayDeque<Integer> a = new ArrayDeque<>();
//            for(int i = 0; i < 100000; i ++)
//                a.pushTail(i);
//        });
//        test(1000, "ArrayDeque.pushTail", () -> {
//            ArrayDeque<Integer> a = new ArrayDeque<>();
//            for(int i = 0; i < 100000; i ++)
//                a.pushTail(i);
//        });
    }

    private static final long
        ONE_SECOND = 1000000000,
        ONE_MILLIS =    1000000;

    public static void test(int n, String name, Test test) {
        try {
            long a, b;
            double[] data = new double[n];

            for (int i = 0; i < n; i++) {
                a = System.nanoTime();
                test.perform();
                b = System.nanoTime();

                System.gc();

                data[i] = (double)(b - a) / ONE_MILLIS;
            }

            Arrays.sort(data);

            double
                min = data[        0],
                med = data[2 * n / 4],
                max = data[    n - 1],
                avg = 0.,
                std = 0.;

            for (double datum : data)
                avg += datum;
            avg =           avg / n ;

            for (double datum : data)
                std += (datum - avg) * (datum - avg);
            std = Math.sqrt(std / n);

            Console.info(String.format("%1$s: %2$5.2f ~ %3$5.2f [%4$5.2f - %5$5.2f - %6$5.2f] ms", name, avg, std, min, med, max));

        } catch(Exception e) {
            Console.warn(String.format("%1$s: ERROR", name));
            Console.warn(                                 e);
            e.printStackTrace();
        }
    }

    public static interface Test {
        public void perform();
    }
}
