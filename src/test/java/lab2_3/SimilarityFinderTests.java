package lab2_3;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
	public void CalculateJackardSimilarityWithOneCommonElementAndDifferentLength() {
		
		int[] seqA = {1, 2};
		int[] seqB = {1, 3, 4};		
		final double EXPECTED = finder.calculateJackardSimilarity(seqA, seqB);
		assertThat(EXPECTED, is(0.25d));
	}
	
	@Test
	public void CalculateJackardSimilarityWithOneCommonElementAndTheSameLength() {
		
		int[] seqA = {1, 2, 5, 8};
		int[] seqB = {1, 3, 4, 6};		
		final double EXPECTED = finder.calculateJackardSimilarity(seqA, seqB);
		assertThat(EXPECTED, is(0.25d));
	}
	
	@Test
	public void CalculateJackardSimilarityWithoutCommonElementsAndDifferentLength() {
		
		int[] seqA = {1, 2 };
		int[] seqB = {3, 4, 5};
		final double EXPECTED = finder.calculateJackardSimilarity(seqA, seqB);		
		assertThat(EXPECTED, is(0d));
	}
	
	@Test
	public void CalculateJackardSimilarityWithoutCommonElementsAndSameLength() {
		
		int[] seqA = {1, 2, 8 };
		int[] seqB = {3, 4, 5};
		final double EXPECTED = finder.calculateJackardSimilarity(seqA, seqB);		
		assertThat(EXPECTED, is(0d));
	}

	@Test
	public void CalculateJackardSimilarityWhenBothSequencesAreTheSame() {
		
		int[] seqA = {1, 2};
		int[] seqB = {1, 2};
		final double EXPECTED = finder.calculateJackardSimilarity(seqA, seqB);		
		assertThat(EXPECTED, is(1.0d));
	}
}
