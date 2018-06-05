package edu.iis.mto.similarity;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.search.SequenceSearcher;

import static org.hamcrest.Matchers.is;


public class SimilarityFinderTest {
	
	private SimilarityFinder similarityFinder;
	
	@Test
	public void calculateJackardSimilarityShouldReturnOneForEmptySequences(){
		
		boolean [] results= {};
		int [] firstSequence= {};
		int [] secondSequence= {};
		
		SequenceSearcher sequenceSearcherStub= new SequenceSearcherStub(results);
		similarityFinder= new SimilarityFinder(sequenceSearcherStub);
		double expectedValue=similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
		
		assertThat(expectedValue,is(1.0));
	}
	
	@Test
	public void calcuateJackardSimilarityShouldReturnZeroWhenFirstSequenceIsEmpty(){
		boolean [] results= {};
		int [] firstSequence= {};
		int [] secondSequence= {5,3,2};
		
		SequenceSearcher sequenceSearcherStub= new SequenceSearcherStub(results);
		similarityFinder= new SimilarityFinder(sequenceSearcherStub);
		double expectedValue=similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
		
		assertThat(expectedValue,is(0.0));
	}
	
	@Test
	public void calcuateJackardSimilarityShouldReturnZeroWhenSecondSequenceIsEmpty(){
		boolean [] results= {false,false,false,false};
		int [] firstSequence= {123,11,0,2};
		int [] secondSequence= {};
		
		SequenceSearcher sequenceSearcherStub= new SequenceSearcherStub(results);
		similarityFinder= new SimilarityFinder(sequenceSearcherStub);
		double expectedValue=similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
		
		assertThat(expectedValue,is(0.0));
	}
	
	@Test
	public void calculateJackardSimilarityShouldReturnCorrectResultWhenSequencesArentEmpty() {
		boolean [] results= {false,false,true,true};
		int [] firstSequence= {2,4,5,6};
		int [] secondSequence= {5,6,7,8};
		SequenceSearcher sequenceSearcherStub= new SequenceSearcherStub(results);
		similarityFinder= new SimilarityFinder(sequenceSearcherStub);
		double expectedValue=similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
		
		assertThat(expectedValue,is(2.0/6.0));
	}
	
	@Test
	public void calculateJackardSimilarityShouldReturnOneForTheSameSequences() {
		boolean [] results= {true,true,true,true};
		int [] firstSequence= {2,4,5,6};
		int [] secondSequence= {2,4,5,6};
		SequenceSearcher sequenceSearcherStub= new SequenceSearcherStub(results);
		similarityFinder= new SimilarityFinder(sequenceSearcherStub);
		double expectedValue=similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
		
		assertThat(expectedValue,is(1.0));
	}
	
	@Test
	public void calculateJackardSimilarityShouldReturnOneForSequencesWithTheSameValues() {
		boolean [] results= {true,true,true,true};
		int [] firstSequence= {5,6,4,2};
		int [] secondSequence= {2,4,5,6};
		SequenceSearcher sequenceSearcherStub= new SequenceSearcherStub(results);
		similarityFinder= new SimilarityFinder(sequenceSearcherStub);
		double expectedValue=similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
		
		assertThat(expectedValue,is(1.0));
	}
	
	@Test
	public void calculateJackardSimilarityShouldReturnZeroForDiffrentSequences() {
		boolean [] results= {false,false,false,false};
		int [] firstSequence= {5,6,4,2};
		int [] secondSequence= {22,23,54,61};
		SequenceSearcher sequenceSearcherStub= new SequenceSearcherStub(results);
		similarityFinder= new SimilarityFinder(sequenceSearcherStub);
		double expectedValue=similarityFinder.calculateJackardSimilarity(firstSequence, secondSequence);
		
		assertThat(expectedValue,is(0.0));
	}
}
