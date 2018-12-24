package com.example.erik.asynctasks.model;

public class Player {
    private String name;
    private String game;
    private String plat;

    public Player(String name, String game, String plat) {
        this.name = name;
        this.game = game;
        this.plat = plat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }
}
