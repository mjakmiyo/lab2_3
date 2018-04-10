package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher{
	private SearchResultStub searchResultStub;
    private int elementCount;
    private boolean[] resultsArray;

    public SequenceSearcherStub(boolean[] resultsArray){
        elementCount = 0;
        this.resultsArray = resultsArray;
    }
    public SearchResult search(int key, int[] seq){
        searchResultStub = new SearchResultStub(resultsArray[elementCount++]);
        return searchResultStub;
}
}
