package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

public class SimilarityFinderTest {

    @Spy
    @InjectMocks
    private static SimilarityFinder similarityFinder;

    private static int[] seq1;
    private static int[] seq2;


    @Mock(name = "searcher")
    private static SequenceSearcher searcher;

    @BeforeClass
    public static void setSimilarityFinder() {
        similarityFinder = new SimilarityFinder(searcher);
    }

    @Test
    public void returnOneWhenBothSequencesWasEmpty() {
        seq1 = new int[0];
        seq2 = new int[0];
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(1.0d));
    }

    @Test
    public void checkCorrectReturnValueIfSequencyTwoIsEmpty() {
        try {
            seq2 = new int[0];
            when(similarityFinder, method(SimilarityFinder.class, "calculateIntersect", int[].class, int[].class))
                    .withArguments(seq1, seq2)
                    .thenReturn(0);
            assertThat(similarityFinder.calculateJackardSimilarity(seq1, new int[0]), is(0d));
        } catch (Exception e) {
        }
    }

    @Test
    public void checkCorrectReturnValueIfSequencyOneIsEmpty() {
        try {
            seq1 = new int[0];
            when(similarityFinder, method(SimilarityFinder.class, "calculateIntersect", int[].class, int[].class))
                    .withArguments(seq1, seq2)
                    .thenReturn(0);
            assertThat(similarityFinder.calculateJackardSimilarity(seq1, new int[0]), is(0d));
        } catch (Exception e) {
        }
    }

    @Test
    public void checkCorrectValueWhenBothSequencesAreTheSame() {
        int length = new Random().nextInt(100) + 1;
        seq1 = new int[length];
        seq2 = new int[length];
        for (int i = length; i > 0; i--) {
            seq2[i - 1] = seq1[i - 1] = i;
        }
        try {
            when(similarityFinder, method(SimilarityFinder.class, "calculateIntersect", int[].class, int[].class))
                    .withArguments(seq1, seq2)
                    .thenReturn(length);
            assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is((double) length));
        } catch (Exception e) {
        }
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
        try {
            when(similarityFinder, method(SimilarityFinder.class, "calculateIntersect", int[].class, int[].class))
                    .withArguments(seq1, seq2)
                    .thenReturn(smaller);
            assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(larger));
        } catch (Exception e) {
        }
    }

    @Test
    public void checkWhenTwoSequencesDidNotHaveAnyCommonElements() {
        seq1 = new int[]{0, 1, 2, 3, 4};
        seq2 = new int[]{5, 6, 7};
        try {
            when(similarityFinder, method(SimilarityFinder.class, "calculateIntersect", int[].class, int[].class))
                    .withArguments(seq1, seq2)
                    .thenReturn(0);
            assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(0d));
        } catch (Exception e) {
        }
    }

    @Test
    public void checkWhenTwoSequencesHaveSomeCommonElements() {
        seq1 = new int[]{0, 1, 2, 3, 4};
        seq2 = new int[]{3, 4, 5, 6, 7};
        try {
            when(similarityFinder, method(SimilarityFinder.class, "calculateIntersect", int[].class, int[].class))
                    .withArguments(seq1, seq2)
                    .thenReturn(2);
            assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is((double) 2/8));
        } catch (Exception e) {
        }
    }
}