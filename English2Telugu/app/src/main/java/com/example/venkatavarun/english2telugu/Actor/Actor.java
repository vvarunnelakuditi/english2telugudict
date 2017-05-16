package com.example.venkatavarun.english2telugu.Actor;

/**
 * Created by venkatavarun on 15-05-2017.
 */

public class Actor {
    private int id;
    private String name;
    private String meaning;

    public Actor(int id, String name, String meaning) {
        this.id = id;
        this.name = name;
        this.meaning = meaning;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(int price) {
        this.meaning = meaning;
    }



}
