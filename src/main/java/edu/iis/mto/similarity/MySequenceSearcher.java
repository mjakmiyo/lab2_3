package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class MySequenceSearcher implements SequenceSearcher{


    public SearchResult search(int i, int[] seq) {
        for (int j = 0; j < seq.length; j++)
            if (seq[j] == i)
            {
                return new MySearchResult(true,j);
            }

        return new MySearchResult( false,-1 );
    }
}
