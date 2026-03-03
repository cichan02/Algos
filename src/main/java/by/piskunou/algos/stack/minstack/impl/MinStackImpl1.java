package by.piskunou.algos.stack.minstack.impl;

import by.piskunou.algos.stack.minstack.MinStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class MinStackImpl1 implements MinStack {
    private final Deque<Integer> deq;
    private final PriorityQueue<Integer> priorityQueue;

    public MinStackImpl1() {
        this.deq = new ArrayDeque<>();
        this.priorityQueue = new PriorityQueue<>();
    }

    @Override
    public void push(int val) {
        this.deq.push(val);
        this.priorityQueue.add(val);
    }

    @Override
    public void pop() {
        int val = this.deq.pop();
        this.priorityQueue.remove(val);
    }

    @Override
    public int top() {
        return this.deq.peek();
    }

    @Override
    public int getMin() {
        return this.priorityQueue.peek();
    }
}
