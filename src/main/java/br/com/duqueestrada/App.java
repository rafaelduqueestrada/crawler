package br.com.duqueestrada;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException {
        System.setProperty("http.proxyHost", "proxy.pgj.rj.gov.br");
        System.setProperty("http.proxyPort", "3128");
        System.setProperty("http.proxyUser", "rafael.michelli");
        System.setProperty("http.proxyPassword", "");

        System.setProperty("https.proxyHost", "proxy.pgj.rj.gov.br");
        System.setProperty("https.proxyPort", "3128");
        System.setProperty("https.proxyUser", "rafael.michelli");
        System.setProperty("https.proxyPassword", "");

        Document doc = Jsoup.connect("http://www.hascode.com/").userAgent("Mozilla").timeout(6000).get();
        String title = doc.title(); // parsing the page's title
        System.out.println("The title of www.hascode.com is: " + title);
        Elements heading = doc.select("h2 > a"); // parsing the latest article's
        // heading
        System.out.println("The latest article is: " + heading.text());
        System.out.println("The article's URL is: " + heading.attr("href"));
        Elements editorial = doc.select("div.BlockContent-body small");
        System.out.println("The was created: " + editorial.text());
    }
}
