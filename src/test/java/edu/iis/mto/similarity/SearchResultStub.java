package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SearchResultStub implements SearchResult{

    private boolean isFound;
    private int position;

    public SearchResultStub(boolean isFound) {
        this.isFound = isFound;
    }

    public boolean isFound() {
        return isFound;
    }

    public int getPosition() {
        return position;
    }
}
