package baseball.Model;

import baseball.Utils.InputSystem;

public class User {
    private int[] userNumbers;

    public int[] getUserNumbers() {
        userNumbers = InputSystem.inputNumbers();
        return userNumbers;
    }
}
