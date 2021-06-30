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

    //correctness ok
    public static int solution2(int[] A) {
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
    
    //The good solution
    public static int solution(int[] A) {
        Arrays.sort(A);
        int i = 0;
        int n = A.length;
        int response = 1;
        if (n == 0) {
            return response;
        } else {
            while (i < n && A[i] < 1) {
                i++;                
                System.out.println("i "+i);
            }
            if(i==n || A[i]>1){
              return response;  
            } else {
                while(i<n-1 && A[i+1]<=A[i]+1){
                    i++;
                }
                return A[i]+1;
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {};
//        a[0]=1;
        System.out.println("sol " + solution(a));
    }

}
