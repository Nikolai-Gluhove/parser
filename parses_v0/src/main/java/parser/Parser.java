package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Parser {

    public Parser() throws IOException {
    }

    //парсинг всего html
    private Document getPage() throws IOException {
        String url = "https://yandex.ru/pogoda/details?lat=56.146277&lon=47.251079&via=ms#14";
        Document page = Jsoup.parse(new URL(url), 30000);
        return page;
    }

    private Document page = getPage();

    //получаем карточки с необходимой информацией
    private Elements cards = page.
            select("div[class=forecast-details-segment__container]").
            select("article[class=card]");

    public Elements getCards() {
        return cards;
    }
}

