package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher {

    private SearchResultStub searchResultStub;
    private int sequenceElementCount;
    private boolean[] results;

    public SequenceSearcherStub(boolean[] results) {
        this.results = results;
    }

    public SearchResult search(int key, int[] sequence) {
        searchResultStub = new SearchResultStub(results[sequenceElementCount++]);
        return searchResultStub;
    }
}
