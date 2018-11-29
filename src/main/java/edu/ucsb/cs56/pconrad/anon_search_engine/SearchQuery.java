package edu.ucsb.cs56.pconrad.anon_search_engine;

public class SearchQuery{
    String engine;
    String userEntry;

    SearchQuery(String rawQuery){
        String splitResult[]= rawQuery.split(":", 2);
        engine = splitResult[0];
        userEntry = splitResult[1];
    }


    public String getEngine(){
        return engine;
    }

    public String getUserEntry(){
        return userEntry;
    }
}
