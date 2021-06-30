/*
MissingInteger
Find the smallest positive integer that does not occur in a given sequence.

Task description
This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
*/
package codility;

import java.util.*;

/**
 *
 * @author Davessenn
 */
public class MissingInteger {

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
        int min=1;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] >= 0 && A[i] + 1 < A[i + 1]) {
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
      testedSet.add(A[i]);  //convert array to set to get rid of duplicates, order int's
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
        int a[] = {20,21,32,54};
//        a[0]=1;
        System.out.println("sol " + solution2(a));
    }

}
