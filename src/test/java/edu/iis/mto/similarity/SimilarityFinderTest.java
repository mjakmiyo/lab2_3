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
        double expectedResult = 1;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( expectedResult ) );
    }

    @Test
    public void firstEmptySequenceTest() throws Exception {
        int[] seq1 = {};
        int[] seq2 = {2, 3, 4};
        double expectedResult = 0;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( expectedResult ) );
    }

    @Test
    public void secondEmptySequenceTest() throws Exception {
        int[] seq1 = {3, 4, 5};
        int[] seq2 = {};
        double expectedResult = 0;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( expectedResult ) );
    }

    @Test
    public void notEmptySequencesWithoutIntersectionTest() throws Exception {
        int[] seq1 = {3, 4, 5};
        int[] seq2 = {6, 7, 8};
        double expectedResult = 0;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( expectedResult ) );
    }

    @Test
    public void notEmptySequencesWithOneIntersectionTest() throws Exception {
        int[] seq1 = {3, 4, 5, 6};
        int[] seq2 = {6, 7, 8};
        double expectedResult = 1 / 6d;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( expectedResult ) );
    }

    @Test
    public void notEmptySequencesWithManyIntersectionTest() throws Exception {
        int[] seq1 = {3, 4, 5, 6};
        int[] seq2 = {4, 5, 6, 7, 8};
        double expectedResult = 3 / 6d;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( expectedResult ) );
    }

    @Test
    public void firstSequenceInSecondSequenceTest() throws Exception {
        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {1, 2, 3, 4, 5, 6, 7, 8};
        double expectedResult = 4 / 8d;
        assertThat( similarityFinder.calculateJackardSimilarity( seq1, seq2 ), is( expectedResult ) );
    }

}