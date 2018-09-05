package lab2_3;

import static org.junit.Assert.*;
import org.hamcrest.Matchers;
import org.junit.Test;
import edu.iis.mto.similarity.*;

public class SimilarityFinderTest {
	private static SimilarityFinder similarityFinder;
	private static SequenceSearchDubler searcher;
	
    private SearchResultDubler searchResultDubler;
	
	@Test
	public void CalculateJackardSimilarityForEmptySequencesTest() {
	    boolean[] test= {};
        searcher = new SequenceSearchDubler(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = {};
		int[] seq2 = {};
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(1.0d));
	}

	@Test
	public void CalculateJackardSimilarityForOneEmptySequenceTest() {
	    boolean[] test= {};
	    searcher = new SequenceSearchDubler(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = {};
		int[] seq2 = { 1, 2 };
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(0d));
	};

	@Test
	public void CalculateJackardSimilarityForTheSameSequencesTest() {
	    boolean[] test= {true, true, true};
	    searcher = new SequenceSearchDubler(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = { 1, 2, 3 };
		int[] seq2 = { 1, 2, 3 };
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(1.0d));
	}

	@Test
	public void CaluculateJackardSimilarityForTwoDistinctSequencesTest() {
	    boolean[] test= {false, false, false, false};
        searcher = new SequenceSearchDubler(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = { 1, 2, 3, 4 };
		int[] seq2 = { 5, 6, 7, 8, 9 };
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(0d));
	}

	@Test
	public void CalculateJackardSimilarityForCommonElementsInSequencesTest() {
	    boolean[] test= {false, false, true, true};
        searcher = new SequenceSearchDubler(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = { 1, 2, 3, 4 };
		int[] seq2 = { 3, 4, 5, 6 };
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(2 / 6d));
	}

	@Test
	public void CalculateJackardSimilarityForDistinctLengthWithCommonElementsSequencesTest() {
	    boolean[] test= {true, true, true, false};
        searcher = new SequenceSearchDubler(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = { 1, 2, 3, 4 };
		int[] seq2 = { 1, 2, 3, 5, 6, 9, 15 };
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(3 / 8d));
	}

}