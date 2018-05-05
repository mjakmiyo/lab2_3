package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.MockSearchResult;;

public class MockSequenceSearcher implements SequenceSearcher {
    private final boolean[] expectedResults;
    private int invokeCounter;

    public MockSequenceSearcher (boolean[] expectedResults) {
        this.expectedResults = expectedResults;
    }

    public SearchResult search(int key, int[] seq) {
        SearchResult searchResult = new MockSearchResult(expectedResults[invokeCounter], invokeCounter);
        invokeCounter++;
        return searchResult;
    }

    public int getInvokeCounter() {
        return invokeCounter;
    }
}

