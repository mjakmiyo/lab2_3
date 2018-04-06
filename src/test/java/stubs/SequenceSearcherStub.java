package stubs;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher {

    private SearchResultStub searchResultStub;
    private int elemToCheck;
    private boolean[] expectedResults;

    public SequenceSearcherStub(boolean[] expectedResults){
        elemToCheck = 0;
        this.expectedResults = expectedResults;
    }
    public SearchResult search(int key, int[] seq){
        searchResultStub = new SearchResultStub(expectedResults[elemToCheck++]);
        return searchResultStub;
    }
}
