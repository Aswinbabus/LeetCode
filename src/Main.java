

import com.sun.deploy.util.StringUtils;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int val = solution.singleNonDuplicate(new int[]{1,3,3});
        System.out.println(val);
    }
}
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        int left = 0,right = n-1;

        while( left <= right ) {

            int mid = left + (right - left) / 2;


            if(  !checkPrev(nums,mid) && !checkNext(nums,mid)  ) {
                return nums[mid];
            }
            else if( (mid%2 ==0 && checkPrev(nums,mid)) || (mid%2!=0 && !checkPrev(nums,mid)) ) {
                right = mid;
            }
            else {
                left = mid + 1;
            }



        }

        return nums[0];
    }

    private boolean checkNext(int[] nums, int mid) {

        if( mid+1 >= nums.length) {
            return false;
        }

        if( nums[mid+1] ==  nums[mid]) {
            return true;
        }

        return false;

    }

    private boolean checkPrev(int[] nums, int mid) {

        if( mid - 1 < 0) {
            return false;
        }

        if( nums[mid-1] == nums[mid]) {
            return true;
        }

        return false;
    }
}
