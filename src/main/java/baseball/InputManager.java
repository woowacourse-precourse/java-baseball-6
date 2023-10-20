package baseball;

import java.util.Scanner;

public class InputManager {

    public String getGuessNumbers() {

        Scanner scanner = new Scanner(System.in);

        String inputValue = scanner.next();

        return inputValue;

    }

}
