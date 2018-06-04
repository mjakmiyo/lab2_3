package mock;

import edu.iis.mto.search.SearchResult;

public class StubSearchResult implements SearchResult {
    private int position;
    private boolean isFound;
    public StubSearchResult(boolean isFound, int position) {
        this.isFound = isFound;
        this.position = position;
    }

    public StubSearchResult(boolean isFound) {
        this.isFound = isFound;
    }

    public StubSearchResult() {
        this.isFound = false;
        this.position = -1;
    }

    public boolean isFound() {
        return isFound;
    }

    public int getPosition() {
        return position;
    }
}
