package baseball.output;

public class GameOutput {
    private static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayGameStartMessage() {
        displayMessage("숫자 야구 게임을 시작합니다.");
    }
}
