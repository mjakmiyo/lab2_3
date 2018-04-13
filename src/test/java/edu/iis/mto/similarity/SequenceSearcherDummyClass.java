package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDummyClass implements SequenceSearcher {

    private boolean[] answerArray;
    private static int position;

    public SearchResultDummyClass search(int var1, int[] var2)
    {
        SearchResultDummyClass dummyClass = new SearchResultDummyClass();
        dummyClass.setFound(answerArray[position]);
        position++;
        return dummyClass;
    }

    public boolean[] getAnswerArray() {
        return answerArray;
    }

    void setAnswerArray(boolean[] answerArray) {
        this.answerArray = answerArray;
        position = 0;
    }
}
