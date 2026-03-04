package by.piskunou.algos;

import by.piskunou.algos.stack.DailyTemperatures;

import java.util.Arrays;
import java.util.List;


public class App {
    public static void main(String[] args) {
        // --- Param(-s) ---
        var param1 = new int[]{30, 38, 30, 36, 35, 40, 28};
        var param2 = new int[]{22,21,20};
        var params = List.of(param1, param2);

        // --- Solution ---
        var solution = new DailyTemperatures();

        // -- Answer(-s) ---
        for (var param : params) {
            var ans = Arrays.toString(solution.dailyTemperatures(param));
            System.out.println(ans);
        }
    }
}