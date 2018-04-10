package edu.iis.mto.similarity;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.iis.mto.search.SequenceSearcher;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimilarityFinderTest {
	private SimilarityFinder similarityFinder;
	 @Test
	    public void calculateJackardSimilarityShouldReturnCorrectValue(){
	        int[] sequence1 = {1,2,3,4};
	        int[] sequence2 = {1,2,3,5};
	        SequenceSearcher sequenceSearcher = new SequenceSearcherStub(new boolean[]{true, true, true, false});
	        similarityFinder = new SimilarityFinder(sequenceSearcher);
	        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
	        assertThat(result, is(3.0/5.0));
	 }
}
