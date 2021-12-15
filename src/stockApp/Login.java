package stockApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

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
        users.add(new User("The Flash", "password", "Barry", "Allen", 004, false));
        users.add(new User("Aquaman", "password", "Arthur", "Curry", 005, false));
        users.add(new User("Cyborg", "password", "Vic", "Stone", 006, true));
        users.add(new User("Green Lantern", "password", "Hal", "Jordan", 007, false));
        return users;
    }

    public void checkDetails() {
        System.out.println("Please Enter Your Username: ");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Please Enter Your Password: ");
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

        System.out.println("Incorrect Username and/or Password, Please Try Again");
    }
}
