import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostAnalyzer {

    public Map<String, Integer> analyzePost(String postContent) throws InvalidPostException {
        if (!isValidPost(postContent)) {
            throw new InvalidPostException("Invalid post content.");
        }

        Map<String, Integer> analysisResult = new HashMap<>();
        analysisResult.put("wordCount", countWords(postContent));
        analysisResult.put("characterCount", countCharacters(postContent));
        analysisResult.put("hashtagCount", countHashtags(postContent));

        return analysisResult;
    }

    private int countWords(String postContent) {
        String trimmed = postContent.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        return trimmed.split("\\s+").length; // separate string around spaces
    }

    private int countCharacters(String postContent) {
        return postContent.length();
    }

    private int countHashtags(String postContent) {
        return (int) Arrays.stream(postContent.split("\\s+"))
                .filter(word -> word.startsWith("#"))
                .count();
    }

    private boolean isValidPost(String postContent) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 .,?!#]+$");
        Matcher matcher = pattern.matcher(postContent);
        return matcher.matches();
    }
}
