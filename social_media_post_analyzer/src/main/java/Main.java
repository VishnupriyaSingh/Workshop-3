import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PostAnalyzer postAnalyzer = new PostAnalyzer();
        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();

        String postContent = "I had a great day! #fun #happy";

        try {
            Map<String, Integer> postAnalysisResult = postAnalyzer.analyzePost(postContent);
            System.out.println("Post Analysis:");
            System.out.println("Word Count: " + postAnalysisResult.get("wordCount"));
            System.out.println("Character Count: " + postAnalysisResult.get("characterCount"));
            System.out.println("Hashtag Count: " + postAnalysisResult.get("hashtagCount"));

            String sentimentResult = sentimentAnalyzer.analyzeSentiment(postContent);
            System.out.println("\nSentiment Analysis:");
            System.out.println("Sentiment: " + sentimentResult);

            boolean isSupportedLanguage = sentimentAnalyzer.isSupportedLanguage(postContent);
            System.out.println("\nLanguage Detection:");
            System.out.println("Is Supported Language: " + isSupportedLanguage);

        } catch (InvalidPostException e) {
            System.err.println("Invalid Post: " + e.getMessage());
        } catch (InvalidSentimentRequestException e) {
            System.err.println("Invalid Sentiment Request: " + e.getMessage());
        } catch (UnsupportedLanguageException e) {
            System.err.println("Unsupported Language: " + e.getMessage());
        }
    }
}
