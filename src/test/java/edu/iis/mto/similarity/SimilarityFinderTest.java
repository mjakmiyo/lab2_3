package edu.iis.mto.similarity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.mock.MockSimilarityFinder;
import edu.iis.mto.search.SequenceSearcher;

public class SimilarityFinderTest {

    @Test
    public void testingTwoEmptySequencesShouldReturnOne() {
        boolean expectedResults[] = {false};
        SequenceSearcher sequenceSearcher = new MockSimilarityFinder(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int seq1[] = {};
        int seq2[] = {};
        double expectedResult = 1.0;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }

    @Test
    public void testingOneEmptySequenceShouldReturnZero() {
        boolean expectedResults[] = {false, false};
        SequenceSearcher sequenceSearcher = new MockSimilarityFinder(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int seq1[] = {1, 2};
        int seq2[] = {};
        double expectedResult = 0;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }
}
