package com.pari.poc;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int a[]=new int[6];
        a[0]=8;//initialization
        a[1]=24;
        a[2]=3;
        a[3]=20;
        a[4]=1;
        a[5]=17;

        int A[]=new int[6];
        A[0] = 7;
        A[1] = 21;
        A[2] = 3;
        A[3] = 42;
        A[4] = 3;
        A[5] = 7;
        //{8,24,3,20,1,17};
       // System.out.println(solution(A));
        System.out.println(solution(a));

        int b[]=new int[]{2,1,5,-6,9};
        //System.out.println(solution5(b));



    }

    public static int solution5(int[] A) {
        int evenCount = 0;
        int oddCount = 0;

        for (int number : A) {
            if ((number & 1) == 0) {
                evenCount++;
            }
        }

        oddCount = A.length - evenCount;
        long temp = (evenCount * (evenCount - 1) / 2)
                + (oddCount * (oddCount - 1) / 2);

        if (temp >= 1000000000) {
            return -1;
        }

        return (int) temp;
    }
    public static int solution(int[] A) {
        int length = A.length;
        int smallest = Integer.MAX_VALUE -1;
        int smaller = Integer.MAX_VALUE;

        for(int i =0; i<length;i++){
            if(A[i] <= smallest){
                smaller = smallest;
                smallest = A[i];
            }
            else if(A[i] <smaller) {
                smaller = A[i];
            }
        }
        return smaller-smallest;
    }

    public static  int solution1(int[] A) {

        long rsum = 0;

        for (int i = 1; i < A.length; i++)
            rsum += A[i];

        long lsum = A[0];
        int min = (int) Math.abs(lsum - rsum);
        for (int i = 1; i < A.length-1; i++) {
            lsum += A[i];
            rsum -= A[i];
            int diff = (int) Math.abs(lsum - rsum);
            if (diff < min)
                min = diff;
        }

        return min;
    }



    public static  int solution3(int[] A) {
        long sumright = 0;
        long sumleft = 0;
        long ans = 0;

        for (int i =1;i<A.length;i++)
            //sumright += A[i];

        //sumleft = A[0];
        ans =Math.abs(Math.abs(sumright)+Math.abs(sumleft));

        for (int P=1; P<A.length; P++)
        {
            if (Math.abs(Math.abs(sumleft) - Math.abs(sumright))<ans)
                ans = Math.abs(Math.abs(sumleft) - Math.abs(sumright));
           // sumleft += A[P];
            //sumright -=A[P];
        }
        return (int) ans-1;
    }

    public static int solution4(int[] A) {
        int [] diff;
        int sum1;
        int sum2=0;
        int ans, localMin;
        diff = new int[A.length-1];

        //AT P=1 sum1=A[0]
        sum1=A[0];

        for (int i =1;i<A.length;i++){
            sum2 += A[i];
        }

        ans = Math.abs(sum1- sum2);

        for (int p= 1;p<A.length;p++){
            localMin= Math.abs(sum1- sum2);

            if( localMin < ans ){
                ans = localMin;
            }
            //advance the sum1, sum2
            sum1+= A[p];
            sum2-= A[p];
            diff[p-1]=localMin;
        }
        return (getMinVal(diff));
    }
    public static  int getMinVal(int[] arr){
        int minValue = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] < minValue){
                minValue = arr[i];
            }
        }
        return minValue;
    }
}
