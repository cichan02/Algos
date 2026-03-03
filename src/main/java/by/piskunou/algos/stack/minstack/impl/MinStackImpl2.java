package by.piskunou.algos.stack.minstack.impl;

import by.piskunou.algos.stack.minstack.MinStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackImpl2 implements MinStack {
    private final Deque<Integer> deq;
    private final Deque<Integer> minDeq;

    public MinStackImpl2() {
        this.deq = new ArrayDeque<>();
        this.minDeq = new ArrayDeque<>();
    }

    @Override
    public void push(int val) {
        this.deq.push(val);
        if (this.minDeq.isEmpty() || val <= this.minDeq.peek()) {
            this.minDeq.push(val);
        }
    }

    @Override
    public void pop() {
        if (this.deq.isEmpty()) return;
        int top = this.deq.pop();
        if (top == this.minDeq.peek()) {
            this.minDeq.pop();
        }
    }

    @Override
    public int top() {
        return this.deq.peek();
    }

    @Override
    public int getMin() {
        return this.minDeq.peek();
    }
}
