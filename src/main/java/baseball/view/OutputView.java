package baseball.view;

import static baseball.utils.BaseballConstantUtils.BASEBALL_NUMBERS_LENGTH;
import static baseball.utils.BaseballConstantUtils.GAME_OVER;
import static baseball.utils.BaseballConstantUtils.GAME_RESTART;

/**
 * 숫자야구 게임에 필요한 메시지들을 출력하는 클래스입니다.
 */

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String ANSWER_MESSAGE = BASEBALL_NUMBERS_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE =
            "게임을 새로 시작하려면 " + GAME_RESTART + ", 종료하려면 " + GAME_OVER + "를 입력하세요.";

    /**
     * 프로그램이 시작 됨을 알리는 메시지를 출력합니다.
     */

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 유저에게 숫자야구 값 입력을 요구하는 메시지를 출력합니다.
     */

    public static void printEnterNumber() {
        System.out.print(ENTER_NUMBER_MESSAGE);
    }

    /**
     * 현재 라운드의 볼 개수와 스트라이크 개수 또는 낫싱을 출력합니다.
     *
     * @param ballCount   현재 라운드의 볼카운트
     * @param strikeCount 현재 라운드의 스트라이크 카운트
     */

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

    /**
     * 정답을 맞췄음을 알리고 게임 재시작 여부를 묻는 메시지를 출력합니다.
     */

    public static void printAnswer() {
        System.out.println(ANSWER_MESSAGE);
        System.out.println(GAME_RESTART_MESSAGE);
    }
}