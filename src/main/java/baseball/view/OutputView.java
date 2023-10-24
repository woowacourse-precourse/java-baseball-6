package baseball.view;

import baseball.domain.PlayerResult;

import baseball.constant.*;

public class OutputView {

    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    public static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    private static final StringBuilder stringbuilder = new StringBuilder();

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void printGameEndMessage() {
        System.out.println(END_GAME_MESSAGE);
        System.out.println(RESTART_GAME_MESSAGE);
    }

    public static void printPlayerResultMessage(PlayerResult playerResult) {
        generateResultMessage(playerResult);
        System.out.println(stringbuilder);
    }

    private static void generateResultMessage(PlayerResult playerResult) {
        initStringBuilder();
        checkBall(playerResult);
        checkStrike(playerResult);
        checkNothing(playerResult);
    }

    private static void checkStrike(PlayerResult playerResult) {
        if (playerResult.getStrike() > 0) {
            stringbuilder.append(playerResult.getStrike()).append(STRIKE);
        }
    }

    private static void checkBall(PlayerResult playerResult) {
        if (playerResult.getBall() > 0) {
            stringbuilder.append(playerResult.getBall()).append(BALL).append(Constant.SPACE);
        }
    }

    private static void checkNothing(PlayerResult playerResult) {
        if (playerResult.getStrike() == 0 && playerResult.getBall() == 0) {
            stringbuilder.append(NOTHING);
        }
    }

    private static void initStringBuilder() {
        stringbuilder.setLength(0);
    }


}
