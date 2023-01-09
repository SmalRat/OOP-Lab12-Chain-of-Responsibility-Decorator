package ucu.decorator;

import lombok.SneakyThrows;

import java.sql.*;

public class CachedDocument implements Document {
    public final Document document;

    public CachedDocument(Document document) {
        this.document = document;
    }

    @SneakyThrows
    @Override
    public String parse() {
        String text = "";
        String gcsPath = document.getGcsPath();

        Connection connection = DriverManager.getConnection("jdbc:sqlite:TextsCaches");
        try (PreparedStatement select = connection.prepareStatement(
                "SELECT source, image_text FROM texts WHERE source = ?")) {
            select.setString(1, gcsPath);
            try (ResultSet rs = select.executeQuery()) {
                if (rs.getString("image_text") != null) {
                    text += "Got from cache: \n";
                    text += rs.getString("image_text");
                }
                else {
                    throw new SQLException();
                }
            }
        }
        catch (SQLException exception){
            text = document.parse();
            PreparedStatement select = connection.prepareStatement("insert into texts (source, image_text) values (?, ?)");
            select.setString(1, gcsPath);
            select.setString(2, text);
            select.executeUpdate();
            select.close();
        }

        return text;
    }

    @Override
    public String getGcsPath() {
        return document.getGcsPath();
    }
}
