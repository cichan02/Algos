package by.piskunou.algos.twopointers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class TrappingRainWater {
    public int trap1(int[] height) {
        int leftMax = 0;
        int[] leftHeights = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftHeights[i] = leftMax;
        }

        int rightMax = 0;
        int canBeTrapped = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            canBeTrapped += Math.min(leftHeights[i], rightMax) - height[i];
        }

        return canBeTrapped;
    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }

    //не разумею(((
    //TODO: разабрацца
    public int trap3(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int mid = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int right = height[i];
                    int left = height[stack.peek()];
                    int h = Math.min(right, left) - mid;
                    int w = i - stack.peek() - 1;
                    res += h * w;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
