package ucu.decorator;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Document document = new SmartDocument("gs://oop-course/Geico-2021.png");
        TimedDocument timedDocument = new TimedDocument(document);
        CachedDocument cachedDocument = new CachedDocument(document);
        CachedDocument cachedTimedDocument = new CachedDocument(timedDocument);

        //document = CashedDocument(document);
        //System.out.println(document.parse());
        //System.out.println("------------------------------------------------------");
        System.out.println("Simple smart document:");
        System.out.println("-----------------------------------------------------");
        System.out.println(document.parse());
        System.out.println();
        System.out.println("Timed smart document:");
        System.out.println("-----------------------------------------------------");
        System.out.println(timedDocument.parse());
        System.out.println();
        System.out.println("Cached smart document:");
        System.out.println("-----------------------------------------------------");
        System.out.println(cachedDocument.parse());
        System.out.println();
        System.out.println("Cached timed smart document:");
        System.out.println("-----------------------------------------------------");
        System.out.println(cachedTimedDocument.parse());
    }
}
