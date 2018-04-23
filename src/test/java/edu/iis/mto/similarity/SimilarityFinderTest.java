package edu.iis.mto.similarity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.search.SequenceSearcher;

public class SimilarityFinderTest {

    private SimilarityFinder similarityFinder;

    @Test
    public void calculateJackardSimilarityShouldReturnCorrectValue() {
        int[] sequence1 = {1, 2, 3, 4};
        int[] sequence2 = {1, 2, 3, 5};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(new boolean[] {true, true, true, false});
        similarityFinder = new SimilarityFinder(sequenceSearcher);
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        assertThat(result, is(3.0 / 5.0));
    }

    @Test
    public void calculateJackardSimilarityWithOneOverlapingValuesShouldStillReturnCorrectValue() {
        int[] sequence1 = {2, 1, 3, 4};
        int[] sequence2 = {1, 5, 8};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(new boolean[] {false, true, false, false});
        similarityFinder = new SimilarityFinder(sequenceSearcher);
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        assertThat(result, is(1.0 / 6.0));
    }

    @Test
    public void calculateJackardSimilarityShouldReturnOneForIdenticalSequences() {
        int[] sequence1 = {1, 2, 3, 4, 5, 6};
        int[] sequence2 = {1, 2, 3, 4, 5, 6};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(
                new boolean[] {true, true, true, true, true, true});
        similarityFinder = new SimilarityFinder(sequenceSearcher);
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        assertThat(result, is(1.0));
    }

    @Test
    public void calculateJackardSimilarityShouldReturnZeroForDifferentSequences() {
        int[] sequence1 = {1, 2, 3, 4, 5, 6};
        int[] sequence2 = {7, 8, 9, 10, 11, 12};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(
                new boolean[] {false, false, false, false, false, false});
        similarityFinder = new SimilarityFinder(sequenceSearcher);
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        assertThat(result, is(0.0));
    }

    @Test
    public void calculateJackardSimilarityShouldReturnOneForTwoEmptySequences() {
        int[] sequence1 = {};
        int[] sequence2 = {};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(new boolean[] {});
        similarityFinder = new SimilarityFinder(sequenceSearcher);
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        assertThat(result, is(1.0));
    }

    @Test
    public void calculateJackardSimilarityShouldReturnZeroIfOnlyFirstSequenceIsEmpty() {
        int[] sequence1 = {};
        int[] sequence2 = {1};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(new boolean[] {false});
        similarityFinder = new SimilarityFinder(sequenceSearcher);
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        assertThat(result, is(0.0));
    }

    @Test
    public void calculateJackardSimilarityShouldReturnZeroIfOnlySecondSequenceIsEmpty() {
        int[] sequence1 = {1};
        int[] sequence2 = {};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(new boolean[] {false});
        similarityFinder = new SimilarityFinder(sequenceSearcher);
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        assertThat(result, is(0.0));
    }

    @Test
    public void calculateJackardSimilarityShouldReturnCorrectValueForLongerSequencesWithRepeatingValues() {
        int[] sequence1 = {99, 98, 97, 96, 95, 54, 43, 32, 21, 134, -5, -6, -7};
        int[] sequence2 = {-6, -7, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean[] resultArray = new boolean[] {false, false, false, false, false, false, false, false, false, false,
                false, true, true};
        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(resultArray);
        similarityFinder = new SimilarityFinder(sequenceSearcher);
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        assertThat(result, is(2.0 / 22.0));
    }
}
