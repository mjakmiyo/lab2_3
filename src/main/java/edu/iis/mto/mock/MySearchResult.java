package edu.iis.mto.mock;

import edu.iis.mto.search.SearchResult;

public class MySearchResult implements SearchResult {
    
    private boolean isFound;
    
    public MySearchResult(boolean isFound) {
        this.isFound = isFound;
    }
    
    public boolean isFound() {
        return isFound;
    }

    public int getPosition() {
        return 0;
    }

}
