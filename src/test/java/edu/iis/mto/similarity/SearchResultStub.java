package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SearchResultStub implements SearchResult{
    boolean isFound = false;
    int position = -1;

    public void setFound(boolean state){
        isFound = state;
    }

    public void setPosition(int i){
        position = i;
    }

    public boolean isFound() {
        return isFound;
    }

    public int getPosition() {
        return position;
    }

}
