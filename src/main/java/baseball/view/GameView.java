package baseball.view;

public class GameView {
    private static void displayMessage(String message) {
        System.out.print(message);
    }

    public static void displayGameStartMessage() {
        displayMessage("숫자 야구 게임을 시작합니다.\n");
    }

    public static void displayUserInputPrompt() {
        displayMessage("숫자를 입력해주세요 : ");
    }

    public static void displayGuessResult(String result) {
        displayMessage(result + '\n');
    }
}
