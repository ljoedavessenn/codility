/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Davessenn
 */
public class BankTransaction {

    public static int solution(int[] A, String[] D) {
        // write your code in Java SE 8
        int money = 0;
        int month = 0;
        int monthCardPayment = 0;
        int monthCount = 0;
        int monthToPay = 12;
        for (int i = 0; i < A.length; i++) {
            //System.out.println(D[i].substring(5, 7));
            int m = Integer.parseInt(D[i].substring(5, 7));
            //System.out.println("m "+m);
            //System.out.println("month "+month);
            money += A[i];
            if (m == month) {
                if (A[i] < 0) {
                    monthCount++;
                    monthCardPayment += A[i];
                }
            } else {
                month=m;
                monthCount = 1;
                if (A[i] < 0) {
                    monthCardPayment = A[i];
                }
            }
            if (monthCount >= 3 && monthCardPayment <= -100) {
                    monthToPay--;
                }
            //System.out.println("monthCount"+ monthCount);
            //System.out.println("monthCardPayment"+ monthCardPayment);
            //System.out.println("monthToPay"+ monthToPay);
        }
        int total=money-(5*monthToPay);
        return total;
    }

    public static void main(String[] args) {
        int[] A = {180, -50, -25, -25}; 
        String[] D={"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"};
        System.out.println("sol "+solution(A, D));
    }
}
