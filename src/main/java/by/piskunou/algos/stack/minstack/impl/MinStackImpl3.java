package by.piskunou.algos.stack.minstack.impl;

import by.piskunou.algos.stack.minstack.MinStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackImpl3 implements MinStack {
    private final Deque<Long> stack;

    private long min;

    public MinStackImpl3() {
        this.stack = new ArrayDeque<>();
        this.min = Long.MAX_VALUE;
    }

    @Override
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min) min = val;
        }
    }

    @Override
    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;
    }

    @Override
    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }

    @Override
    public int getMin() {
        return (int) min;
    }
}
