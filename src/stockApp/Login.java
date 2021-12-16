package stockApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    ArrayList<User> users;

    public static void main(String[] args) {
        Login login = new Login();
        login.users = login.getUsers();
        while (true)
            login.checkDetails();
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Batman", "password", "Bruce", "Wayne", 001, true));
        users.add(new User("Superman", "password", "Clark", "Kent", 002, false));
        users.add(new User("Wonder Woman", "password", "Diana", "Prince", 003, false));
        users.add(new User("Flash", "password", "Barry", "Allen", 004, false));
        users.add(new User("Aquaman", "password", "Arthur", "Curry", 005, false));
        users.add(new User("Cyborg", "password", "Vic", "Stone", 006, true));
        users.add(new User("Green Lantern", "password", "Hal", "Jordan", 007, false));
        return users;
    }

    public void checkDetails() {
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please Enter Your Username: ");
        System.out.println(ANSI_RED + "------------------------------");
        String username = new Scanner(System.in).nextLine();
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please Enter Your Password: ");
        System.out.println(ANSI_RED + "------------------------------");
        String password = new Scanner(System.in).nextLine();
        for (User u : users) {
            if (username.equals(u.username)) {
                if (password.equals(u.password)) {
                    MainMenu mm = new MainMenu();
                    mm.getInfo();
                    break;
                }
            }
        }

        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Incorrect Username and/or Password, Please Try Again");
        System.out.println(ANSI_RED + "------------------------------");
    }
}
