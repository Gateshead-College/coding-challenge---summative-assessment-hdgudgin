package stockApp;

import java.util.Scanner;

public class AccountSettingsMenu {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void accountSettingsMenu() {
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please select an option:");
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println(ANSI_GREEN + "1 " + ANSI_RESET + " - Change Password");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {

            case 1:
                changePassword();
                break;
        }
    }

    private void changePassword() {
        System.out.println(ANSI_RED + "------------------------------");
        System.out.println("Please enter the username for the account whose password you'd like to change");
        System.out.println(ANSI_RED + "------------------------------");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());

    }
}
