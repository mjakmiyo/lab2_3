package mock;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MockSequenceSearcher implements SequenceSearcher {

    public SearchResult search(int i, int[] ints) {
        for (int pos = 0; pos < ints.length; pos++) {
            if (i == ints[pos]) {
                return new MockSearchResult(pos);
            }
        }
        return new MockSearchResult(-1);
    }
}