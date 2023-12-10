import java.util.Arrays;
import java.util.List;

public class SentimentAnalyzer {
    List<String> positiveWords = Arrays.asList("happy", "great", "fantastic", "good", "joy");
    List<String> negativeWords = Arrays.asList("sad", "bad", "terrible", "horrible", "pain");

    public String analyzeSentiment(String postContent) throws InvalidSentimentRequestException, UnsupportedLanguageException {
        if (!isValidPostForSentimentAnalysis(postContent)) {
            throw new InvalidSentimentRequestException("Invalid post content for sentiment analysis.");
        }

        int positiveScore = 0;
        int negativeScore = 0;

        for (String word : postContent.toLowerCase().split("\\s+")) {
            if (positiveWords.contains(word)) {
                positiveScore++;
            } else if (negativeWords.contains(word)) {
                negativeScore++;
            }
        }

        if (positiveScore > negativeScore) {
            return "Positive";
        } else if (negativeScore > positiveScore) {
            return "Negative";
        } else {
            return "Neutral";
        }
    }

    private boolean isValidPostForSentimentAnalysis(String postContent) {
        return postContent != null && !postContent.trim().isEmpty();
    }

    //very primitive logic just to show sample implementation
    boolean isSupportedLanguage(String postContent) {
        List<String> englishKeywords = Arrays.asList("the", "and", "is", "in", "a", "had");
        List<String> spanishKeywords = Arrays.asList("y", "es", "en", "el");
        List<String> frenchKeywords = Arrays.asList("le", "et", "est", "dans");

        int englishCount = countKeywords(postContent, englishKeywords);
        int spanishCount = countKeywords(postContent, spanishKeywords);
        int frenchCount = countKeywords(postContent, frenchKeywords);

        if (englishCount > spanishCount && englishCount > frenchCount) {
            return true;
        }

        return false;
    }

    private int countKeywords(String postContent, List<String> keywords) {
        int count = 0;
        for (String keyword : keywords) {
            count += postContent.toLowerCase().contains(keyword) ? 1 : 0;
        }
        return count;
    }
}