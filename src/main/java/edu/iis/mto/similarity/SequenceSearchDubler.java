package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearchDubler implements SequenceSearcher {
    private boolean[]expectedResult;
    private int call;
    public SequenceSearchDubler(boolean[] result) {
        expectedResult=result;
        call=0;
    }

    public SearchResultDubler search(int key, int[] seq) {
        call++;
        return new SearchResultDubler(expectedResult[call-1]);
        
    }
    
}
