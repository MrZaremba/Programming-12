package ui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebString {
    Document doc;




    public WebString(String URLASSTRING) throws IOException {
        doc = Jsoup.connect(URLASSTRING).get();
    }

    public String getHTML(){
        return doc.toString();
    }

}
