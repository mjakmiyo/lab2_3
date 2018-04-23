package edu.iis.mto.similarity.dubler;

import edu.iis.mto.search.SequenceSearcher;


public class SequenceSearcherD implements SequenceSearcher {
    private boolean[]expectedResult;
    private int call;
    public SequenceSearcherD(boolean[] result) {
        expectedResult=result;
        call=0;
    }

    public SearchResultD search(int key, int[] seq) {
        call++;
        return new SearchResultD(expectedResult[call-1]);
        
    }
    
}
