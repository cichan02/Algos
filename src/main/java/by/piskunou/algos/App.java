package by.piskunou.algos;

import by.piskunou.algos.twopointers.TrappingRainWater;


public class App {
    public static void main(String[] args) {
        // --- Param(-s) ---
        var param1 = new int[]{4,2,0,3,2,5};
        var param2 = 3;

        // --- Solution(-s) ---
        var solution = new TrappingRainWater();

        // -- Answer(-s) ---
        var ans = solution.trap2(param1);

        // --- Print section ---
        System.out.println(ans);
    }
}