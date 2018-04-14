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
}
