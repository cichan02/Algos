package by.piskunou.algos.twopointers;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.sort(Comparator.naturalOrder());
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result.stream().toList();
    }
}
