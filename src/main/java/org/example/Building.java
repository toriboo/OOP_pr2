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
    public int getFloor(){
        return floor;
    }
    public String getAddress(){
        return street + ' ' + house + ' ' + floor;
    }
}

