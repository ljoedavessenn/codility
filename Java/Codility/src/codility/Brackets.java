/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Davessenn
 */
public class Brackets {

    public boolean isStarting(char c) {
        return (c == '{' || c == '[' || c == '(');
    }

    public boolean match(char c, char start) {
        switch (start) {
            case '{':
                return c == '}';
            case '[':
                return c == ']';
            case '(':
                return c == ')';
            default:
                return false;
        }
    }

    public int solution(String S) {
        Deque<Character> stack
                = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (isStarting(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                } else {
                    char start = stack.pop();
                    if (!match(c, start)) {
                        return 0;
                    }
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {

    }
}
