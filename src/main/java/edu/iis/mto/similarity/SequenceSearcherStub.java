package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher {
    private boolean[] resultsArray;
    private int currentElement;

    public void setResultsArray(boolean[] resultsArray) {
        this.resultsArray = resultsArray;
        currentElement = 0;
    }

    public SearchResult search(int needle, int[] hay) {
        SearchResultStub searchResultStub =  new SearchResultStub(resultsArray[currentElement], currentElement);
        currentElement++;
        return searchResultStub;
    }
}
