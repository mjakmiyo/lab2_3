package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {

    private static SimilarityFinder similarityFinder;
    private static int[] seq1;
    private static int[] seq2;

    @Mock
    private static SequenceSearcher searcher;

    @BeforeClass
    public static void setSequencies() {
        int length1 = (int) Math.random() * 100 + 1;
        int length2 = (int) Math.random() * 100 + 1;
        seq1 = new int[length1];
        seq2 = new int[length2];
        for (int i = length1; i > 0; i--) {
            seq1[i - 1] = i;
        }
        for (int i = length2; i > 0; i--) {
            seq2[i - 1] = i;
        }
        similarityFinder = new SimilarityFinder(searcher);
    }

    @Test
    public void returnOneWhenBothSequencesWasEmpty() {
        seq1 = new int[0];
        seq2 = new int[0];
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(1.0d));
    }
}