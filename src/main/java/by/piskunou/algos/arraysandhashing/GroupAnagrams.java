package by.piskunou.algos.arraysandhashing;

import java.util.*;

public class GroupAnagrams implements Solution {
     private static final byte OFFSET = 'a'; //97
     private static final byte AMOUNT = 26;
     private static final char DELIMETER = '#';

    private boolean isAnagrams(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - OFFSET]++;
        }

        for (int j = 0; j < t.length(); j++) {
            int k = t.charAt(j) - OFFSET;
            if (letters[k] == 0) {
                return false;
            }
            letters[k]--;
        }

        return true;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = HashMap.newHashMap(strs.length);

        for (String str : strs) {
            boolean isAdded = false;
            for (Map.Entry<String, List<String>> entry: map.entrySet()) {
                if (isAnagrams(str, entry.getKey())) {
                    entry.getValue().add(str);
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(str, list);
            }
        }

        return map.values()
                .stream()
                .map(List::copyOf)
                .toList();
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = HashMap.newHashMap(strs.length);
        for (String str : strs) {
            byte[] letters = new byte[26];
            for (int i = 0; i < str.length(); i++) {
                letters[str.charAt(i) - OFFSET]++;
            }
            map.computeIfAbsent(Arrays.toString(letters), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = HashMap.newHashMap(strs.length);
        for (String str : strs) {
            byte[] letters = new byte[AMOUNT];
            for (short i = 0; i < str.length(); i++) {
                letters[str.charAt(i) - OFFSET]++;
            }

            StringBuilder sb = new StringBuilder(AMOUNT * 2);
            for (byte f: letters) {
                sb.append(f);
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
