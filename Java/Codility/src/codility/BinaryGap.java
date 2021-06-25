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
public class BinaryGap {
    

    public static int solution(int N) {
        // write your code in Java SE 8
        String binaryString=Integer.toBinaryString(N);
        int maxGap=0;
        int i=0;
        int j;
        int n=binaryString.length();
        while(i<n){
            if(binaryString.charAt(i)=='1'){
                j=i+1;
                while (j<n){
                    if(binaryString.charAt(j)=='1'){
                        if(maxGap<j-i-1) maxGap=j-i-1;
                        break;
                    } else {
                        j++;
                    }
                }
                i=j;
            }
        }
        return maxGap;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("sol " + solution(1041));
    }

}
