package edu.umn.where_to_eat_app;

import java.util.ArrayList;
import java.util.Arrays;

public class Restaurants {

    private static ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();
    private static ArrayList<Restaurant> filteredRestaurants = new ArrayList<>();
    private static ArrayList<Restaurant> selectedRestaurants = new ArrayList<>();

    private static String openedRestaurant = null;

    public enum type {
        FAST_FOOD, SIT_DOWN, CASUAL, BAR,
        JAPANESE, KOREAN, CHINESE, HISPANIC, ITALIAN, AMERICAN,
        CHICKEN, PIZZA, BURGERS, TACOS, SUSHI
    }

    public Restaurants() {
        restaurantArrayList.add(new Restaurant("Applebee's",
                "615 Washington Ave SE, Minneapolis, MN 55414", 0.2, 2.8, R.drawable.resimg_applebees,
                type.BAR, type.SIT_DOWN, type.CASUAL, type.BURGERS, type.AMERICAN));
        restaurantArrayList.add(new Restaurant("Haiku",
                "620 Washington Ave SE, Minneapolis, MN 55414", 0.2, 4.0, R.drawable.resimg_haiku,
                type.CASUAL, type.SIT_DOWN, type.JAPANESE, type.SUSHI));
        restaurantArrayList.add(new Restaurant("Chick-Fil-A",
                "300 SE Washington Ave, Minneapolis, MN 55455", 0.2, 4.4, R.drawable.resimg_chickfila,
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


    //gets restaurant by position
    public static Restaurant restaurantGet(int position){
        return restaurantArrayList.get(position);
    }
    //gets selected by position
    public static Restaurant selectedGet(int position){
        return selectedRestaurants.get(position);
    }
    //add by position
    public static void selectedAdd(Restaurant r){
        selectedRestaurants.add(r);
    }
    //removes by position
    public static void selectedRemove(Restaurant r){
        selectedRestaurants.remove(r);
    }
    //returns size of restaurantArrayList
    public static int restaurantSize(){
        return restaurantArrayList.size();
    }
    //returns size of selectedRestaurants
    public static int selectedSize(){
        return selectedRestaurants.size();
    }
    public static String getOpenedRestaurant() { return openedRestaurant; }
    public static void setOpenedRestaurant(String s) { openedRestaurant = s; }
}
