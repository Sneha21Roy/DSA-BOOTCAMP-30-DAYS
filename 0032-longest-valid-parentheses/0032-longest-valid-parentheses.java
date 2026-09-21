class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        boolean[] isval = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (st.isEmpty()) continue;
                isval[i] = true;
                isval[st.pop()] = true;
            }
        }

        int ans = 0;
        int i = 0;
        while (i < n) {
            if (isval[i]) {
                int j = i;
                while (j < n && isval[j]) {
                    j++;
                }
                ans = Math.max(ans, j - i);
                i = j;
            }
            i++;
        }

        return ans;
    }
}