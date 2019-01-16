package com.rpg;

public class Location {
    Monster person;
    String name;
    Location left;
    Location right;
    Location behind;
    Location forward;


    public Location(Monster person, String name, Location left, Location right, Location behind, Location forward) {
        this.person = person;
        this.name = name;
        this.left = left;
        this.right = right;
        this.behind = behind;
        this.forward = forward;
    }

}
