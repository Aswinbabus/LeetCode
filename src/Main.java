import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
        System.out.println(solution.shipWithinDays(new int[]{3,2,2,4,1,4},3));

    }
}
class Solution {
    public int shipWithinDays(int[] weights, int maxDays) {

        int minWeight = weights[0];
        int maxWeight = Arrays.stream(weights).sum();
        int minLoad = Integer.MAX_VALUE;

        // Binary search minWeight to maxWeight to find the optimal load for the ship

        int left = minWeight,right = maxWeight,mid;
        while(left <= right) {

            mid = left + (right - left) / 2;

            int days = computeDaysToShip(weights,mid);


            if(days == -1 || days > maxDays) {
                left = mid + 1;
            }
            else {

                minLoad = Math.min(minLoad,mid);
                right = mid - 1;

            }

        }

        return minLoad;

    }

    private int computeDaysToShip(int[] weights,int capacity) {

        int currLoad = 0,days = 0;

        for(int i = 0;i<weights.length;i++) {

            if(currLoad == 0 && weights[i] > capacity) {
                return -1;
            }

            currLoad += weights[i];

            if(currLoad >= capacity) {
                currLoad -= capacity;
                days++;
            }

        }

        if(currLoad != 0) {
            days++;
        }

        return days;

    }
}