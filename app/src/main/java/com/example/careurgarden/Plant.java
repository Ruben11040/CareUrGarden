package com.example.careurgarden;

import android.widget.ImageView;

import java.io.Serializable;

public class Plant implements Serializable {
    private String scientificName;
    private String name;
    private int image;
    private String type;
    //private String ;
    private int averageHeight; // Grande , Mediana , y pequeña

    public Plant(String scientificName, String name, int image, String type, int averageHeight) {
        this.scientificName = scientificName;
        this.name = name;
        this.image = image;
        this.type = type;
        this.averageHeight = averageHeight;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(int averageHeight) {
        this.averageHeight = averageHeight;
    }
}
