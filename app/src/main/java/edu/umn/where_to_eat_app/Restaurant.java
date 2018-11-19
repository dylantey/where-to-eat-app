package edu.umn.where_to_eat_app;

public class Restaurant {
    private String name;
    private String address;
    private double distance;
    private double rating;
    private Restaurants.type[] cuisine;
    private int imgSrc;

    public Restaurant(String name, String address, double distance, double rating, int imgSrc,
                      Restaurants.type... cuisine) {
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.rating = rating;
        this.cuisine = cuisine;
        this.imgSrc = imgSrc;
    }

    public String getName() { return name; }

    public String getAddress() { return address; }

    public double getDistance() { return distance; }

    public double getRating() { return rating; }

    public int getImgSrc() { return imgSrc; }

    public Restaurants.type[] getCuisine() { return cuisine; }
}