import java.util.HashSet;

/**
 * @author lcl
 * 无重复最长子串
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (1 == s.length()) {
            return 1;
        }

        int maxLength = 0;
        int tmpLength = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet();
        for (; i < s.length() && j < s.length();) {
            if (! set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j ++;
                tmpLength ++;
                if (tmpLength > maxLength) {
                    maxLength = tmpLength;
                }
            } else {
                set.remove(s.charAt(i));
                i ++;
                tmpLength --;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
