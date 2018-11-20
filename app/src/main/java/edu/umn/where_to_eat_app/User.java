package edu.umn.where_to_eat_app;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String nickname;
    private int imageSrc;

    private ArrayList<Restaurant> favoriteRestaurants = new ArrayList<>();
    private ArrayList<String> friendsList = new ArrayList<>();

    public User(String username, String password, String nickname, int imageSrc) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.imageSrc = imageSrc;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getNickname() { return nickname; }
    public int getImageSrc() { return imageSrc; }

    public void addFavoriteRestaurant(String restaurant) {
        boolean exists = false;
        for(Restaurant r : favoriteRestaurants) {
            if(r.getName().equals(restaurant)) {
                exists = true;
            }
        }
        if(!exists) {
            favoriteRestaurants.add(Restaurants.getRestaurantObject(restaurant));
        }
    }
    public void removeFavoriteRestaurant(String restaurant) {
        Restaurant remove = null;
        for(Restaurant r : favoriteRestaurants) {
            if (r.getName().equals(restaurant)) {
                remove = r;
            }
        }
        favoriteRestaurants.remove(remove);
    }
    public final ArrayList<Restaurant> getFavoriteRestaurants() { return favoriteRestaurants; }

    public void addFriend(String username) {
        if(!friendsList.contains(username)) {
            friendsList.add(username);
        }
    }
    public void removeFriend(String username) {
        if (friendsList.contains(username)) {
            friendsList.remove(username);
        }
    }
    public final ArrayList<String> getFriendsList() { return friendsList; }

}
