/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Davessenn
 */
public class DistinctValueArray {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Set<Integer> targetSet = new HashSet<>(Arrays.asList(arr));
        return targetSet.size();
    }
    
    public static int solution2(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int i=0;
        int count=0;
        int j;
        while (i<A.length){
            j=i+1;
            while(j<A.length && A[i]==A[j]){
                j++;
            }
            count++;
            i=j;
        };
        return count;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        int a[] = {33, 3, 4, 5, 5};
        int a[] = new int[0];
//        a[0]=1;
//        System.out.println("sol 1 "+solution(a));
        System.out.println("sol 2 "+solution2(a));
    }

}
