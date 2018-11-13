import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File input = new File("index.html");
        File inputNewDIV = new File("newDIV.html");

        Document document = Jsoup.parse(input, "UTF-8", "http://example.com/");
        Document documentNewDIV = Jsoup.parse(inputNewDIV, "UTF-8", "http://example.com/");
        Element newDIV = documentNewDIV.select("div[class=block1]").first();

        Elements els = document.select("div[class=block1]");
        for (Element el : els) {
//            el.replaceWith(new TextNode("<!--div-->", ""));
            el.replaceWith(newDIV);
//            System.out.println(el.text());
        }

        System.out.println(document);
    }
}
