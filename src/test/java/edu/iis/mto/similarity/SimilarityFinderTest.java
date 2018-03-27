package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest {
    SimilarityFinder similarityFinder;

    @Before
    public void setUp() {
        similarityFinder = new SimilarityFinder( new MySequenceSearcher() );
    }

    @Test
    public void twoEmptySequencesTest() throws Exception {
        int[] seq1 = {};
        int[] seq2 = {};
        double intersection = 1;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( intersection ) );
    }

}