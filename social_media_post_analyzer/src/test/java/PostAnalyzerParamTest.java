import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PostAnalyzerParamTest {

    @ParameterizedTest
    @CsvSource({
            "This is a valid post with #hashtag, 7, 34, 1",
            "Another post #cool #awesome, 4, 27, 2",
            "Simple post, 2, 11, 0"
    })
    public void testValidPostAnalysis(String post, int expectedWordCount, int expectedCharCount, int expectedHashtagCount) throws InvalidPostException {
        PostAnalyzer analyzer = new PostAnalyzer();
        Map<String, Integer> result = analyzer.analyzePost(post);
        assertAll("post analysis",
                () -> assertEquals(expectedWordCount, result.get("wordCount")),
                () -> assertEquals(expectedCharCount, result.get("characterCount")),
                () -> assertEquals(expectedHashtagCount, result.get("hashtagCount"))
        );
    }
}
