package baseball.gameMachine;

public class HandleGameMachineException {
    private static final String askingRegame = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. 을 출력한다.";

    public static void handleException(String text, String checkingValue) {
        if (text == askingRegame) {
            askingReGameException(checkingValue);
        }
    }

    private static void askingReGameException(String checkingValue) {
        String regularExpForUserInput = "^[1-2]{1}$";

        //예외처리
        if (!checkingValue.matches(regularExpForUserInput)) {
            throw new IllegalArgumentException();

        }
    }
}
