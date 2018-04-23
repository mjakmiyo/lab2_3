package edu.iis.mto.mock;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MockSimilarityFinder implements SequenceSearcher {

    private boolean[] expectedResults;
    private int calls = 0;

    public MockSimilarityFinder(boolean[] expectedResults) {
        this.expectedResults = expectedResults;
    }

    public SearchResult search(int key, int[] seq) {
        MockSearchResult result = new MockSearchResult(expectedResults[calls]);
        calls++;
        return result;
    }

}
