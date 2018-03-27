package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest {
    SimilarityFinder similarityFinder;

    @Before
    public void setUp() {
        similarityFinder = new SimilarityFinder( new SequenceSearcherStub() );
    }

    @Test
    public void twoEmptySequencesTest() throws Exception {
        int[] seq1 = {};
        int[] seq2 = {};
        double intersection = 1;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( intersection ) );
    }

    @Test
    public void firstEmptySequenceTest() throws Exception {
        int[] seq1 = {};
        int[] seq2 = {2, 3, 4};
        double intersection = 0;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( intersection ) );
    }

    @Test
    public void secondEmptySequenceTest() throws Exception {
        int[] seq1 = {3, 4, 5};
        int[] seq2 = {};
        double intersection = 0;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( intersection ) );
    }

    @Test
    public void notEmptySequencesWithoutIntersectionTest() throws Exception {
        int[] seq1 = {3, 4, 5};
        int[] seq2 = {6, 7, 8};
        double intersection = 0;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( intersection ) );
    }

    @Test
    public void notEmptySequencesWithOneIntersectionTest() throws Exception {
        int[] seq1 = {3, 4, 5, 6};
        int[] seq2 = {6, 7, 8};
        double intersection = 1;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( intersection / (seq1.length + seq2.length - intersection) ) );
    }

    @Test
    public void notEmptySequencesWithManyIntersectionTest() throws Exception {
        int[] seq1 = {3, 4, 5, 6};
        int[] seq2 = {4, 5, 6, 7, 8};
        double intersection = 3;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( intersection / (seq1.length + seq2.length - intersection) ) );
    }

    @Test
    public void firstSequenceInSecondSequenceTest() throws Exception {
        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {1, 2, 3, 4, 5, 6, 7, 8};
        double intersection = 4;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( intersection / (seq1.length + seq2.length - intersection) ) );
    }

}