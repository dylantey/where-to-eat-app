package edu.umn.where_to_eat_app.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import edu.umn.where_to_eat_app.R;

public class Restaurants {

    private static ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();
    private static ArrayList<Restaurant> filteredRestaurants = new ArrayList<>();
    private static ArrayList<Restaurant> selectedRestaurants = new ArrayList<>();

    private static String openedRestaurant = null;

    public enum type {
        FAST_FOOD, SIT_DOWN, CASUAL, BAR,
        JAPANESE, KOREAN, CHINESE, MEXICAN, ITALIAN, AMERICAN,
        CHICKEN, PIZZA, BURGERS, TACOS, SUSHI
    }

    public Restaurants() {
        //reset list so no duplicates
        restaurantArrayList = new ArrayList<>();

        restaurantArrayList.add(new Restaurant("Applebee's",
                "615 Washington Ave SE, Minneapolis, MN 55414",
                0.2, 2.8, 2, R.drawable.resimg_applebees,
                type.BAR, type.SIT_DOWN, type.CASUAL, type.BURGERS, type.AMERICAN));
        restaurantArrayList.add(new Restaurant("Haiku",
                "620 Washington Ave SE, Minneapolis, MN 55414",
                0.2, 4.0, 2, R.drawable.resimg_haiku,
                type.CASUAL, type.SIT_DOWN, type.JAPANESE, type.SUSHI));
        restaurantArrayList.add(new Restaurant("Chick-Fil-A",
                "300 SE Washington Ave, Minneapolis, MN 55455",
                0.2, 4.4, 1,  R.drawable.resimg_chickfila,
                type.FAST_FOOD, type.CHICKEN));
        restaurantArrayList.add(new Restaurant("Buffalo Wild Wings",
                "2001 University Ave SE #100, Minneapolis, MN 55455",
                0.4, 3.1, 2, R.drawable.resimg_bdubs,
                type.BAR, type.SIT_DOWN, type.CASUAL, type.CHICKEN, type.AMERICAN));
        restaurantArrayList.add(new Restaurant("Ichiddo Ramen",
                "1501 University Ave SE suite 130, Minneapolis, MN 55414",
                0.4, 4.5, 1, R.drawable.resimg_ichiddo,
                type.JAPANESE, type.SIT_DOWN, type.CASUAL, type.BAR));
        restaurantArrayList.add(new Restaurant("Blaze Pizza",
                "1000 Washington Ave SE, Minneapolis, MN 55414",
                0.5, 4.6, 1, R.drawable.resimg_blaze,
                type.PIZZA, type.FAST_FOOD, type.CASUAL));
        restaurantArrayList.add(new Restaurant("McDonald's",
                "407 15th Ave SE, Minneapolis, MN 55414",
                0.5, 3.3, 1, R.drawable.resimg_mcdonalds,
                type.FAST_FOOD, type.BURGERS, type.CASUAL));
        restaurantArrayList.add(new Restaurant("Bar Luchador",
                "825 SE Washington Ave, Minneapolis, MN 55414",
                0.3, 4.5, 2, R.drawable.resimg_barluchador,
                type.MEXICAN, type.SIT_DOWN, type.CASUAL));
        restaurantArrayList.add(new Restaurant("Chipotle Mexican Grill",
                "800 Washington Ave SE, Minneapolis, MN 55414",
                0.3, 4.2, 1, R.drawable.resimg_chipotle,
                type.MEXICAN, type.FAST_FOOD, type.CASUAL));
        restaurantArrayList.add(new Restaurant("My Burger",
                "213 SE Oak St, Minneapolis, MN 55414",
                0.3, 4.4, 1, R.drawable.resimg_myburger,
                type.BURGERS, type.FAST_FOOD, type.CASUAL));

        Collections.sort(restaurantArrayList);
    }

    public static void filter(double distance, double rating, int money, type ... cuisine) {

        if(distance == -1.0) {
            distance = Double.MAX_VALUE;
        }

        if(rating == -1.0) {
            rating = 0.0;
        }

        if(money == -1.0) {
            money = 4;
        }

        // clear filtered list
        filteredRestaurants = new ArrayList<>();

        for(Restaurant r : restaurantArrayList) {
            if(r.getDistance() <= distance && r.getRating() >= rating && r.getDollars() <= money) {
                if(Arrays.asList(r.getCuisine()).containsAll(Arrays.asList(cuisine))) {
                    filteredRestaurants.add(r);
                }
            }
        }
    }
    //puts restaurant in the selected list by name
    public static void selectRestaurant(String name) {
        for(Restaurant r : restaurantArrayList) {
            if(r.getName().equals(name)) {
                selectedRestaurants.add(r);
            }
        }
    }
    //removes restaurant from the selected list by name
    public static void removeRestaurant(String name) {
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
    //returns restaurant by name
    public static Restaurant getRestaurantObject(String name) {
        for(Restaurant r : restaurantArrayList) {
            if(r.getName().equals(name)) {
                return r;
            }
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
