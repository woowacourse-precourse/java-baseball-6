package baseball;

import baseball.view.Console;

public class User {

    private static Machine machine;

    public static void obtainMachine(Machine obtainedMachine) {
        machine = obtainedMachine;
    }


    public static void startGame() {

        validateMachineExistence();

        machine.playGame();

    }

    public static String input3DigitNumber() {
        return Console.input3DigitNumber();
    }

    private static void validateMachineExistence() {
        if (machine == null) {
            throw new IllegalArgumentException();
        }
    }
}
