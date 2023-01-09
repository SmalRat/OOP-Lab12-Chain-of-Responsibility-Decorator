package ucu.decorator;

public class TimedDocument implements Document{
    public final Document document;

    public TimedDocument(Document document) {
        this.document = document;
    }

    public String getGcsPath() {
        return document.getGcsPath();
    }

    @Override
    public String parse() {
        long startTime = System.currentTimeMillis();
        String text = document.parse();
        long endTime = System.currentTimeMillis();
        text = "Completed in : " + ((double)(endTime - startTime))/1000 + "\n" + text;
        return text;
    }
}
