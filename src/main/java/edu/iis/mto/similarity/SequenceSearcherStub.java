package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher {
    public SearchResult search(int needle, int[] hay) {
        for (int i : hay) {
            if (i == needle) return new SearchResultStub(true, i);
        }
        return new SearchResultStub(false, -1);
    }
}
