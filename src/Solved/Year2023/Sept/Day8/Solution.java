package Solved.Year2023.Sept.Day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>(Arrays.asList(1));

        ans.add(firstRow);

        if(numRows == 1){
            return ans;
        }


        for(int i = 1;i<numRows;i++) {

            List<Integer> nRow = new ArrayList<>();

            nRow.add(1);

            for(int j = 2;j<=i;j++) {
                nRow.add(ans.get(i-1).get(j-2) + ans.get(i-1).get(j-1));
            }

            nRow.add(1);

            ans.add(nRow);


        }

        return ans;

    }
}