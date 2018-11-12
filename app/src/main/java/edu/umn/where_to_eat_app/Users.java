package edu.umn.where_to_eat_app;

import java.util.HashMap;

public class Users {

    private static HashMap<String, String> users = new HashMap<>();

    private static String currentUser = null;

    public Users () {
        users.put("Ryan", "01234");
        users.put("Alex", "02468");
        users.put("Abdirahman", "abcde");
        users.put("Dylan", "69420");
        users.put("Nick", "password");
    }

    public static int createAccount(String username, String password) {
        int OK = 1;
        int USER_TAKEN = -1;
        int USER_BLANK = -2;
        int PASS_BLANK = -3;
        int BOTH_BLANK = -4;
        if(username.equals("") && password.equals("")) { return BOTH_BLANK; }
        if(username.equals("")) { return USER_BLANK; }
        if(password.equals("")) { return PASS_BLANK; }
        if(users.containsKey(username)) { return USER_TAKEN; }
        else {
            users.put(username,password);
        }
        return OK;
    }

    public static boolean checkCredentials(String username, String password) {
        if(!users.containsKey(username)) { return false; }
        if(users.get(username).equals(password)) { return true; }
        return false;
    }

    public static final String getCurrentUser() { return currentUser; }
    public static void setCurrentUser(String s) { currentUser = s; }
}
