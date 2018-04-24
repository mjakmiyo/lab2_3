package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SearchResultStub implements SearchResult {
    private boolean isFound;
    private int position;

    public SearchResultStub(boolean isFound, int position) {
        this.isFound = isFound;
        this.position = position;
    }

    public SearchResultStub(boolean isFound) {
        this.isFound = isFound;
    }

    public SearchResultStub() {
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
