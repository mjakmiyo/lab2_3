package lab2_3;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.*;
import edu.iis.mto.similarity.dubler.*;

public class SimilarityFinderTest {
	private static SimilarityFinder similarityFinder;
	private static SequenceSearcherD searcher;
	
    private SearchResultD searchResultD;
	
	@Test
	public void CalculateJackardSimilarityForEmptySequencesTest() {
	    boolean[] test= {};
        searcher = new SequenceSearcherD(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = {};
		int[] seq2 = {};
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(1.0d));
	}

	@Test
	public void CalculateJackardSimilarityForOneEmptySequenceTest() {
	    boolean[] test= {};
	    searcher = new SequenceSearcherD(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = {};
		int[] seq2 = { 1, 2 };
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(0d));
	};

	@Test
	public void CalculateJackardSimilarityForTheSameSequencesTest() {
	    boolean[] test= {true, true, true};
	    searcher = new SequenceSearcherD(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = { 1, 2, 3 };
		int[] seq2 = { 1, 2, 3 };
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(1.0d));
	}

	@Test
	public void CaluculateJackardSimilarityForTwoDistinctSequencesTest() {
	    boolean[] test= {false, false, false, false};
        searcher = new SequenceSearcherD(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = { 1, 2, 3, 4 };
		int[] seq2 = { 5, 6, 7, 8, 9 };
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(0d));
	}

	@Test
	public void CalculateJackardSimilarityForCommonElementsInSequencesTest() {
	    boolean[] test= {false, false, true, true};
        searcher = new SequenceSearcherD(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = { 1, 2, 3, 4 };
		int[] seq2 = { 3, 4, 5, 6 };
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(2 / 6d));
	}

	@Test
	public void CalculateJackardSimilarityForDistinctLengthWithCommonElementsSequencesTest() {
	    boolean[] test= {true, true, true, false};
        searcher = new SequenceSearcherD(test);
        similarityFinder=new SimilarityFinder(searcher);
		int[] seq1 = { 1, 2, 3, 4 };
		int[] seq2 = { 1, 2, 3, 5, 6, 9, 15 };
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(3 / 8d));
	}

}
