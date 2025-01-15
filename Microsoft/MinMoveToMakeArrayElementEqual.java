package Microsoft;

import java.util.Arrays;

public class MinMoveToMakeArrayElementEqual {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int median = 0;
        if (n % 2 != 0) {
            median = nums[n / 2];
        } else {
            median = (int) ((nums[(n - 1) / 2] + nums[n / 2]) / 2.0);
        }
        int minMove = 0;
        for (int num : nums) {
            minMove += Math.abs(median - num);
        }
        return minMove;
    }
}
