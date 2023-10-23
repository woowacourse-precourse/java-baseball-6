package baseball.view;

import static baseball.utils.BaseballConstantUtils.BASEBALL_NUMBERS_LENGTH;
import static baseball.utils.BaseballConstantUtils.GAME_OVER;
import static baseball.utils.BaseballConstantUtils.GAME_RESTART;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String ANSWER_MESSAGE = BASEBALL_NUMBERS_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE =
            "게임을 새로 시작하려면 " + GAME_RESTART + ", 종료하려면 " + GAME_OVER + "를 입력하세요.";

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printEnterNumber() {
        System.out.print(ENTER_NUMBER_MESSAGE);
    }

    public static void printBallStrikeResult(int ballCount, int strikeCount) {
        if (ballCount != 0) {
            System.out.print(ballCount + BALL);
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + STRIKE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(NOTHING);
        }
        System.out.println();
    }

    public static void printAnswer() {
        System.out.println(ANSWER_MESSAGE);
        System.out.println(GAME_RESTART_MESSAGE);
    }
}