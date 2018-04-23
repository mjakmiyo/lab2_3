import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SequenceSearcherStub;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimilarityFinderTests {

    @Test
    public void calculatingJackardSimilarityForTwoEmptySequencesShouldReturnOne() {
        boolean[] expectedResults = {};
        int[] sequence1 = {};
        int[] sequence2 = {};
        SequenceSearcher sequenceSearcherStub = new SequenceSearcherStub(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherStub);
        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1.0));
    }

    @Test
    public void calculatingJackardSimilarityForTwoEmptySequencesShouldNotInvokeSearchMethod() {
        boolean[] expectedResults = {};
        int[] sequence1 = {};
        int[] sequence2 = {};
        SequenceSearcherStub sequenceSearcherStub = new SequenceSearcherStub(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherStub);

        similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        assertThat(sequenceSearcherStub.getInvokeCounter(), is(0));
    }

    @Test
    public void calculatingJackardSimilarityWhenFirstSequenceIsEmptyShouldReturnZero() {
        boolean[] expectedResults = {};
        int[] sequence1 = {};
        int[] sequence2 = {4, 1, 6, 0};
        SequenceSearcher sequenceSearcherStub = new SequenceSearcherStub(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherStub);
        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(0.0));
    }

    @Test
    public void calculatingJackardSimilarityWhenSecondSequenceIsEmptyShouldReturnZero() {
        boolean[] expectedResults = {false, false, false, false};
        int[] sequence1 = {1, 12, 3, -6};
        int[] sequence2 = {};
        SequenceSearcher sequenceSearcherStub = new SequenceSearcherStub(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherStub);
        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(0.0));
    }

    @Test
    public void calculatingJackardSimilarityForTwoSameSequencesShouldReturnOne() {
        boolean[] expectedResults = {true, true, true};
        int[] sequence1 = {2, 4, 6};
        int[] sequence2 = {2, 4, 6};
        SequenceSearcher sequenceSearcherStub = new SequenceSearcherStub(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherStub);
        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1.0));
    }

    @Test
    public void calculatingJackardSimilarityForTwoSequencesWithSameValuesShouldReturnOne() {
        boolean[] expectedResults = {true, true, true};
        int[] sequence1 = {6, 2, 4};
        int[] sequence2 = {2, 4, 6};
        SequenceSearcher sequenceSearcherStub = new SequenceSearcherStub(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherStub);
        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1.0));
    }

    @Test
    public void calculatingJackardSimilarityForTwoDifferentSequencesShouldReturnCorrectValue() {
        boolean[] expectedResults = {false, true, true, false};
        int[] sequence1 = {0, 5, 7, 9};
        int[] sequence2 = {5, 7, 1, 517, 2};
        SequenceSearcher sequenceSearcherStub = new SequenceSearcherStub(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherStub);
        assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(2.0 / 7.0));
    }

    @Test
    public void calculatingJackardSimilarityForTwoDifferentSequencesShouldInvokeSearchMethodCorrectNumberOfTimes() {
        boolean[] expectedResults = {false, true, true, false};
        int[] sequence1 = {0, 5, 7, 9};
        int[] sequence2 = {5, 7, 1, 517, 2};
        SequenceSearcherStub sequenceSearcherStub = new SequenceSearcherStub(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherStub);

        similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        assertThat(sequenceSearcherStub.getInvokeCounter(), is(4));
    }
}
