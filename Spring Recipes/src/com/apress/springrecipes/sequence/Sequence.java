package com.apress.springrecipes.sequence;

public class Sequence {
    private String id;
    private String prefix;
    private String suffix;

    public Sequence(String id, String prefix, String suffix){
        this.id = id;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getId(){
        return this.id;
    }

    public  String getPrefix(){
        return this.prefix;
    }

    public String getSuffix(){
        return this.suffix;
    }
}
