package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher{

    int elemIndex = 0;
    boolean[] expectedResults;

    public SequenceSearcherStub(boolean[] expectedResults) {
        this.elemIndex = 0;
        this.expectedResults = expectedResults;
    }

    public SearchResult search(int i, int[] seq) {

        return new SearchResultStub( expectedResults[elemIndex++] );
    }
}
