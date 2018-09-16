package edu.iis.mto.similarity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.search.SequenceSearcher;

public class SimilarityFinderTest {
	private SequenceSearcher sequenceSearcher;
	private SimilarityFinder similarityFinder;

	@Before
	public void setUp() {
		sequenceSearcher = new SequenceSearcherPart();
		similarityFinder = new SimilarityFinder(sequenceSearcher);
	}

	@Test
	public void twoEmptySequencesShouldReturn1() {
		final int[] sequence1 = {};
		final int[] sequence2 = {};
		assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1d));
	}

	@Test
	public void twoSameSequencesShouldReturn1() {
		final int[] sequence1 = { 1, 2, 3 };
		final int[] sequence2 = { 1, 2, 3 };
		assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1d));
	}
}