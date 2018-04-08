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
}

