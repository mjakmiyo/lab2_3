package edu.iis.mto.similarity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SimilarityFinderTest {
	private SequenceSearcherPart sequenceSearcher;
	private SimilarityFinder similarityFinder;

	@Before
	public void setUp() {
		sequenceSearcher = new SequenceSearcherPart();
		similarityFinder = new SimilarityFinder(sequenceSearcher);
	}

	@Test
	public void twoDifferentSequencesShouldReturn0() {
		final boolean[] expectedResults = { false, false, false };
		final int[] sequence1 = { 1, 2, 3 };
		final int[] sequence2 = { 4, 5, 6 };

		sequenceSearcher.setResultsArray(expectedResults);
		assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(0d));
	}

	@Test
	public void twoEmptySequencesShouldReturn1() {
		final int[] sequence1 = {};
		final int[] sequence2 = {};

		assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1d));
	}

	@Test
	public void twoSameSequencesShouldReturn1() {
		final boolean[] expectedResults = { true, true, true };
		final int[] sequence1 = { 1, 2, 3 };
		final int[] sequence2 = { 1, 2, 3 };

		sequenceSearcher.setResultsArray(expectedResults);
		assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1d));
	}

	@Test
	public void twoSequencesWithManyOverlapsShouldReturnCorrectValue() {
		final boolean[] expectedResults = { false, true, false, true, false };
		final int[] sequence1 = { 1, 2, 3, 4, 5 };
		final int[] sequence2 = { 2, 4, 6, 8 };

		sequenceSearcher.setResultsArray(expectedResults);
		assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(2 / 7d));
	}

	@Test
	public void twoSequencesWithOneOverlapShouldReturnCorrectValue() {
		final boolean[] expectedResults = { true, false, false };
		final int[] sequence1 = { 7, 8, 9 };
		final int[] sequence2 = { 5, 6, 7 };

		sequenceSearcher.setResultsArray(expectedResults);
		assertThat(similarityFinder.calculateJackardSimilarity(sequence1, sequence2), is(1 / 5d));
	}
}