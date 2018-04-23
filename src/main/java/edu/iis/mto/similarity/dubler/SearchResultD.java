package edu.iis.mto.similarity.dubler;

import edu.iis.mto.search.SearchResult;

public class SearchResultD implements SearchResult {

    private int position;
    private boolean found;
    public SearchResultD(boolean found) {
        this.found=found;
    }
    public boolean isFound() {
        return found;
    }

    public int getPosition() {
        return position;
        
    }

}
