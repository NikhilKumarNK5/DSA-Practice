package LeetCode;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters?
How would you adapt your solution to such a case?
*/

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    // Approach 1: convert both the string to character Array and sort them and compare
    // TC => O(NLogN)
    // SC => O(N)
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        return Arrays.equals(charS, charT);
    }

    // Approach 2: Can use an array of 26 letters, that signifies the alphabet
    // TC => O(N);
    // SC => O(1);
    public boolean isAnagramArray(String s, String t) {

        if(s.length() != t.length())
            return false;

        int[] alphabet = new int[26];

        for(int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] != 0)
                return false;
        }
        return true;
    }

    // Approach 3: Using HashMap
    // This approach in case it contains any other unicode characters
    // TC => O(N)
    // SC => O(N)
    public boolean isAnagramHashMap(String s, String t) {
        if(s.length() != t.length())
            return false;

        HashMap<Character, Integer> frequency = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            // add for s
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);

            // subtract for t
            frequency.put(t.charAt(i), frequency.getOrDefault(t.charAt(i), 0) - 1);
        }

        for(int count: frequency.values()) {
            if(count != 0)
                return false;
        }
        return true;
    }

}
