package by.piskunou.algos.arraysandhashing;

import com.sun.source.doctree.SerialTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSeq {
    record Pair(int length, boolean flag) {

    }

    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Map<Integer, Pair> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, new Pair(1, false));
        }

        int longest = 1;
        for (int j: nums) {
            int num = j;
            Pair p = map.get(num);
            if (p.flag) {
                continue;
            }
            map.put(num, new Pair(1, true));

            boolean b = true;
            while (b) {
                if (map.containsKey(num + 1)) {
                    int len = map.get(num).length + 1;
                    if (len > longest) {
                        longest = len;
                    }
                    map.put(num + 1, new Pair(len, true));
                    num++;
                } else {
                    b = false;
                }
            }
        }
        return longest;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;


        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num-1)) {
                Set<Integer> set = map.get(num-1);
                set.add(num);
                map.put(num, set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(num);
                map.put(num, set);
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (map.containsKey(num+1)) {
                Set<Integer> set = map.get(num+1);
                set.addAll(map.get(num));
                map.put(num, set);
            }
        }

        int longest = 0;
        for (Set<Integer> set : map.values()) {
            if (set.size() > longest) {
                longest = set.size();
            }
        }
        return longest;
    }

    public static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int longest;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
                longest = 1;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        private void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
                rank[rootQ] += rank[rootP];
                longest = Math.max(longest, rank[rootQ]);
            } else {
                parent[rootQ] = rootP;
                rank[rootP] += rank[rootQ];
                longest = Math.max(longest, rank[rootP]);
            }
        }
    }

    public int longestConsecutive3(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        UnionFind uf = new UnionFind(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (numToIndex.get(num) != i) {
                continue;
            }

            if (numToIndex.containsKey(num - 1)) {
                int j = numToIndex.get(num - 1);
                uf.union(i, j);
            }
        }

        return uf.longest;
    }
}
