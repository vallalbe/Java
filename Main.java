package com.pari.poc;

import org.apache.commons.lang.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//201,206,207,209
public class Main {
    public static void main(String[] args) throws IOException {

        //Scanner ss = new Scanner(System.in);
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        System.out.print("Enter the your A's entries : ");
        // Below Statement used for getting String including sentence
        String s1 = br.readLine();
        ArrayList<Integer> lst1 = new ArrayList<Integer>();
        for (String field : s1.split(","))
            lst1.add(Integer.parseInt(field));

        System.out.println("received entries from A:  " + lst1);


        System.out.print("Enter the your B's entries : ");
        String s2 = br.readLine();
        List<Integer> lst2 = new ArrayList<Integer>();
        for (String field : s2.split(","))
            lst2.add(Integer.parseInt(field));

        System.out.println("received entries from B:  " + lst2);

        /*Set<Integer> set1= new HashSet(lst1);
        Set<Integer> set2= new HashSet(lst2);
        Collection res = CollectionUtils.disjunction(set1, set2);
        System.out.println(res);*/


        Integer[] l1 = lst1.toArray(new Integer[lst1.size()]);
        Integer[] l2 = lst2.toArray(new Integer[lst2.size()]);
        int[] a = ArrayUtils.toPrimitive(l1);
        int[] b = ArrayUtils.toPrimitive(l2);

       /* List<Integer> result = findCommonElement(a, b);
        System.out.println("result = " + result);*/

        Set<Integer> set1 = new HashSet<Integer>(lst1);
        Set<Integer> set2 = new HashSet<Integer>(lst2);
        Set<Integer> res = symmetricDifference(set1, set2);
        System.out.println("res = " + res);
    }

    public static List<Integer> findCommonElement(int[] a, int[] b) {

        List<Integer> commonElements = new ArrayList<Integer>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    //Check if the list already contains the common element
                    if (!commonElements.contains(a[i])) {
                        //add the common element into the list
                        commonElements.add(a[i]);
                    }
                }
            }
        }
        return commonElements;
    }

    private static Set<Integer> symmetricDifference(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<Integer>(a);
        for (Integer element : b) {
            // .add() returns false if element already exists
            if (!result.add(element)) {
                result.remove(element);
            }
        }
        return result;
    }
}
