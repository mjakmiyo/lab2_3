package mock;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import org.apache.commons.lang.ArrayUtils;
public class MockSequenceSearcher implements SequenceSearcher {

    public SearchResult search(int i, int[] ints) {
        if (ArrayUtils.contains(ints, i)){
            int pos = ArrayUtils.indexOf(ints, i);
            return new StubSearchResult(pos);
        }
        return new StubSearchResult(-1);
    }
}