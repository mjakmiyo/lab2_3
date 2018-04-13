package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher {
    private final boolean[] expectedResults;
    private int invokeCounter;

    public SequenceSearcherStub(boolean[] expectedResults) {
        this.expectedResults = expectedResults;
    }

    public SearchResult search(int key, int[] seq) {
        SearchResult searchResult = new SearchResultStub(expectedResults[invokeCounter], invokeCounter);
        invokeCounter++;
        return searchResult;
    }
}
