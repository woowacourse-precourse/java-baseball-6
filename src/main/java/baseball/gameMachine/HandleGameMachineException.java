package baseball.gameMachine;

public class HandleGameMachineException {


    public static void askingReGameException(String checkingValue) {
        String regularExpForUserInput = "^[1-2]{1}$";

        //예외처리
        if (!checkingValue.matches(regularExpForUserInput)) {
            throw new IllegalArgumentException();

        }
    }
}
