package eom.study.sunday.request;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public enum ExposureTypeValue implements ExposureType {
    ALL_TEXT("A") {
        public String parseUrlData(String url) {
            return getDocument(url).html();
        }
    },
    WITHOUT_TAG("B") {
        public String parseUrlData(String url) {
            return getDocument(url).text();
        }
    };

    private ExposureTypeValue(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    // private은 왜 안되지?
    Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace(); // 예외처리 필요
        }

        return document;
    }

    private String type;
}
