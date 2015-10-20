package com.example.noelpaulino.myapplication;

/**
 * Created by Noel Paulino on 10/20/2015.
 */
public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    public static final Drink[] drinks = {
            new Drink("Pina Colada","If you like pina coladas",R.drawable.pinacolada)
    };
    private Drink(String name, String description, int imageResourceId){
        this.name=name;
        this.description=description;
        this.imageResourceId = imageResourceId;
    }
    public String getDescription(){
        return description;
    }
    public String getName(){
        return name;
    }
    public int getImageResourceId(){
        return imageResourceId;
    }
    public String toString(){
        return this.name;
    }

}
