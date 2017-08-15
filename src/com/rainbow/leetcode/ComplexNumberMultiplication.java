package com.rainbow.leetcode;

/**
 * https://leetcode.com/problems/complex-number-multiplication/description/
 */
public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        String a1 = "1+1i";
        String b1 = "1+1i";
        System.out.println(new ComplexNumberMultiplication().complexNumberMultiply(a1, b1));

        String a2 = "1+-1i";
        String b2 = "1+-1i";
        System.out.println(new ComplexNumberMultiplication().complexNumberMultiply(a2, b2));
    }

    public String complexNumberMultiply(String a, String b) {
        int[] a1b1 = getAB(a);
        int[] a2b2 = getAB(b);
        int a1 = a1b1[0];
        int b1 = a1b1[1];

        int a2 = a2b2[0];
        int b2 = a2b2[1];

        int newA = a1 * a2 - b1 * b2;
        int newB = a1 * b2 + a2 * b1;

        return String.format("%d+%di", newA, newB);
    }

    private int[] getAB(String str) {
        String[] split = str.split("\\+");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1].substring(0, split[1].length() - 1));
        return new int[] { a, b };
    }
}
