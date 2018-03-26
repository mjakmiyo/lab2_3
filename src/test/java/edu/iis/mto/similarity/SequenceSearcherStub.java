package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;

import java.util.ArrayList;

public class SequenceSearcherStub implements SequenceSearcher{
    int searchInvokeCounter = 0;
    ArrayList<Integer> keyArgArray = new ArrayList<Integer>();
    int[] seqArgArray;

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

    public SearchResultStub search(int key, int[] seq) {
        // for mocking purposes
        keyArgArray.add(key);
        searchInvokeCounter++;
        this.seqArgArray = seq;

        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResultStub result = new SearchResultStub();

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center);
                result.setFound(true);
                break;
            } else {
                if (seq[center] < key)
                    start = center + 1;
                else
                    end = center - 1;
            }

        }
        return result;
    }
}
