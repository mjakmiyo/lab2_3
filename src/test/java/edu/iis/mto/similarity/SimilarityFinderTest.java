package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {
    private SimilarityFinder similarityFinder;
    private SequenceSearcher sequenceSearcher;

    @Before
    public void setUp() {
        sequenceSearcher = new SequenceSearcherStub();
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

}