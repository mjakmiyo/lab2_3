import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Before;
import org.junit.Test;
import stubs.SearchResultStub;
import stubs.SequenceSearcherStub;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest {
    private SimilarityFinder similarityFinder;

    @Test
    public void calculateJackardSimilarityShouldReturnOneWhenEmptySequences(){
        boolean[] expectedResults = {};
        int[] seq1 = {};
        int[] seq2 = {};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(expectedResults);
        similarityFinder = new SimilarityFinder(sequenceSearcher);
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(result, is(1.0));
    }

    @Test
    public void calculateJackardSimilarityShouldReturnCorrectValueOnNotEmptySequences(){
        boolean[] expectedResults = {false, false, false, true, true, true};
        int[] seq1 = {1,2,3,4,5,6};
        int[] seq2 = {4,5,6,7,8,9};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(expectedResults);
        similarityFinder = new SimilarityFinder(sequenceSearcher);
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(result, is(3.0/9.0));
    }
}
