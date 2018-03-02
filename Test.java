package com.pari.poc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Test t = new Test();
        //int result = t.solution("a0xBcs3f");
        //System.out.println("result = " + result);

        //t.solution2(553);


    }



    public int solution2(int N){
        int number = N;
        int sorted = 0;
        int digits = 10;
        int sortedDigits = 1;
        boolean first = true;

        while (number > 0) {
            int digit = number % 10;

            if (!first) {

                int tmp = sorted;
                int toDivide = 1;
                for (int i = 0; i < sortedDigits; i++) {
                    int tmpDigit = tmp % 10;
                    if (digit >= tmpDigit) {
                        sorted = sorted/toDivide*toDivide*10 + digit*toDivide + sorted % toDivide;
                        break;
                    } else if (i == sortedDigits-1) {
                        sorted = digit * digits + sorted;
                    }
                    tmp /= 10;
                    toDivide *= 10;
                }
                digits *= 10;
                sortedDigits += 1;
            } else {
                sorted = digit;
            }

            first = false;
            number = number / 10;
        }
        System.out.println(reverseInt(sorted));
        return 0;
    }
    public int reverseInt(int input) {
        long reversedNum = 0;
        long input_long = input;

        while (input_long != 0) {
            reversedNum = reversedNum * 10 + input_long % 10;
            input_long = input_long / 10;
        }

        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE) {
            throw new IllegalArgumentException();
        }
        return (int) reversedNum;
    }

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
