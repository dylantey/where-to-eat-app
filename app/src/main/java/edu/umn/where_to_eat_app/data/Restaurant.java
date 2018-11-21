package edu.umn.where_to_eat_app.data;

public class Restaurant implements Comparable{
    private String name;
    private String address;
    private double distance;
    private double rating;
    private int dollars;
    private Restaurants.type[] cuisine;
    private int imgSrc;

    public Restaurant(String name, String address, double distance, double rating, int dollars, int imgSrc,
                      Restaurants.type... cuisine) {
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.rating = rating;
        this.cuisine = cuisine;
        this.dollars = dollars;
        this.imgSrc = imgSrc;
    }

    public String getName() { return name; }

    public String getAddress() { return address; }

    public double getDistance() { return distance; }

    public double getRating() { return rating; }

    public int getImgSrc() { return imgSrc; }

    public int getDollars() { return dollars; }

    public Restaurants.type[] getCuisine() { return cuisine; }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Restaurant) o).getName());
    }
}