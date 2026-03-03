package by.piskunou.algos;

import by.piskunou.algos.stack.minstack.MinStack;
import by.piskunou.algos.stack.minstack.impl.MinStackImpl3;
import by.piskunou.algos.stack.ValidParentheses;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        // --- Param(-s) ---
        var param1 = "[]";
        var param2 = "([{}])";
        var param3 = "[({)";
        var param4 = "()[";
        var param5 = "]";
        var params = List.of(param1, param2, param3, param4, param5);

        // --- Solution ---
        var solution = new ValidParentheses();

        // -- Answer(-s) ---
        var ans = new ArrayList<Boolean>();
        for (var i = 0; i < params.size(); i++) {
            ans.add(solution.isValid(params.get(i)));
        }

        // --- Print section ---
        System.out.println(ans);

        MinStack minStack = new MinStackImpl3();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}