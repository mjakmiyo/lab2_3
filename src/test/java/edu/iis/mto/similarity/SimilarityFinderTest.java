package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest {
    SimilarityFinder similarityFinder;

    @Before
    public void setUp() {
    }

    @Test
    public void twoEmptySequencesTest() throws Exception {
        boolean[] expectedResults = {};
        int[] seq1 = {};
        int[] seq2 = {};
        similarityFinder = new SimilarityFinder( new SequenceSearcherStub( expectedResults ) );
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( 1d ) );
    }

    @Test
    public void firstEmptySequenceTest() throws Exception {
        boolean[] expectedResults = {false, false, false};
        int[] seq1 = {};
        int[] seq2 = {2, 3, 4};
        double expectedResult = 0;
        similarityFinder = new SimilarityFinder( new SequenceSearcherStub( expectedResults ) );
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( 0d ) );
    }

    @Test
    public void secondEmptySequenceTest() throws Exception {
        boolean[] expectedResults = {false, false, false};
        int[] seq1 = {3, 4, 5};
        int[] seq2 = {};
        similarityFinder = new SimilarityFinder( new SequenceSearcherStub( expectedResults ) );
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( 0d ) );
    }

    @Test
    public void notEmptySequencesWithoutIntersectionTest() throws Exception {
        boolean[] expectedResults = {false, false, false, false, false, false};
        int[] seq1 = {3, 4, 5};
        int[] seq2 = {6, 7, 8};
        double expectedResult = 0;
        similarityFinder = new SimilarityFinder( new SequenceSearcherStub( expectedResults ) );
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( expectedResult ) );
    }

    @Test
    public void notEmptySequencesWithOneIntersectionTest() throws Exception {
        boolean[] expectedResults = {false, false, false, true, false, false};
        int[] seq1 = {3, 4, 5, 6};
        int[] seq2 = {6, 7, 8};
        similarityFinder = new SimilarityFinder( new SequenceSearcherStub( expectedResults ) );
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( 1 / 6d ) );
    }

    @Test
    public void notEmptySequencesWithManyIntersectionTest() throws Exception {
        boolean[] expectedResults = {false, true, true, true, false, false};
        int[] seq1 = {3, 4, 5, 6};
        int[] seq2 = {4, 5, 6, 7, 8};
        similarityFinder = new SimilarityFinder( new SequenceSearcherStub( expectedResults ) );
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( 3 / 6d ) );
    }

    @Test
    public void firstSequenceInSecondSequenceTest() throws Exception {
        boolean[] expectedResults = {true, true, true, true, false, false, false, false};
        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {1, 2, 3, 4, 5, 6, 7, 8};
        similarityFinder = new SimilarityFinder( new SequenceSearcherStub( expectedResults ) );
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( 4 / 8d ) );
    }

}