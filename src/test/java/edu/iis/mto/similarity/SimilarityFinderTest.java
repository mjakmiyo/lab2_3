package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {
    private SimilarityFinder similarityFinder;

    @Before
    public void setUp() {
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub();
        similarityFinder = new SimilarityFinder(sequenceSearcher);
    }

    @Test
    public void twoEmptySequencesShouldReturn1() {
        int[] sequence1 = {};
        int[] sequence2 = {};

        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1d));
    }

    @Test
    public void twoSameSequencesShouldReturn1() {
        int[] sequence1 = {1, 2, 3};
        int[] sequence2 = {1, 2, 3};

        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1d));
    }

    @Test
    public void onlyFirstSequenceEmptyShouldReturn0() {
        int[] sequence1 = {};
        int[] sequence2 = {1, 2, 3};

        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(0d));
    }

    @Test
    public void onlySecondSequenceEmptyShouldReturn0() {
        int[] sequence1 = {4, 5, 6};
        int[] sequence2 = {};

        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(0d));
    }

    @Test
    public void twoDifferentSequencesShouldReturn0() {
        int[] sequence1 = {1, 2, 3};
        int[] sequence2 = {4, 5, 6};

        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(0d));
    }

    @Test
    public void twoSequencesWithOneOverlapShouldReturnCorrectValue() {
        int[] sequence1 = {7, 8, 9};
        int[] sequence2 = {5, 6, 7};

        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1 / 5d));
    }

    @Test
    public void twoSequencesWithManyOverlapsShouldReturnCorrectValue() {
        int[] sequence1 = {1, 2, 3, 4, 5};
        int[] sequence2 = {2, 4, 6, 8};

        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(2 / 7d));
    }

    @Test
    public void twoSequencesWithOneCompletelyOverlappingShouldReturnCorrectValue() {
        int[] sequence1 = {1, 2, 3, 4, 5};
        int[] sequence2 = {1, 2, 3};

        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(3 / 5d));
    }
}