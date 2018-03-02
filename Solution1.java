package com.pari.poc;

public class Solution1 {
    public static void main(String[] args) {
        String result = Solution1.solution("ABBCC");
        System.out.println("result = " + result);
    }
    public static String solution(String S) {
        final char C = 'C';
        final char A = 'A';

        // if contains only B return itself
        if (!S.contains("A") || !S.contains("C"))
            return S;

        String res = "";
        boolean hasLetterChanged = false;
        char prevChar = 'D';
        for (char c : S.toCharArray()) {
            if (c == A) {
                if (prevChar == C) {
                    hasLetterChanged = true;
                }
            } else if (c == C) {
                if (prevChar == A) {
                    hasLetterChanged = true;
                }
            }
            if (hasLetterChanged) {
                res = res + prevChar;
                hasLetterChanged = false;
            }
            if (c == A || c == C) {
                prevChar = c;
            }
        }

        return res + prevChar;
    }
}

