package edu.iis.mto.mock;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MySequenceSearcher implements SequenceSearcher {

    private boolean[] expectedResults;
    private int calls = 0;
    
    public MySequenceSearcher(boolean[] expectedResults) {
        this.expectedResults = expectedResults;
    }
    
    public SearchResult search(int key, int[] seq) {
        MySearchResult result = new MySearchResult(expectedResults[calls]);
        calls++;
        return result;
    }

}
