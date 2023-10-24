package baseball.view;

import baseball.model.GameRestartOption;

public class OutputView {
    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";
    public static final String ANSWER_CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String END_GAME_MESSAGE = "게임 종료";


    public static void startGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void numberInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public static void restartGameMessage() {
        String restart = GameRestartOption.RESTART.getValue();
        String quit = GameRestartOption.QUIT.getValue();

        System.out.printf(RESTART_GAME_MESSAGE, restart, quit);
    }

    public static void answeredCorrectMessage() {
        System.out.println(ANSWER_CORRECT_MESSAGE);
    }

    public static void endGameMessage() {
        System.out.println(END_GAME_MESSAGE);
    }

    public static void gameResultMessage(String message) {
        System.out.println(message);
    }
}