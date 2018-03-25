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
	
	@Test
	public void CalculateJackardSimilarityBothSequencesAreEmpty() {
		
		int[] seqA = {};
		int[] seqB = {};		
		final double EXPECTED = finder.calculateJackardSimilarity(seqA, seqB);	
		assertThat(EXPECTED, is(1.0d));
	}
	
	@Test
	public void CalculateJackardSimilarityWithOneCommonElement() {
		
		int[] seqA = { 1, 2 };
		int[] seqB = {1, 3, 4};		
		final double EXPECTED = finder.calculateJackardSimilarity(seqA, seqB);
		assertThat(EXPECTED, is(0.25d));
	}
	
	@Test
	public void CalculateJackardSimilarityWithoutCommonElements() {
		
		int[] seqA = { 1, 2 };
		int[] seqB = { 3, 4, 5 };
		final double EXPECTED = finder.calculateJackardSimilarity(seqA, seqB);		
		assertThat(EXPECTED, is(0d));
	}

}
