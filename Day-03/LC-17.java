
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] keypad = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", ans, keypad);

        return ans;
    }

    public void backtrack(
            String digits,
            int index,
            String current,
            List<String> ans,
            String[] keypad
    ) {

        // Base case
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';

        String letters = keypad[digit];

        for (char ch : letters.toCharArray()) {

            backtrack(
                    digits,
                    index + 1,
                    current + ch,
                    ans,
                    keypad
            );
        }
    }
}
