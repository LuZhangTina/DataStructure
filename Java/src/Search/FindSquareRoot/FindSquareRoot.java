package com.tina.search;

/**
 * Created by tina on 2019/1/20.
 *
 * Calculate x's square root by using binary search algorithm
 *
 * eg.
 * double result = FindSquareRoot.findSquareRoot(0, 0.000001);
 * double expected = 0;
 * boolean flag = false;
 * if (Math.abs(expected - result) < 0.000001) {
 *    flag = true;
 * }
 * Assert.assertEquals(true, flag);
 *
 */
public class FindSquareRoot {
    public static double findSquareRoot(double x, double precision) {
        if (x == 1 || x == 0) {
            return x;
        }
        if (x < 0) {
            return Double.NaN;
        }
        double low = 0;
        double high = 0;
        double mid = 0;
        if (x > 0 && x < 1) {
            low = x;
            high = 1;
        } else {
            low = 1;
            high = x;
        }

        while (high - low > precision) {
            mid = low + (high - low) / 2;
            if (mid * mid > x) {
                high = mid;
            } else if (mid * mid < x){
                low = mid;
            } else{
                return mid;
            }
        }

        return mid;
    }
}
