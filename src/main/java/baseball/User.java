package baseball;

import baseball.view.Console;
import java.util.List;

public class User {

    private static Machine machine;

    public static void obtainMachine(Machine obtainedMachine) {
        machine = obtainedMachine;
    }


    public static void startGame() {

        validateMachineExistence();

        machine.playGame();

    }

    public static List<Integer> input3DigitNumber() {
        return Console.input3DigitNumber();
    }

    public static String inputRestartOrTerminate() {
        return Console.inputRestartOrTerminate();
    }

    private static void validateMachineExistence() {
        if (machine == null) {
            throw new IllegalArgumentException();
        }
    }
}
