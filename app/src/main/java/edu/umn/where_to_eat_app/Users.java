package edu.umn.where_to_eat_app;

import android.content.Context;
import java.util.HashMap;

public class Users {

    private static HashMap<String, String[]> users = new HashMap<>();

    private static String currentUser = null;

    public Users () {
        users.put("???", new String[]{"???", "???"});
        users.put("clar1513", new String[]{"01234", "Ryan"});
        users.put("gille407", new String[]{"02468", "Alex"});
        users.put("hajix007", new String[]{"qwert", "Abdirahman"});
        users.put("tey00002", new String[]{"69420", "Dylan"});
        users.put("tuttl065", new String[]{"password", "Nick"});
    }

    public static String createAccount(String username, String password, String name) {
        String ret = "Error:\n";
        if(username.equals(""))         { ret += "\nUsername required."; }
        if(name.equals(""))             { ret += "\nName required."; }
        if(password.equals(""))         { ret += "\nPassword required."; }
        if(users.containsKey(username)) { ret += "\nUsername taken."; }
        if(ret.equals("Error:\n")) {
            users.put(username,new String[]{password, name});
            return "OK";
        } else {
            return ret;
        }
    }

    public static boolean checkCredentials(String username, String password) {
        if(!users.containsKey(username)) { return false; }
        if(users.get(username)[0].equals(password)) { return true; }
        return false;
    }

    public static final String getCurrentUser() { return currentUser; }
    public static final String getCurrentName() { return users.get(currentUser)[1]; }
    public static void setCurrentUser(String s) { currentUser = s; }
}
