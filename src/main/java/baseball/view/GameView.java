package baseball.view;

public class GameView {
    public static void displayGameStartMessage() {
        displayMessage("숫자 야구 게임을 시작합니다.\n");
    }

    public static void displayUserInputPrompt() {
        displayMessage("숫자를 입력해주세요 : ");
    }

    public static void displayGuessResult(String result) {
        displayMessage(result + '\n');
    }

    public static void displayCorrectGuessMessage() {
        displayMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    public static void displayGameRestartPrompt() {
        displayMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }

    public static void displayGameEndMessage() {
        displayMessage("게임을 종료합니다.\n");
    }

    private static void displayMessage(String message) {
        System.out.print(message);
    }
}
