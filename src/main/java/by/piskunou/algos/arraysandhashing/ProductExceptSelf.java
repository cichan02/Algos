package by.piskunou.algos.arraysandhashing;

public class ProductExceptSelf {
    public int[] productExceptSelf1(int[] nums) {
        int product = 1;
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIndex == -1) {
                    zeroIndex = i;
                    continue;
                } else {
                    return new int[nums.length];
                }
            }
            product *= nums[i];
        }

        int[] res = new int[nums.length];
        if (zeroIndex != -1) {
            res[zeroIndex] = product;
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = product / nums[i];
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] pref = new int[nums.length];
        pref[0] = 1;
        int[] suff = new int[nums.length];
        suff[nums.length - 1] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            pref[i+1] = pref[i] * nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            suff[i] = suff[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = pref[i] * suff[i];
        }
        return nums;
    }

    public int[] productExceptSelf3(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        int suff = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            res[i+1] = res[i] * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= suff;
            suff *= nums[i];
        }

        return res;
    }
}
