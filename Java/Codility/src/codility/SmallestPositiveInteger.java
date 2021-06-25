/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import java.util.*;

/**
 *
 * @author Davessenn
 */
public class SmallestPositiveInteger {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                if (i < n - 1) {
                    if (A[i] != A[i + 1] && A[i] + 1 != A[i + 1]) {
                        return A[i] + 1;
                    }
                } else {
                    return A[n - 1] + 1;
                }
            }
        }
        return 1;
    }

    //performance ok
    public static int solution2(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] >= 0 && A[i] < Integer.MAX_VALUE && A[i] + 1 < A[i + 1]) {
                return A[i] + 1;
            }
        }
        if (A[n - 1] < Integer.MAX_VALUE) {

            return A[n - 1] < 0 ? 1 : A[n - 1] + 1;
        } else {
            return 1;
        }
    }

    //correctness ok
    public static int solution3(int[] A) {
    Set<Integer> testedSet = new TreeSet();
    Set<Integer> perfectSet = new TreeSet();
   
    for(int i=0; i<A.length; i++) {
      testedSet.add(A[i]);   //convert array to set to get rid of duplicates, order int's
      perfectSet.add(i+1);  //create perfect set so can find missing int
    }
   
    for(Integer current : perfectSet) {
      if(!testedSet.contains(current)) {
        return current;
      }
    }

    if(perfectSet.size() == testedSet.size()) {
      return perfectSet.size() + 1;  //e.g. {1, 2, 3} should return 4
    }
   
    return 1; //default - e.g. if A array has negative values or just a single positive value like 10
  }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {Integer.MAX_VALUE};
//        a[0]=1;
        System.out.println("sol " + solution2(a));
    }

}
