package Leetcode;
/**
 * IsPalindrome
 */
public class IsPalindrome {
/*
    problem 125 -- https://leetcode.com/problems/valid-palindrome/

    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    Note: For the purpose of this problem, we define empty string as valid palindrome.
*/
    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;

        char[] charArray = s.toLowerCase().toCharArray();
        int begin = 0;
        int end = s.length() - 1;

        while(begin < end) {
            while(begin < end && !isAlphaNumeric(charArray[begin])) begin++;
            while(begin < end && !isAlphaNumeric(charArray[end])) end--;
            if(charArray[begin] != charArray[end]) return false;
            begin++;
            end--;
        }

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        if(c - 'a' >= 0 && c - 'a' < 26) return true;
        if(c - '0' >= 0 && c - '0' <= 9) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // should return true
        System.out.println(isPalindrome("race car")); // should return true
        System.out.println(isPalindrome("")); // should return true
        System.out.println(isPalindrome("aab")); // should return false
        System.out.println(isPalindrome("abc")); // should return false
        System.out.println(isPalindrome("asdasjdlajsd")); // should return false
        System.out.println(isPalindrome("0P")); // should return false
        System.out.println(isPalindrome(",.")); // should return true
        System.out.println(isPalindrome("Marge, let's \"[went].\" I await {news} telegram.")); // should return true
    }
}