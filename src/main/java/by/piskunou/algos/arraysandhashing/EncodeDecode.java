package by.piskunou.algos.arraysandhashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    private static final short DELIMETER = 257;
    private static final byte ZERO = 0;

    public String encode1(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        if (strs.isEmpty()) {
            return null;
        }

        for (int i = 0; i < strs.size() - 1; i++) {
            String str = strs.get(i);
            for (int j = 0; j < strs.get(i).length(); j++) {
                short s = (short) str.charAt(j);
                if (s < 10) {
                    encoded.append(ZERO).append(ZERO).append(s);
                } else if (s < 100) {
                    encoded.append(ZERO).append(s);
                } else {
                    encoded.append(s);
                }
            }
            encoded.append(DELIMETER);
        }
        String str = strs.get(strs.size() - 1);
        for (int j = 0; j < str.length(); j++) {
            short s = (short) str.charAt(j);
            if (s < 10) {
                encoded.append(ZERO).append(ZERO).append(s);
            } else if (s < 100) {
                encoded.append(ZERO).append(s);
            } else {
                encoded.append(s);
            }
        }
        return encoded.toString();
    }

    public List<String> decode1(String str) {
        List<String> decoded = new ArrayList<>();

        if (str == null) {
            return decoded;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i += 3) {
            short asciiNumber = Short.parseShort(str.substring(i, i+3));
            if (asciiNumber != DELIMETER) {
                char ch = (char) asciiNumber;
                sb.append(ch);
            } else {
                decoded.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        decoded.add(sb.toString());
        return decoded;
    }

    public String encode2(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode2(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }

    public String encode3(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs) {
            sizes.add(str.length());
        }
        for (int size : sizes) {
            res.append(size).append(',');
        }
        res.append('#');
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode3(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for (int sz : sizes) {
            res.add(str.substring(i, i + sz));
            i += sz;
        }
        return res;
    }
}
