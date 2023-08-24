package Solved.Year2023.Day24;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {


        List<String> justifiedPara = new ArrayList<>();

        int lineLength = 0,addedIndex = -1;

        int currIndex = 0,wordsCount = 0;


        while(currIndex < words.length) {

            if(lineLength + wordsCount + words[currIndex].length() > maxWidth) {

                justifiedPara.add(addLineWithFullJustify(words, addedIndex + 1, currIndex - 1, lineLength, maxWidth));

                addedIndex = currIndex - 1;
                lineLength = 0;
                wordsCount = 0;

            }


            lineLength += words[currIndex].length();
            currIndex++;
            wordsCount++;


        }

        justifiedPara.add(addLineWithLeftJustify(words, addedIndex + 1, currIndex - 1, maxWidth));

        return justifiedPara;

    }

    private String addLineWithLeftJustify(String[] words,int start, int end,int maxWidth) {

        StringBuilder builder = new StringBuilder();

        int currLength = 0;

        for(int i = start;i<=end;i++) {
            builder.append(words[i]);

            currLength += words[i].length();

            if(currLength < maxWidth) {
                builder.append(" ");
                currLength++;
            }
        }

        builder.append(spaceString(maxWidth - currLength));


        return builder.toString();

    }

    private String addLineWithFullJustify(String[] words,int start, int end, int lineLength,int maxWidth) {

        StringBuilder builder = new StringBuilder();

        int totalWords = end - start + 1;

        if(totalWords == 1) {
            builder.append(words[start]);
            builder.append(spaceString(maxWidth - lineLength));
            return builder.toString();
        }

        int dividerWidth = (maxWidth - lineLength) / (totalWords - 1);

        int rem = (maxWidth - lineLength) % (totalWords - 1);

        for (int i = start; i < end ; i++) {

            builder.append(words[i]);

            builder.append(spaceString(dividerWidth + (rem > 0 ? 1 : 0)));

            rem--;

        }

        builder.append(words[end]);


        return builder.toString();
    }

    private String spaceString(int length) {

        StringBuilder spaceString = new StringBuilder();

        for(int j = 0;j<length ; j++) {
            spaceString.append(" ");
        }

        return spaceString.toString();


    }

}
