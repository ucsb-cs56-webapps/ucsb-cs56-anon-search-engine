package edu.ucsb.cs56.pconrad.springboot.hello;

public class SearchResult{
    String title;
    String subtitle;
    String URL;

    // for this constructor, pass in results in the form as follows:
    // <title>:<subtitle>:<URL>
    SearchResult(String result){
        String splitResult[]= result.split(":", 3);
        title = splitResult[0];
        subtitle = splitResult[1];
        URL = splitResult[2];
    }

    SearchResult(String title, String subtitle, String URL) {
        this.title = title;
        this.subtitle = subtitle;
        this.URL = URL;
    }

    public String getTitle(){
        return title;
    }

    public String getSubtitle(){
        return subtitle;
    }

    public String getURL() {
        return URL;
    }

    public String toSplittableString() {
        return this.getTitle() + ":" + this.getSubtitle() + ":" + this.getURL();
    }
}
