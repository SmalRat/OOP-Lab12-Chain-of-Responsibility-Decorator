package ucu.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class cacheDecoratorTest {
    @Test
    public void cacheTest() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:TextsCaches");
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE texts");
        stmt.executeUpdate("create table texts" +
                "(" +
                "    source  text," +
                "    image_text text" +
                ");");
        stmt.close();

        Document document = new SmartDocument("gs://oop-course/Geico-2021.png");
        TimedDocument timedDocument = new TimedDocument(document);
        CachedDocument cachedDocument = new CachedDocument(document);
        CachedDocument cachedTimedDocument = new CachedDocument(timedDocument);

        String result = document.parse();
        String nonCachedResponse = cachedDocument.parse();
        String cachedResponse = cachedDocument.parse();

        Assertions.assertEquals(result, nonCachedResponse);
        Assertions.assertEquals("Got from cache: \n" + nonCachedResponse, cachedResponse);
    }
}
