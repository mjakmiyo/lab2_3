package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimilarityFinderTest {
    @Test
    public void calculateJackardSimilarityReturns1WhenSequencesAreEmptyTest(){
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherStub());
        int[] seq1 = new int[0];
        int[] seq2 = new int[0];
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(1.0d));
    }
}