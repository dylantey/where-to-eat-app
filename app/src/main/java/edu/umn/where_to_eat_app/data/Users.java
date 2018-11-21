package edu.umn.where_to_eat_app.data;

import java.util.ArrayList;

import edu.umn.where_to_eat_app.R;

public class Users {

    private static ArrayList<User> users = new ArrayList<>();
    private static String currentUser = null;

    public Users () {
        new Restaurants();

        users.clear();
        users.add(new User("???", "???", "???", R.drawable.p1_round_b));
        users.add(new User("clar1513", "01234", "Ryan", R.drawable.profile_ryan));
        users.add(new User("gille407", "02468", "Alex", R.drawable.profile_alex));
        users.add(new User("hajix007", "qwert", "Abdirahman", R.drawable.profile_haji));
        users.add(new User("tey00002", "69420", "Dylan", R.drawable.profile_dylan));
        users.add(new User("tuttl065", "password", "Nick", R.drawable.profile_nick));

        // All group members are friends.
        for(int i = 1; i < users.size(); i++) {
            users.get(i).getFriendsList().clear();
            for(int j = 1; j < users.size(); j++) {
                if(i != j) {
                    users.get(i).addFriend(users.get(j).getUsername());
                }
            }
        }

        getUserObject("tey00002").addFavoriteRestaurant("Buffalo Wild Wings");
        getUserObject("tey00002").addFavoriteRestaurant("Chick-Fil-A");
        getUserObject("tey00002").addFavoriteRestaurant("My Burger");

        getUserObject("hajix007").addFavoriteRestaurant("Haiku");
        getUserObject("hajix007").addFavoriteRestaurant("Ichiddo Ramen");
        getUserObject("hajix007").addFavoriteRestaurant("Chipotle Mexican Grill");

        getUserObject("gille407").addFavoriteRestaurant("Blaze Pizza");
        getUserObject("gille407").addFavoriteRestaurant("Bar Luchador");
        getUserObject("gille407").addFavoriteRestaurant("My Burger");

        getUserObject("tuttl065").addFavoriteRestaurant("McDonald's");
        getUserObject("tuttl065").addFavoriteRestaurant("Chipotle Mexican Grill");
        getUserObject("tuttl065").addFavoriteRestaurant("Blaze Pizza");



    }

    public static String createAccount(String username, String password, String name) {
        boolean exists = false;
        for(User u : users) {
            if(u.getUsername().equals(username)) {
                exists = true;
            }
        }
        String ret = "Error:\n";
        if(username.equals("")) { ret += "\nUsername required."; }
        if(name.equals(""))     { ret += "\nName required."; }
        if(password.equals("")) { ret += "\nPassword required."; }
        if(exists)              { ret += "\nUsername taken."; }
        if(ret.equals("Error:\n")) {
            users.add(new User(username, password, name, 0));
            return "OK";
        } else {
            return ret;
        }
    }

    public static boolean checkCredentials(String username, String password) {
        for(User u : users) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static final String getCurrentUser() { return currentUser; }
    public static final User getCurrentUserObject() {
        for(User u : users) {
            if(u.getUsername().equals(currentUser)) {
                return u;
            }
        }
        return null;
    }
    public static final String getCurrentName() {
        for(User u : users) {
            if(u.getUsername().equals(currentUser)) {
                return u.getNickname();
            }
        }
        return null;
    }
    public static void setCurrentUser(String s) { currentUser = s; }

    public static boolean userExists(String s) {
        for(User u : users) {
            if(u.getUsername().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static User getUserObject(String username) {
        for(User u : users) {
            if(u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public static User getUserByIndex(int idx) { return users.get(idx); }

    public static int indexOf(User user) { return users.indexOf(user); }
}
