package kit.hash;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 prob = new Solution1();
        int[] nums = {3, 1, 2, 3};

        System.out.println(prob.solution(nums));
    }

    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        if (set.size() > (nums.length / 2)) {
            return nums.length / 2;
        }

        return set.size();
    }
}