package lab2_3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import edu.iis.mto.mock.MySequenceSearcher;
import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {
    
    @Test
    public void testingTwoEmptySequencesShouldReturnOne() {
        boolean expectedResults[] = {false};
        SequenceSearcher sequenceSearcher = new MySequenceSearcher(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int seq1[] = {};
        int seq2[] = {};
        double expectedResult = 1.0;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }
    
    @Test
    public void testingOneEmptySequenceShouldReturnZero() {
        boolean expectedResults[] = {false, false};
        SequenceSearcher sequenceSearcher = new MySequenceSearcher(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int seq1[] = {1, 2};
        int seq2[] = {};
        double expectedResult = 0;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }
    
    @Test
    public void testingTwoNonEmptySequencesShouldReturnCorrectValue() {
        boolean expectedResults[] = {true, false};
        SequenceSearcher sequenceSearcher = new MySequenceSearcher(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int seq1[] = {1, 8};
        int seq2[] = {3, 4, 1};
        double expectedResult = 0.25;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }
    
    @Test
    public void testingTwoTheSameSequencesShouldReturnOne() {
        boolean expectedResults[] = {true, true, true, true};
        SequenceSearcher sequenceSearcher = new MySequenceSearcher(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int seq1[] = {1, 3, 5, 6};
        int seq2[] = {1, 3, 5, 6};
        double expectedResult = 1;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }
    
    @Test
    public void testingTwoSequencesWithTheSameNumbersShouldReturnOne() {
        boolean expectedResults[] = {true, true, true, true};
        SequenceSearcher sequenceSearcher = new MySequenceSearcher(expectedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int seq1[] = {14, 2, 7, 1};
        int seq2[] = {7, 2, 1, 14};
        double expectedResult = 1;
        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(expectedResult));
    }
    
}
