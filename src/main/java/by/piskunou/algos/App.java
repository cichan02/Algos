package by.piskunou.algos;

import by.piskunou.algos.arraysandhashing.TopKFrequent;

public class App {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;
        var app = new TopKFrequent();
        var ans = app.topKFrequent1(nums, k);
        System.out.println(ans);
    }
}