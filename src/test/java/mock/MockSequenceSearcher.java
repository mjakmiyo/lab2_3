package mock;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
public class MockSequenceSearcher implements SequenceSearcher {

    private int elemIndex = 0;
    private boolean[] expectedElements;

    public MockSequenceSearcher(boolean[] expectedElements) {
        this.elemIndex = 0;
        this.expectedElements = expectedElements;
    }

    public SearchResult search(int i, int[] seq) {

        return new StubSearchResult( expectedElements[elemIndex++] );
    }
}