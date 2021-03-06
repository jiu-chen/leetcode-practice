package org.doublePointer;

import java.util.Arrays;
import java.util.HashSet;

// 反转字符串中的元音字符
// Given s = "leetcode", return "leotcede".
public class ReverseVowelsOfString {
    public final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U', 'U')  // 即使多谢一个'U', hashset也会做去重操作
    );

    public static void main(String[] args) {
        String str = "leetcode";
        String rstr = reverseVowelsOfString(str);
        System.out.println(str);  // leetcode
        System.out.println(rstr); // leotcede

        System.out.println("---------------------------");
        System.out.println(vowels); // [a, A, e, u, E, U, i, I, o, O]
    }

    // a o e i u
    private static String reverseVowelsOfString(String str) {
        int l = 0, r = str.length() - 1;
        char[] result = new char[str.length()];
        while (l <= r) {  // "=" 条件不能丢，否则 leot ede
            char cl = str.charAt(l);
            char cr = str.charAt(r);
            if (!vowels.contains(cl)) {
                result[l++] = cl;
            } else if (!vowels.contains(cr)) {
                result[r--] = cr;
            } else {
                result[l++] = cr;
                result[r--] = cl;
            }
        }
        return new String(result);
    }


}
