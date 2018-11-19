package edu.umn.where_to_eat_app;

import java.util.ArrayList;
import java.util.Arrays;

public class Restaurants {

    private static ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();
    private static ArrayList<Restaurant> filteredRestaurants = new ArrayList<>();
    private static ArrayList<Restaurant> selectedRestaurants = new ArrayList<>();

    public enum type {
        FAST_FOOD, SIT_DOWN, CASUAL, BAR,
        JAPANESE, KOREAN, CHINESE, HISPANIC, ITALIAN, AMERICAN,
        CHICKEN, PIZZA, BURGERS, TACOS, SUSHI
    }

    public Restaurants() {
        restaurantArrayList.add(new Restaurant("Applebee's",
                "615 Washington Ave SE, Minneapolis, MN 55414", 0.2, 2.8,
                type.BAR, type.SIT_DOWN, type.CASUAL, type.BURGERS, type.AMERICAN));
        restaurantArrayList.add(new Restaurant("Haiku",
                "620 Washington Ave SE, Minneapolis, MN 55414", 0.2, 4.0,
                type.CASUAL, type.SIT_DOWN, type.JAPANESE, type.SUSHI));
        restaurantArrayList.add(new Restaurant("Chick-Fil-A",
                "300 SE Washington Ave, Minneapolis, MN 55455", 0.2, 4.4,
                type.FAST_FOOD, type.CHICKEN));

    }

    public void filter(double distance, double rating, type ... cuisine) {

        if(distance == -1.0) {
            distance = Double.MAX_VALUE;
        }

        if(rating == -1.0) {
            rating = 5.0;
        }

        // clear filtered list
        filteredRestaurants = new ArrayList<>();


        for(Restaurant r : restaurantArrayList) {
            if(r.getDistance() <= distance && r.getRating() >= rating) {
                if(Arrays.asList(r.getCuisine()).containsAll(Arrays.asList(cuisine))) {
                    filteredRestaurants.add(r);
                }
            }
        }
    }

    public void selectRestaurant(String name) {
        for(Restaurant r : restaurantArrayList) {
            if(r.getName().equals(name)) {
                selectedRestaurants.add(r);
            }
        }
    }

    public void removeRestaurant(String name) {
        Restaurant remove = null;
        for(Restaurant r : selectedRestaurants) {
            if(r.getName().equals(name)) {
                remove = r;
            }
        }

        if(remove != null) {
            selectedRestaurants.remove(remove);
        }
    }

    public static Restaurant getRestaurantObject(String name) {
        for(Restaurant r : restaurantArrayList) {
            return r;
        }
        return null;
    }

    public static ArrayList<Restaurant> getRestaurantArrayList() {
        return restaurantArrayList;
    }

    public static ArrayList<Restaurant> getFilteredRestaurants() {
        return filteredRestaurants;
    }

    public static ArrayList<Restaurant> getSelectedRestaurants() {
        return selectedRestaurants;
    }

    private class Restaurant {
        private String name;
        private String address;
        private double distance;
        private double rating;
        private type[] cuisine;

        public Restaurant(String name, String address, double distance, double rating, type ... cuisine) {
            this.name = name;
            this.address = address;
            this.distance = distance;
            this.rating = rating;
            this.cuisine = cuisine;
        }

        public String getName() { return name; }

        public String getAddress() { return address; }

        public double getDistance() { return distance; }

        public double getRating() { return rating; }

        public type[] getCuisine() { return cuisine; }
    }
}
