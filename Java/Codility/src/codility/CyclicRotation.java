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
public class CyclicRotation {

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int n = A.length;
        if (n <= 0) {
            return A;
        }
        int L = K % n;
        int[] B = new int[n];
        if (L != 0) {
            for (int i = 0; i < n; i++) {
                if (i + L < n) {
                    B[i + L] = A[i];
                } else {
                    B[i + L - n] = A[i];
                }
            }
            return B;
        }
        return A;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {};
        int b[] = solution(a, 5);
        System.out.println(6 % 2);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

}
