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

    @Test
    public void differentSequencesShouldReturnZero() {
        boolean[] expectedResults = {false, false, false, false, false, false, false};
        int[] seq1 = {6, 3, 6, 3};
        int[] seq2 = {1, 2, 4, 5, 7, 8, 9};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(expectedResults, 0);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), equalTo(0.0d));
    }

    @Test
    public void equalSequencesShouldReturnOne() {
        boolean[] expectedResults = {true, true, true, true, true, true, true};
        int[] seq1 = {1, 2, 4, 5, 7, 8, 9};
        int[] seq2 = {1, 2, 4, 5, 7, 8, 9};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(expectedResults, 0);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), equalTo(1.0d));
    }
}
