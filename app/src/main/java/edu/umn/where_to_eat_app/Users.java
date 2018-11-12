package edu.umn.where_to_eat_app;

import android.content.Context;
import java.util.HashMap;

public class Users {

    private static java.util.Map<String, String> users = new HashMap<>();

    public static final int OK = 1;
    public static final int USER_TAKEN = -1;
    public static final int USER_BLANK = -2;
    public static final int PASS_BLANK = -3;
    public static final int BOTH_BLANK = -4;

    private static String currentUser = null;

    public Users () {
        users.put("Ryan",       "01234");
        users.put("Alex",       "02468");
        users.put("Abdirahman", "qwert");
        users.put("Dylan",      "69420");
        users.put("Nick",       "password");
    }

    public static int createAccount(String username, String password) {
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
