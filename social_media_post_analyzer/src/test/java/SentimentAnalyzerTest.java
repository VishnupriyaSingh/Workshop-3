import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SentimentAnalyzerTest {

    @Test
    public void testPositiveSentimentAnalysis() throws InvalidSentimentRequestException, UnsupportedLanguageException {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();
        String postContent = "I had a great day!";
        assertEquals("Positive", analyzer.analyzeSentiment(postContent));
    }

    @Test
    public void testNegativeSentimentAnalysis() throws InvalidSentimentRequestException, UnsupportedLanguageException {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();
        String postContent = "It was a terrible day.";
        assertEquals("Negative", analyzer.analyzeSentiment(postContent));
    }

    @Test
    public void testNeutralSentimentAnalysis() throws InvalidSentimentRequestException, UnsupportedLanguageException {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();
        String postContent = "This is a post.";
        assertEquals("Neutral", analyzer.analyzeSentiment(postContent));
    }
}