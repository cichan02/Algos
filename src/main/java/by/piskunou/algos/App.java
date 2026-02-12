package by.piskunou.algos;

import by.piskunou.algos.twopointers.ThreeSum;


public class App {
    public static void main(String[] args) {
        // --- Param(-s) ---
        var param1 = new int[]{-1, 0, 1, 2, -1, -4};
        var param2 = 3;

        // --- Solution(-s) ---
        var solution = new ThreeSum();

        // -- Answer(-s) ---
        var ans = solution.threeSum1(param1);

        // --- Print section ---
        System.out.println(ans);
    }
}