/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Davessenn
 */
public class OddOccurrencesInArray {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, Integer> hash_table = new java.util.HashMap<Integer, Integer>();
        int n = A.length;
        for(int i=0;i<n;i++)
        {
            Integer freq = hash_table.get(A[i]);
            hash_table.put(A[i], (freq == null) ? 1 : freq + 1); 
        }
        for (int i = 0; i < n; i++)
        {
            if (hash_table.get(A[i])==1)
            {
//                System.out.println("First non-repeating element is: "+A[i]);
                return A[i];
            }
        }
//        System.out.println("All the elements are repeating.");
        return A[A.length-1];
    }
    
    public static int solution2(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int i = 0;
        int j;
        while (i < A.length) {

//        System.out.println("i "+i+" A[i] "+A[i]);
            j = i + 1;
            while (j < A.length) {

//        System.out.println("j "+j+"A[j] "+A[j]);
                if (A[i] != A[j]) {
                    if (j == i + 1) {
                        return A[i];
                    } else {
                        i = j - 1;
                        break;
                    }
                } else {
                    j++;
                }
            }

            i++;
        }
        return A[A.length - 1];
    }
    
    public static int solution3(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int n=A.length;
        if(n==1){
            return A[0];
        }
        
        int i = 0;
        int count=1;
        while(i<n){
            count=1;
            while (i+count < n && A[i]==A[i+count]) {
            count ++;
        }
            if(count==1) return A[i];
            i+=count;
        }
        return A[A.length-1];
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {9,1,2,2,1,8,8}; 
//        a[0]=1;
//        System.out.println("sol 1 "+solution(a));
        System.out.println("sol " + solution3(a));
    }

}
