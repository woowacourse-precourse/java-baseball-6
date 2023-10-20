package baseball;

public class User {

    private static Machine machine;

    public static void obtainMachine(Machine obtainedMachine) {
        machine = obtainedMachine;
    }


    public static void startGame() {

        validateMachineExistence();

        machine.playGame();

    }

    private static void validateMachineExistence() {
        if (machine == null) {
            throw new IllegalArgumentException();
        }
    }
}
