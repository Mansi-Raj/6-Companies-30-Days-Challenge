package Amazon;

import java.util.*;

class MaximumSumOfDistinctSubarray {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long max = 0;
        Map<Integer, Integer> count = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
            if (i >= k) {
                count.put(nums[i - k], count.get(nums[i - k]) - 1);
                if (count.get(nums[i - k]) == 0) {
                    count.remove(nums[i - k]);
                }
                sum -= nums[i - k];
            }

            if (i >= k - 1 && count.size() == k) {
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}// time complexity o(n)
/*
 * class Solution {
 * public long maximumSubarraySum(int[] nums, int k) {
 * int n=nums.length;
 * long max=0;
 * int i=0;
 * while(i<=n-k){
 * long sum=0;
 * Map<Integer, Integer>count=new HashMap<>();
 * for(int j=i;j<i+k;j++){
 * count.put(nums[j], count.getOrDefault(nums[j],0)+1);
 * if(count.get(nums[j])>1){
 * sum=0;
 * break;
 * }
 * sum+=nums[j];
 * }
 * if(max<sum){
 * max=sum;
 * }
 * i++;
 * }
 * return max;
 * }
 * } time complexity O(n*k)
 */