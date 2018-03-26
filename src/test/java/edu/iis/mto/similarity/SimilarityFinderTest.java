package edu.iis.mto.similarity;

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


    @Test
    public void calculateJackardSimilarityReturns0WhenOneSequenceIsEmptyTest(){
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherStub());
        int[] seq1 = new int[0];
        int[] seq2 = new int[]{0, 1, 2};
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(0.0));
    }

    @Test
    public void calculateJackardSimilarityReturns0WhenSecondSequenceIsEmptyTest(){
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherStub());
        int[] seq1 = new int[]{0, 1, 2};
        int[] seq2 = new int[0];
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(0.0));
    }
    @Test
    public void calculateJackardSimilarityForSameSequences(){
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherStub());
        int[] seq1 = new int[]{0, 1, 2};
        int[] seq2 = new int[]{0, 1, 2};
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(1.0));
    }

    @Test
    public void calculateJackardSimilarityForDifferentSequences(){
        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherStub());
        int[] seq1 = new int[]{5, 6, 0, 1, 2};
        int[] seq2 = new int[]{0, 1, 2, 11};
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(0.5));
    }
}