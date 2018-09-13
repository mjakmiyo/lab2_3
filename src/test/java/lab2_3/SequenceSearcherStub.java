package lab2_3;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher {

    private boolean[] expectedResults;
    private int position;

    public SequenceSearcherStub(boolean[] expectedResults, int position) {
        this.expectedResults = expectedResults;
        this.position = position;
    }

    public SearchResult search(int key, int[] seq) {
        SearchResult result = new SearchResultStub(expectedResults[position], position);
        position++;
        return result;
    }

}
