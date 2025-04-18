package com.example.Hash;

import java.util.HashSet;

public class Problem_18 {
    public boolean solution(int[] arr ,int target) {

        HashSet<Integer> hs = new HashSet<>();

        for(int i : arr) {
            if(hs.contains(target - i)) return true;
            hs.add(i);
        }

        return false;
    }
}
