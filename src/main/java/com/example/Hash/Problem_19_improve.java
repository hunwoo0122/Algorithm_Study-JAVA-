package com.example.Hash;

import java.util.HashMap;

public class Problem_19_improve {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String answer = solution(participant, completion);
        System.out.println(answer);
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();  // 제네릭 명시로 경고 해결
        String answer = "";

        for (String name : participant) {
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);  // 코드 간결화
        }

        for (String name : completion) {
            hashMap.put(name, hashMap.get(name) - 1);
        }

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
