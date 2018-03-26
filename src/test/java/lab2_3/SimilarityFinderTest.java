package lab2_3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {

    private SearchResult trueSearchResult = Mockito.mock(SearchResult.class);
    private SearchResult falseSearchResult = Mockito.mock(SearchResult.class);
    private SequenceSearcher sequenceSearcher = new SequenceSearcher() {
        public SearchResult search(int i, int[] seq) {
            for (int k=0; k<seq.length; k++) {
                if (seq[k] == i) {
                    return trueSearchResult;
                }
            }
            return falseSearchResult;
        }
    };
    private SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
    
    @Before
    public void setUp() {
        when(trueSearchResult.isFound()).thenReturn(true);
    }
    
    @Test
    public void testingTwoEmptySequencesShouldReturnOne() {
        int seq1[] = {};
        int seq2[] = {};
        double expectedResult = 1.0;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }
    
    @Test
    public void testingOneEmptySequenceShouldReturnZero() {
        int seq1[] = {1, 2};
        int seq2[] = {};
        double expectedResult = 0;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }
    
}
