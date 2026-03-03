package by.piskunou.algos.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class EvaluateReversePolishNotation {
    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        Deque<Long> deq = new ArrayDeque<>();
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                long right = deq.pop();
                long left = deq.pop();
                switch (token) {
                    case "+" -> deq.push(left + right);
                    case "-" -> deq.push(left - right);
                    case "*" -> deq.push(left * right);
                    case "/" -> deq.push(left / right);
                }
            } else {
              deq.push(Long.parseLong(token));
            }
        }
        return deq.pop().intValue();
    }
}
