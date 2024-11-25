package org.example;

public class Building {
    String street;
    int house;
    int floor;
    public Building(String street, int house, int floor){
        this.street = street;
        this.house = house;
        this.floor = floor;
    }
    @Override
    public String toString() {
        return "{street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", floor=" + floor + '}';
    }
}
