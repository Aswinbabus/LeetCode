import java.util.Collections;

class Solution {
    public int minDifference(int[] nums) {

        if(nums.length <= 4) {
            return 0;
        }

        else {

            int len = nums.length;

            sortFirstNElements(nums,3);
            sortLastNElements(nums,3);
            return Math.min(nums[len-1] - nums[3], nums[len - 4] - nums[0]);

        }

    }

    private void sortLastNElements(int[] nums,int n) {

        int currIndex = nums.length - 1;

        for(int i = 0;i<n;i++) {

            int largestIndex = currIndex;

            for(int j = 0;j<currIndex;j++) {
                if(nums[j] > nums[largestIndex]){
                    largestIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[largestIndex];
            nums[largestIndex] = temp;

        }

    }

    private void sortFirstNElements(int[] nums, int n) {

        for(int i = 0;i<n;i++) {

            int smallestIndex = i;

            for(int j = i + 1;j<n;j++) {
                if(nums[j] < nums[smallestIndex]){
                    smallestIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[smallestIndex];
            nums[smallestIndex] = temp;

        }

    }
}