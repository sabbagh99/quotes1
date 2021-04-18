package quotes1;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AppTest {

    @Test
    public void testQuotes() throws IOException {
        App classUnderTest = new App();
        String apiURL2 = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        HttpURLConnection connection = classUnderTest.getHttpURLConnection(apiURL2);
        BufferedReader reader = classUnderTest.getBufferedReader(connection);


        assertTrue(classUnderTest.quotes().contains("author"));
        assertEquals("recentQuotes{\n" +
                "tags=[]\n" +
                ", author='George Orwell'\n" +
                ", likes='79 likes'\n" +
                ", text=' “His answer to every problem, every setback was “I will work harder!” —which he had adopted as his personal motto.” '}", classUnderTest.writeGson(reader).get(5).toString());

        assertEquals("recentQuotes{\n" +
                "tags=[monsters]\n" +
                ", author='Chuck Klosterman'\n" +
                ", likes='0 likes'\n" +
                ", text=' “It's easier to believe there's a monster under the bed if you've spent the last six months arguing with a monster.” '}", classUnderTest.readQuote()[10].toString());


    }

    @Test
    public void testAdding() throws IOException {
        App classUnderTest = new App();
        String apiURL2 = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        HttpURLConnection connection = classUnderTest.getHttpURLConnection(apiURL2);
        BufferedReader reader = classUnderTest.getBufferedReader(connection);

        assertTrue(classUnderTest.readQuote().length == 159);
        assertTrue(classUnderTest.writeGson(reader).size() > 159);
    }
}