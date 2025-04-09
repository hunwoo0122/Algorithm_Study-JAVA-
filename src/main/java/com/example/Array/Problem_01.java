package com.example.Array;

import java.io.IOException;
import java.util.Arrays;

public class Problem_01 {
    public static void main(String[] args) {
        int[] org = {4, 2, 3, 1, 5};
        int[] sorted = solution(org);
        System.out.println(Arrays.toString(org));
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] solution(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        return clone;
    }
}