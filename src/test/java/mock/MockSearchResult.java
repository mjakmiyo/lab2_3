package mock;

import edu.iis.mto.search.SearchResult;

public class MockSearchResult implements SearchResult {
    private final static int NOT_FOUND=-1;
    private int position;

    public MockSearchResult(int position){
        this.position=position;
    }

    public boolean isFound() {
        return position != NOT_FOUND;
    }

    public int getPosition() {
        return position;
    }
}
