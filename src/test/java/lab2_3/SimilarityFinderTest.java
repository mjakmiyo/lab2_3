package lab2_3;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
public class SimilarityFinderTest {
	private static SimilarityFinder similarityFinder;
	private static SequenceSearcher searcher;
	private static SearchResult searchResult;
	@BeforeClass
	public void init() {
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

	@Test
	public void CalculateJackardSimilarityForEmptySequencesTest() {
		int[] seq1= {};
		int[] seq2= {};
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(1.0d));
	}
	@Test
	public void test() {
		
		SequenceSearcher searcher=new SequenceSearcher() {
			
		};
		
		
	}
	
}
