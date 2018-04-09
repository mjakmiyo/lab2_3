package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SearchResultStub implements SearchResult {
    public boolean isFound() {
        return false;
    }

    public int getPosition() {
        return 0;
    }
}
