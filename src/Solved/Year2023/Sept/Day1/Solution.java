package Solved.Year2023.Sept.Day1;

class Solution {
public int[] countBits(int n) {

    long lastPower = 0,nextPower = 1;

    int[] bits = new int[n+1];

    // default value
    bits[0] = 0;

    for(int i = 1;i<=n;i++) {

        if(i == nextPower) {
            bits[i] = 1;
            lastPower = nextPower;
            nextPower = nextPower*2;
        }
        else {
           int index = (int) (i - lastPower);
           bits[i] = 1 + bits[index];
        }

    }

    return bits;
}
}
