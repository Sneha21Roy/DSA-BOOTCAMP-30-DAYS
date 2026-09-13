class Solution {
    public boolean isPalindrome(int x) {

        // Step 1: Negative numbers are not palindrome
        if (x < 0) {
            return false;
        }

        int temp = x;      // store original number
        int rev = 0;       // reversed number

        // Step 2: Reverse the number
        while (x > 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }

        // Step 3: Compare
        return temp == rev;
    }
}
