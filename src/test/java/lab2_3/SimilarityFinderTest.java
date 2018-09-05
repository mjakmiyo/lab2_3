package lab2_3;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
public class SimilarityFinderTest {
	private static SimilarityFinder similarityFinder;
	private static SequenceSearcher searcher;
	private static SearchResult searchResult;
	@BeforeClass
	public static void init() {
		searchResult = mock(SearchResult.class);
		searcher = new SequenceSearcher() {
			
			public SearchResult search(int key, int[] seq) {
				for (int i: seq) {
					if(i==key) 
						return searchResult;
				}
				return mock(SearchResult.class);
			}
		};
		similarityFinder=new SimilarityFinder(searcher);
	}


	@Before
 	public void initMockMethod() {
 		initMocks(this);
 		when(searchResult.isFound()).thenReturn(true);
 	}
	
	@Test
	public void CalculateJackardSimilarityForEmptySequencesTest() {
		int[] seq1= {};
		int[] seq2= {};
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(1.0d));
	}
	
	@Test
 	public void CalculateJackardSimilarityForOneEmptySequenceTest () {
 	int[] seq1= {};
 	int[] seq2= {1,2};
 	assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(0d));
	}
	
	@Test
 	public void CalculateJackardSimilarityForTheSameSequencesTest() {
 		int[] seq1= {1,2,3};
 		int[] seq2= {1,2,3};
 		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(1.0d));
 	}
	
	@Test
 	public void CaluculateJackardSimilatiryForTwoDistinctSequencesTest() {
 		int[] seq1= {1,2,3,4};
 		int[] seq2= {5,6,7,8,9};
 		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(0d));
 	}
	
}