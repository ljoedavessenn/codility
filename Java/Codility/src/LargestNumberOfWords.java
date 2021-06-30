/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davessenn
 */
public class LargestNumberOfWords {

    public static int countWord(String S) {
        if (S.length() > 0) {
            String sen=S.replace("  ", " ");
            sen=sen.replace("   ", " ");
            sen=sen.replace("    ", " ");
            sen=sen.replace("     ", " ");
            sen=sen.replace("      ", " ");
            String[] words = sen.split(" ");
            for (String word : words) {
                System.out.println("word _" + word + "_");
            }
            return words.length;
        } else {
            return 0;
        }

    }

    public static String clean(String S) {
        //remove space if first char

        while (S.length() > 0 && S.charAt(0) == ' ') {
            S = S.substring(1);
        }

        while (S.length() > 0 && S.charAt(S.length() - 1) == ' ') {
            if (S.length() > 2) {
                S = S.substring(0, S.length() - 2);
            } else {
                S = "";
            }
        }

        return S;
    }

    public static int solution(String S) {
        // write your code in Java SE 8

        String cleanSentences = clean(S);
        int max = 0;
        if (cleanSentences.length() > 0) {
            String[] sentences = S.split("[.?!]");
            System.out.println("length " + sentences.length);
            for (String sentence : sentences) {
                String cleanSentence = clean(sentence);
                int count = countWord(cleanSentence);
                if (max < count) {
                    max = count;
                }
                System.out.println(sentence + " word " + count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "Forget  CVs..Save time . x x";
        System.out.println("max " + solution(s));
    }
}
