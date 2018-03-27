package edu.iis.mto.similarity;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.search.SequenceSearcher;

public class SimilarityFinderTest {

    static SequenceSearcher search;
    public static int union;
    public static SimilarityFinder similarityFinder;
    public static int[] seq1 = {1, 2, 3, 4, 5};
    public static int[] seq2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int intersect = 5;

    @BeforeClass
    public static void setUp() {
        similarityFinder = new SimilarityFinder(search);
        union = seq1.length + seq2.length - intersect;
    }

    @Test
    public void CalculateJackardSimilarityTest() {
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is((double) intersect / union));
    }
}
