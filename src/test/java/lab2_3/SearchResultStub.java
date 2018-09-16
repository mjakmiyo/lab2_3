package lab2_3;

import edu.iis.mto.search.SearchResult;

public class SearchResultStub implements SearchResult {

    private boolean isFound;
    private int position;

    public SearchResultStub(boolean isFound, int position) {
        this.isFound = isFound;
        this.position = position;
    }

    public boolean isFound() {
        return this.isFound;
    }

    public int getPosition() {
        return this.position;
    }

}
