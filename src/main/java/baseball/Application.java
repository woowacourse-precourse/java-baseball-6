package baseball;

public class Application {
    private static final int GAME_RESTART = 1;

    public static void main(String[] args) {
        ConsoleHandler.showMessage("숫자 야구 게임을 시작합니다.");
        do {
            new BaseballGame().play();
        } while (continueGame());
    }

    private static boolean continueGame() throws IllegalArgumentException {
        String userInput = ConsoleHandler.requestInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

        if (!UserInputValidator.checkValidRestartValue(userInput)) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }

        return Integer.parseInt(userInput) == GAME_RESTART;
    }
}