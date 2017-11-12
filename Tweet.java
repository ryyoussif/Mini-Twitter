//package assignment2.miniTwitter;

public class Tweet {
    
    private String tweet;
    private boolean isPositive = false;
    
    public Tweet(String tweet) {
        this.tweet = tweet;
        checkIfPositive();
    }
    
    public String getTweet() {
        return this.tweet;
    }
    
    public boolean isPositive() {
        return isPositive;
    }
    
    /* Mark as a positive tweet if tweet message contains positive words */
    private void checkIfPositive() {
        String[] positiveWords = { "good", "great", "excellent", "fantastic", "awesome", "wonderful", "amazing", "magnificent"};
        for (String word : positiveWords) {
            if (tweet.toLowerCase().contains(word)) {
                this.isPositive = true;
                return;
            }
        }
    }
    
}
