package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class MySearchResult implements SearchResult {
    private boolean isFound;
    private int position;

    public MySearchResult(boolean isFound, int position) {
        this.isFound = isFound;
        this.position = position;
    }

    public MySearchResult() {
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
