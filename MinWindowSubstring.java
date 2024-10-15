import java.util.HashMap;

public class MinWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        
        HashMap<Character, Integer> windowCount = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        int start = 0, minLength = Integer.MAX_VALUE;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            if (tCount.containsKey(c)) {
                windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
                if (windowCount.get(c).equals(tCount.get(c))) {
                    valid++;
                }
            }
            
            while (valid == tCount.size()) {
                if (right - left < minLength) {
                    start = left;
                    minLength = right - left;
                }
                
                char d = s.charAt(left);
                left++;
                
                if (tCount.containsKey(d)) {
                    if (windowCount.get(d).equals(tCount.get(d))) {
                        valid--;
                    }
                    windowCount.put(d, windowCount.get(d) - 1);
                }
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    public static void main(String[] args) {
        String s = "this is a test string";
        String t = "tist";
        String result = minWindow(s, t);
        System.out.println(result);
    }
}
