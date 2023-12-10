import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class SentimentAnalyzerParamTest {

    @ParameterizedTest
    @CsvSource({
            "I had a great day!, Positive",
            "It was a terrible day., Negative",
            "This is a post., Neutral"
    })
    public void testSentimentAnalysis(String post, String expectedSentiment) throws InvalidSentimentRequestException, UnsupportedLanguageException {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();
        assertEquals(expectedSentiment, analyzer.analyzeSentiment(post));
    }
}
