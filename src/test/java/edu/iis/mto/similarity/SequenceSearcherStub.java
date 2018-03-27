package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;

public class SequenceSearcherStub implements SequenceSearcher{
    int searchInvokeCounter = 0;
    ArrayList<Integer> keyArgArray = new ArrayList<Integer>();
    int[] seqArgArray;

    boolean[] foundBooleanArray;

    SearchResultStub result = new SearchResultStub();

    public int getSearchInvokeCounter() {
        return searchInvokeCounter;
    }

    public int[] getKeyArgArray() {
        int[] ret = new int[keyArgArray.size()];
        for (int i=0; i < ret.length; i++) {
            ret[i] = keyArgArray.get(i).intValue();
        }
        return ret;
    }

    public int[] getSeqArgArray() {
        return seqArgArray;
    }

    public SearchResultStub getResult() {
        return result;
    }


    public void setFoundBooleanArray(boolean[] foundBooleanArray) {
        this.foundBooleanArray = foundBooleanArray;
    }

    public SearchResultStub search(int key, int[] seq) {
        // for mocking purposes
        keyArgArray.add(key);

        result.setFound(foundBooleanArray[searchInvokeCounter]);

        searchInvokeCounter++;
        this.seqArgArray = seq;

        return result;
    }
}
