
import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(int[] nums, int index,
            List<Integer> current,
            List<List<Integer>> ans) {

        // Current subset ko answer mein add karo
        ans.add(new ArrayList<>(current));

        // Aage ke elements choose karo
        for (int i = index; i < nums.length; i++) {

            // Element choose
            current.add(nums[i]);

            // Next element
            backtrack(nums, i + 1, current, ans);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}
