package quotes1;

public class apiQuotes {
    String quoteText;
    String quoteLink;
    String quoteAuthor;

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteLink() {
        return quoteLink;
    }

    public void setQuoteLink(String quoteLink) {
        this.quoteLink = quoteLink;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    @Override
    public String toString() {
        return "apiQuotes{" +
                "quoteText='" + quoteText + '\'' +
                ", quoteLink='" + quoteLink + '\'' +
                ", quoteAuthor='" + quoteAuthor + '\'' +
                '}';
    }
}