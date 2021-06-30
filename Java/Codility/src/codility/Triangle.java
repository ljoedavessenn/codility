/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import java.util.Arrays;

/**
 *
 * @author Davessenn
 */
public class Triangle {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int n = A.length;
        if (n >= 3) {
            for (int i = 0; i < n - 2; i++) {
                if ((long)A[i] + (long)A[i + 1] > (long)A[i + 2]) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("sol " + solution(a));
    }

}
