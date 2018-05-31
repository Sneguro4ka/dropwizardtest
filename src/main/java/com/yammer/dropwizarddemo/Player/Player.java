package com.yammer.dropwizarddemo.Player;

import java.util.Comparator;

public class Player implements Comparable {
    private String name;
    private int id;

    public Player(String argName, int argId)
    {
        this.name = argName;
        this.id = argId;
    }

    // --------------------------------------
    // getter and setters
    // --------------------------------------
    public String getName(){ return this.name; }
    public int getId(){ return this.id; }

    public void setName(String argName) { this.name = argName; }
    public void setId(int argId) { this.id = argId; }

    public int compareTo(Object o) {
        Player argP = (Player)o;
        return this.getId() - argP.getId();
    }

    // In order to sort later by ID
    public static class SortByID implements Comparator<Player>
    {
        public int compare(Player argP1, Player argP2) {
            return argP1.getId() - argP2.getId();
        }
    }

    // In order to sort later by NAME
    public static class SortByName implements Comparator<Player>
    {
        public int compare(Player argP1, Player argP2) {
            return argP1.getName().compareTo(argP2.getName());
        }
    }
}
