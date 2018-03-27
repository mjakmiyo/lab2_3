package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher{


    public SearchResult search(int i, int[] seq) {
        for (int j = 0; j < seq.length; j++)
            if (seq[j] == i)
            {
                return new SearchResultStub(true,j);
            }

        return new SearchResultStub( false,-1 );
    }
}
