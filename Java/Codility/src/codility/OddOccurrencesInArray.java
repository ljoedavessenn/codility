/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

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
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {1, 1, 2}; 
//        a[0]=1;
//        System.out.println("sol 1 "+solution(a));
        System.out.println("sol " + solution(a));
    }

}
