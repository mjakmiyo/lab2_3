package lab2_3;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {

    @Test
    public void sequencesOfSizeZeroShouldReturnOne() {
        boolean[] expectedResults = {};
        int[] seq1 = {};
        int[] seq2 = {};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(expectedResults, 0);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), equalTo(1.0d));
    }
}
