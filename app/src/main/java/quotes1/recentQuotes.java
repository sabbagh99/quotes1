package quotes1;
import java.util.Arrays;
public class recentQuotes {

    String[] tags;
    String author;
    String likes;
    String text;

    @Override
    public String toString() {
        return "recentQuotes{" +
                "\ntags=" + Arrays.toString(tags) +
                "\n, author='" + author + '\'' +
                "\n, likes='" + likes + '\'' +
                "\n, text='" + text + '\'' +
                '}';
    }
}