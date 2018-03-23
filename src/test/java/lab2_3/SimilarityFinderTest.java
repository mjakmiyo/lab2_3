package lab2_3;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {
	SequenceSearcher searcher;
	@Test
	public void CalculateJackardSimilarityTest() {
		SimilarityFinder similarityFinder=new SimilarityFinder(searcher);
		int[] seq1= {1,2,3,4,5};
		int[] seq2= {1,2,3,4,5,6,7,8,9,10};
		int intersect=5;
		int union=seq1.length+seq2.length-intersect;
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is((double)intersect/(double)union));
		//should return 2.0
	}
	@Test
	public void CalculateJackardSimilarityForEmptySequencesTest() {
		SimilarityFinder similarityFinder=new SimilarityFinder(searcher);
		int[] seq1= {};
		int[] seq2= {};
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(1.0d));
	}
}
