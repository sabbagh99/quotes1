package quotes1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) throws IOException,FileNotFoundException {
        System.out.println(quotes());
        quotes();
    }

    public static String quotes() throws  IOException, FileNotFoundException {


        String apiURL2 = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        BufferedReader reader = null;
        int rand = (int) Math.floor(Math.random() * (158 - 0 + 1) + 0);
        String quote = "";
        try {
            HttpURLConnection connection = getHttpURLConnection(apiURL2);
            reader= getBufferedReader(connection);
            quote = writeGson(reader).get(rand).toString();

            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            return  (readQuote()[rand]).toString();
        }
        return quote;
    }

    static HttpURLConnection getHttpURLConnection(String apiURL2) throws IOException {
        URL url = new URL(apiURL2);
        HttpURLConnection connection = getHttpURLConnection(url);
        return connection;
    }

    static BufferedReader getBufferedReader(HttpURLConnection connection) throws IOException {
        return new BufferedReader(streamReader(connection));
    }

    private static InputStreamReader streamReader(HttpURLConnection connection) throws IOException {
        return new InputStreamReader(connection.getInputStream());
    }

    private static HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");
        return connection;
    }

    public static List<Object> writeGson(BufferedReader reader) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("allQuotes.json");
        List<Object> allQuotes = new ArrayList<>();
        for (int i = 0; i < readQuote().length; i++) {
            allQuotes.add(readQuote()[i]);
        }
        String apiData = reader.readLine();
        apiQuotes convertedObject = gson.fromJson(apiData, apiQuotes.class);
        allQuotes.add(convertedObject);
        gson.toJson(allQuotes, writer);
        reader.close();
        writer.close();
        return allQuotes;
    }
    public static recentQuotes[] readQuote() throws FileNotFoundException {
        Gson gson = new Gson();
        Reader reader = new FileReader("/home/sabbagh99/Desktop/ASAC/code-401/quotes/recentquotes.json");
        recentQuotes[] convertedObject = gson.fromJson(reader, recentQuotes[].class);
        return convertedObject;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}