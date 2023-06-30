package com.merqury.mysite.services;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GetIpService {
    public String getIP() throws IOException {
        Document doc = Jsoup
                .connect("https://2ip.ua/ru/")
                .method(Connection.Method.GET)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                .get();
        Elements elements = doc.getElementsByClass("ip");
        return elements.get(0).text();
    }
}
