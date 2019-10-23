package model;

import ui.WebString;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        WebString webby = new WebString("https://jsoup.org/");
        System.out.println(webby.getHTML());
    }
}
