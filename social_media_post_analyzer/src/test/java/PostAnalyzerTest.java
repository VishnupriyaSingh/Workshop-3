import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class PostAnalyzerTest {

    @Test
    public void testValidPostAnalysis() throws InvalidPostException {
        PostAnalyzer analyzer = new PostAnalyzer();
        String postContent = "This is a valid post with #hashtag.";
        Map<String, Integer> result = analyzer.analyzePost(postContent);
        assertAll("post analysis",
                () -> assertEquals(7, result.get("wordCount")),
                () -> assertEquals(35, result.get("characterCount")),
                () -> assertEquals(1, result.get("hashtagCount"))
        );
    }

    @Test
    public void testInvalidPostAnalysis() {
        PostAnalyzer analyzer = new PostAnalyzer();
        String postContent = "Invalid post with special character @.";
        assertThrows(InvalidPostException.class, () -> {
            analyzer.analyzePost(postContent);
        });
    }
}