package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SearchResultDummyClass implements SearchResult {

    private boolean isFound = false;

    private int position = -1;

    public boolean isFound() {
        return isFound;
    }

    void setFound(boolean found) {
        isFound = found;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
