package Amazon;

public class LongestMountain {
    public int longestMountain(int[] arr) {
        int maxLength = 0;
        int n = arr.length;
        int i = 1;

        while (i < n - 1) {
            int len = 1;
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i;
                while (left > 0 && arr[left] > arr[left - 1]) {
                    len++;
                    left--;
                }
                while (i < n - 1 && arr[i] > arr[i + 1]) {
                    len++;
                    i++;
                }
                maxLength = Math.max(len, maxLength);
            } else {
                i++;
            }
        }
        return maxLength;
    }
}
