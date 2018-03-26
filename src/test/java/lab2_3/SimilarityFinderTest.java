package lab2_3;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
public class SimilarityFinderTest {
	private static SimilarityFinder similarityFinder;
	private static SequenceSearcher searcher;
	@BeforeClass
	public static void init() {
		similarityFinder=new SimilarityFinder(searcher);
	}
	@Test
	public void CalculateJackardSimilarityForEmptySequencesTest() {
		int[] seq1= {};
		int[] seq2= {};
		assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.is(1.0d));
	}
}
