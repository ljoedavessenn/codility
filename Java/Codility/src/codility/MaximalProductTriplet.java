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
public class MaximalProductTriplet {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int i = 0;
        int max = Integer.MIN_VALUE;
        int val;
        int j;
        int k;
        while (i < A.length) {
            j = i + 1;
            while (j < A.length) {
                k=j+1;
                while (k < A.length) {
                    val=A[i]*A[j]*A[k];
                    if (max<val) max=val;
                    k++;
                }
                j++;
            }
            i++;
        }
        return max;
    }
    
    public static int solution2(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        
        int max=A[0]*A[1]*A[A.length-1];
        int val=A[A.length-3]*A[A.length-2]*A[A.length-1];
        return max<val?val:max;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {-3, 1, 2}; 
//        a[0]=1;
//        System.out.println("sol 1 "+solution(a));
        System.out.println("sol " + solution2(a));
    }

}
