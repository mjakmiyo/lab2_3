import edu.iis.mto.similarity.SimilarityFinder;
import mock.MockSequenceSearcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class SimilarityFinderTest {
    private SimilarityFinder finder;
    @Before
    public void init() {
        finder = new SimilarityFinder(new MockSequenceSearcher());
    }
    @Test
    public void returnValueOneWhenSequencesAreEmpty() {
        int[] seq1 = new int[0];
        int[] seq2 = new int[0];
        final double EXPECTED_VALUE = 1.0;
        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED_VALUE));
    }
    @Test
    public void returnValueZeroWhenOneSequenceIsEmptyAndAnotherIsSomething() {
        int[] seq1 = new int[1];
        seq1[0]=1;
        int[] seq2 = new int[0];
        final double EXPECTED_VALUE = 0.0;

        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED_VALUE));
        Assert.assertThat(finder.calculateJackardSimilarity(seq2, seq1), is(EXPECTED_VALUE));
    }
    @Test
    public void returnValueOneWhenSequencesAreTheSame() {
        int[] seq1 = new int[1];
        seq1[0]=2;
        int[] seq2 = new int[1];
        seq2[0]=2;
        final double EXPECTED_VALUE = 1.0;
        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED_VALUE));
    }

    @Test
    public void returnValueZeroWhenSequencesAreDifferent() {
        int[] seq1 = new int[1];
        seq1[0]=2;
        int[] seq2 = new int[1];
        seq2[0]=3;
        final double EXPECTED_VALUE = 0.0;
        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED_VALUE));
    }
    @Test
    public void SequencesHasManyElementsAndOnlyOneElementIsTheSame() {
        int[] seq1 = new int[3];
        seq1[0]=1;
        seq1[1]=3;
        seq1[2]=5;
        int[] seq2 = new int[3];
        seq2[0]=3;
        seq2[1]=2;
        seq2[2]=4;
        final double EXPECTED_VALUE = 1.0/5.0;
        Assert.assertThat(finder.calculateJackardSimilarity(seq1, seq2), is(EXPECTED_VALUE));
    }

}

