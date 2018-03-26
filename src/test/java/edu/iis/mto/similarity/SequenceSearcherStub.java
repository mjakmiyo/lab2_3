package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher{
    public SearchResultStub search(int key, int[] seq) {
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
