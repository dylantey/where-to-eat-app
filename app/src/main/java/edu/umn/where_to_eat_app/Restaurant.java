package edu.umn.where_to_eat_app;

public class Restaurant {
    private String name;
    private String address;
    private float distance;
    private float rating;

    public Restaurant(String n, String add, float dis, float r) {
        name = n;
        address = add;
        distance = dis;
        rating = r;
    }

    public String getRestaurant() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public float getDistance() {
        return distance;
    }

    public float getRating() {
        return rating;
    }
}
