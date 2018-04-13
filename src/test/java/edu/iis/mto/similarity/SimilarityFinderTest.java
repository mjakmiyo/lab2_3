package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SimilarityFinderTest {

    private static SimilarityFinder similarityFinder;
    private static SequenceSearcherDummyClass sequenceSearcher;
    private static SearchResultDummyClass searchResult;

    private static int[] seq1;
    private static int[] seq2;
    private boolean[] answerArray = {};

    @BeforeClass
    public static void setup() {
        sequenceSearcher = new SequenceSearcherDummyClass();
        searchResult = new SearchResultDummyClass();
    }

    @Before
    public void setUpSimilarityFinderClass() {
        similarityFinder = new SimilarityFinder(sequenceSearcher);
    }

    @Test
    public void returnOneWhenBothSequencesWasEmpty() {
        seq1 = new int[0];
        seq2 = new int[0];
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(1.0d));
    }

    @Test
    public void checkCorrectReturnValueIfSequencyTwoIsEmpty() {
        int length = new Random().nextInt(100) + 1;
        seq1 = new int[length];
        seq2 = new int[0];
        for (int i = length; i > 0; i--) {
            seq1[i - 1] = i;
        }
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(0d));
    }

    @Test
    public void checkCorrectReturnValueIfSequencyOneIsEmpty() {
        int length = new Random().nextInt(100) + 1;
        seq1 = new int[0];
        seq2 = new int[length];
        for (int i = length; i > 0; i--) {
            seq2[i - 1] = i;
        }
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(0d));
    }

    @Test
    public void checkCorrectValueWhenBothSequencesAreTheSame() {
        int length = new Random().nextInt(100) + 1;
        seq1 = new int[length];
        seq2 = new int[length];
        for (int i = length; i > 0; i--) {
            seq2[i - 1] = seq1[i - 1] = i;
        }
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(1.0d));
    }

    @Test
    public void checkCorrectValueWhenOneSequencesAreSmaller() {
        int length = new Random().nextInt(100) + 1;
        int length2 = new Random().nextInt(100) + 1;
        while(length == length2) {
            length2 = new Random().nextInt(100) + 1;
        }
        seq1 = new int[length];
        seq2 = new int[length2];
        for (int i = length; i > 0; i--) {
            seq1[i - 1] = i;
        }
        for (int i = length2; i > 0; i--) {
            seq2[i - 1] = i;
        }
        int smaller = length > length2 ? length2 : length;
        double larger = (double) length > length2 ? length : length2;
        answerArray = new boolean[smaller];
        for (int i = 0; i < smaller; i++) {
            answerArray[i] = true;
        }
        sequenceSearcher.setAnswerArray(answerArray);
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(smaller/larger));
    }

    @Test
    public void checkWhenTwoSequencesDidNotHaveAnyCommonElements() {
        seq1 = new int[]{0, 1, 2, 3, 4};
        seq2 = new int[]{5, 6, 7};
        answerArray = new boolean[seq1.length];
        sequenceSearcher.setAnswerArray(answerArray);
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(0d));
    }

    @Test
    public void checkWhenTwoSequencesHaveSomeCommonElements() {
        seq1 = new int[]{0, 1, 2, 3, 4};
        seq2 = new int[]{3, 4, 5, 6, 7};
        answerArray = new boolean[seq1.length];
        answerArray[0] = answerArray[1] = true;
        sequenceSearcher.setAnswerArray(answerArray);
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is((double) 2/8));
    }
}