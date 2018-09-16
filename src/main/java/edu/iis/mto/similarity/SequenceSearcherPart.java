package edu.iis.mto.similarity;

import javax.naming.directory.SearchResult;

import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherPart implements SequenceSearcher {
	private int currentElement;
	private boolean[] resultsArray;

	public SearchResult search(int needle, int[] hay) {
		final SearchResultPart searchResultPart = new SearchResultPart(resultsArray[currentElement], currentElement);
		currentElement++;
		return searchResultPart;
	}

	public void setResultsArray(boolean[] resultsArray) {
		this.resultsArray = resultsArray;
		currentElement = 0;
	}
}