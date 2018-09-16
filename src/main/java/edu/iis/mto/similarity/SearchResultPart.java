package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SearchResultPart implements SearchResult {

	private final boolean isFound;
	private final int position;

	public SearchResultPart(boolean isFound, int position) {
		this.isFound = isFound;
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public boolean isFound() {
		return isFound;
	}
}