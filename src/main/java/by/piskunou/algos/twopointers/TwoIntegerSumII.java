package by.piskunou.algos.twopointers;

public class TwoIntegerSumII {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) {
            return new int[]{1, 2};
        }

        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
                continue;
            }

            if (numbers[i] + numbers[j] > target) {
                j--;
                continue;
            }

            break;
        }

        return new int[]{i+1, j+1};
    }
}
