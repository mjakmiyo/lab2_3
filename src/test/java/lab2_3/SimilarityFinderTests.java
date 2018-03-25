package lab2_3;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.similarity.MockSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTests {


SimilarityFinder finder = new SimilarityFinder(new MockSequenceSearcher());
	
	@Test
	public void CalculateJackardSimilarityOneSequenceIsEmpty() {
		
		int[] seqA = {};
		int[] seqB = {2, 4, 5, 7, 8};
		final double EXPECTED = finder.calculateJackardSimilarity(seqA, seqB);			
		assertThat(EXPECTED, is(0d));
	}

}
