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

    private SequenceSearcher sequenceSearcher = new SequenceSearcher() {
        public SearchResult search(int i, int[] seq) {
            for (int k=0; k<seq.length; k++) {
                if (seq[k] == i) {
                    return searchResult;
                }
            }
            return Mockito.mock(SearchResult.class);
        }
    };
    private SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
    private SearchResult searchResult = Mockito.mock(SearchResult.class);
    
    @Before
    public void setUpMockMethods() {
        when(searchResult.isFound()).thenReturn(true);
    }
    
    @Test
    public void testingTwoEmptySequencesShouldReturnOne() {
        int seq1[] = {};
        int seq2[] = {};
        double expectedResult = 1.0;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }
    
}
