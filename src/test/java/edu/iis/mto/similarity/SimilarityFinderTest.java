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

    @Test
    public void testingTwoNonEmptySequencesShouldReturnCorrectValue() {
        boolean expectedResults[] = {true, false};
        SequenceSearcher sequenceSearcher = new MockSimilarityFinder(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int seq1[] = {4, 5};
        int seq2[] = {2, 4, 9};
        double expectedResult = 0.25;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }

    @Test
    public void testingTwoTheSameSequencesShouldReturnOne() {
        boolean expectedResults[] = {true, true, true, true};
        SequenceSearcher sequenceSearcher = new MockSimilarityFinder(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int seq1[] = {2, 5, 9, 12};
        int seq2[] = {2, 5, 9, 12};
        double expectedResult = 1;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }

    @Test
    public void testingTwoSequencesWithTheSameNumbersShouldReturnOne() {
        boolean expectedResults[] = {true, true, true, true};
        SequenceSearcher sequenceSearcher = new MockSimilarityFinder(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int seq1[] = {34, 8, 5, 12};
        int seq2[] = {5, 12, 34, 8};
        double expectedResult = 1;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }
}
