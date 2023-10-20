package baseball.model;

import java.util.Scanner;

public class UserNumber {
    private final String inputNumber;

    public UserNumber() {
        this.inputNumber = String.valueOf(new Scanner(System.in));
    }

    public String getInputNumber() {
        return this.inputNumber;
    }
}
