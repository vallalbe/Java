package com.pari.poc;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                //System.out.println("ch = " + ch);


                for (int j = i - 1; j >= 0; j--) {
                    char c2 = s.charAt(j);
                    //System.out.println("c2 = " + c2);
                    if (Character.isDigit(c2)) {
                        break;
                    } else {
                        sb.append(c2);
                    }
                }
                //Appending Capital letter
                sb.append(ch);
                for (int j = i + 1; j < s.length(); j++) {
                    char c1 = s.charAt(j);

                    if (Character.isDigit(c1)) {
                        break;
                    } else {
                        sb.append(c1);
                    }
                }


            }
        }
        System.out.println("valid password= " + sb);
        if (sb.length() > 0) {
            return 2;
        } else {
            return -1;
        }
    }
}
