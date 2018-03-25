package lab2_3;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import static org.powermock.api.mockito.PowerMockito.*;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTests {
	
	private static SimilarityFinder similarityFinder;
    private static SequenceSearcher sequenceSearcher;
    private static SearchResult searchResult;
	
    private static int[] sequenceA;
    private static int[] sequenceB;
    
	@BeforeClass
	public void setUp(){
		sequenceSearcher = new SequenceSearcher() {
			public SearchResult search(int i, int[] sequence) {
                for (int k : sequence) {
                    if(k == i) 
                    	return searchResult;
                }
                return Mockito.mock(SearchResult.class);
		}
		
	}

	@Test
	public void ShouldReturnOneIfBothSetsAreEmpty() {
		int[] setA = new int[0];
		int[] setB = new int[0];
		assertThat();
	}

}
