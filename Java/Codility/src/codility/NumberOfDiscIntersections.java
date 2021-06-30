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
public class NumberOfDiscIntersections {

    public static int solution(int[] A) {
        // write your code in Java SE 8
//        Arrays.sort(A);
        int n = A.length;
        int count = 0;
        int i = 0;
        int j;
        while (i < n) {
            j = i + 1;
            while (j < n) {
                if (j - i <= (long) A[i] + (long) A[j]) {
                    count++;
                }
                j++;
            }
            i++;
        }
        if (count > 10000000) {
            return -1;
        }
        return count;

    }

    public static int solution2(int[] A) {
        // variable holding max intersections given in problem description (10,000,000)
        final int MAX_INTERSECTIONS = 10000000;
        // variable to keep the length of A
        int N = A.length;
        //initialize arrays to store our discs' end points
        // left end points
        int[] discStartPoint = new int[N];
        // right end points
        int[] discEndPoint = new int[N];

        //populate the arrays
        for (int i = 0; i < N; i++) {
            discStartPoint[i] = i - A[i];
            // if we can overflow, Example: i = 5; A[i] = Integer.MAX_VALUE; discEndPoint[i] = 5 + Integer.MAX_VALUE, causes overflow
            if (Integer.MAX_VALUE - A[i] < i) {
                discEndPoint[i] = Integer.MAX_VALUE;
            } else {
                discEndPoint[i] = i + A[i];
            }
        }

        // sort the arrays
        Arrays.sort(discStartPoint);
        Arrays.sort(discEndPoint);

        //variable for traversing "discStartPoint" array
        int startPointIndex = 0;
        //variable for traversing "discEndPoint" array 
        int endPointIndex = 0;

        // How many discs are currently open 
        int openDiscs = 0;
        // number of intersections
        int intersections = 0;

        //While we have not went through all of the discs available
        //loop ends when all discs are opened
        while (startPointIndex < N) {
            // if we open a disc
            // every time we open a disc, the disc will intersect with all previously opened discs
            // and this new disc will be used for calculating future intersections
            if (discStartPoint[startPointIndex] <= discEndPoint[endPointIndex]) {
                intersections = intersections + openDiscs;
                // if our intersections are greater than max_intersections (see problem description) 
                if (intersections > MAX_INTERSECTIONS) {
                    return -1;
                }
                openDiscs++;
                startPointIndex++;
            } // else, we close a disc
            // this means that we have one less disc to intersect with
            else {
                openDiscs--;
                endPointIndex++;
            }

        }

        return intersections;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 1, 4, 0};
        System.out.println("sol " + solution2(a));

    }

}
