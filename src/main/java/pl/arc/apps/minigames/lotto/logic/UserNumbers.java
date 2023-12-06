package pl.arc.apps.minigames.lotto.logic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserNumbers {

    private Set<Integer> userNumbers;

    public UserNumbers() {
        this.userNumbers = new HashSet<>();
    }

    public void enterUserNumbers(Scanner scanner, int min, int max, int count) {
        System.out.println("Enter " + count + " numbers from " + min + " to " + max + ":");

        while (userNumbers.size() < count) {
            System.out.print("Enter number: ");
            int number = scanner.nextInt();

            if (isInvalidNumber(number, min, max)) {
                System.out.println("Invalid number. Please try again.");
                continue;
            }
            userNumbers.add(number);
        }
    }

    public Set<Integer> getUserNumbers() {
        return new HashSet<>(userNumbers);
    }

    private boolean isInvalidNumber(int number, int min, int max) {
        return number < min || number > max || userNumbers.contains(number);
    }
}