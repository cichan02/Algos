package by.piskunou.algos;

import by.piskunou.algos.arraysandhashing.LongestConsecutiveSeq;


public class App {
    public static void main(String[] args) {
        // --- Param(-s) ---
        var param1 = new int[]{1,0,1,2};
        var param2 = 2;

        // --- Solution(-s) ---
        var solution = new LongestConsecutiveSeq();

        // -- Answer(-s) ---
        var ans = solution.longestConsecutive3(param1);

        // --- Print section ---
        System.out.println(ans);
    }
}