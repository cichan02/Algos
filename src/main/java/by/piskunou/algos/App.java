package by.piskunou.algos;

public class App {
    public static void main(String[] args) {
        String[] strs = new String[]{"bdddddddddd","bbbbbbbbbbc"};
        GroupAnagrams app = new GroupAnagrams();
        var ans = app.groupAnagrams3(strs);
        System.out.println(ans);
    }
}