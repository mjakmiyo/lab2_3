package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest {

    private double getJackardSimilarityResult(int[] seq1, int[] seq2, boolean[] results) {
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(results);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        return similarityFinder.calculateJackardSimilarity(seq1, seq2);
    }

    @Test
    public void calculateJackardSimilarityShouldReturnCorrectValue(){
        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {1, 2, 3, 5};
        boolean[] results = new boolean[]{true, true, true, false};

        double result = getJackardSimilarityResult(seq1, seq2, results);
        assertThat(result, is(3.0 / 5.0));
    }

    @Test
    public void calculateJackardSimilarityWithEmptySequenceShouldReturnCorrectValue(){
        int[] seq1 = {};
        int[] seq2 = {};

        double result = getJackardSimilarityResult(seq1, seq2, new boolean[] {});
        assertThat(result, is(1.0));
    }

    @Test
    public void calculateJackardSimilarityWithOverlapingValueShouldReturnCorrectValue(){
        int[] seq1 = {3, 5, 7, 9};
        int[] seq2 = {5, 2, 4};

        double result = getJackardSimilarityResult(seq1, seq2, new boolean[] {false, true, false, false});
        assertThat(result, is(1.0/6.0));
    }

    @Test
    public void calculateJackardSimilarityShouldReturnZeroWithOneEmptySequence(){
        int[] seq1 = {3};
        int[] seq2 = {};

        double result = getJackardSimilarityResult(seq1, seq2, new boolean[] {false});
        assertThat(result, is(0.0));
    }

    @Test
    public void calculateJackardSimilarityShouldReturnZeroWithDifferentSequences(){
        int[] seq1 = {1, 3, 5, 7, 9};
        int[] seq2 = {2, 4, 6, 8, 0};

        double result = getJackardSimilarityResult(seq1, seq2, new boolean[] {false, false, false, false, false});
        assertThat(result, is(0.0));
    }
}
