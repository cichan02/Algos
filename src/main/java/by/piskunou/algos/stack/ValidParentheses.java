package by.piskunou.algos.stack;

import java.util.*;

public class ValidParentheses {
    private static final Map<Character, Character> PARENTHESES = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (PARENTHESES.containsKey(c)) {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty() || !PARENTHESES.get(stack.pop()).equals(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
