package baseball.utils;

import baseball.domain.Game;
import baseball.domain.status.HintStatus;

public class PrintUtils {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_PLAYER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String SPACE = " ";

    private PrintUtils() {
    }

    public static void printRestartOrFinishGameMessage() {
        print(RESTART_MESSAGE);
    }

    public static void printResult(Game game) {
        print(selectResultMessage(game.getStrike(), game.getBall()));
    }

    private static String selectResultMessage(int strike, int ball) {
        if (strike == Game.ALL_STRIKE) {
            return getHintMessage(strike, HintStatus.STRIKE);
        }
        if (ball == Game.ALL_STRIKE) {
            return getHintMessage(ball, HintStatus.BALL);
        }
        if (strike > Game.NO_STRIKE && ball > Game.NO_BALL) {
            return getHintMessage(ball, HintStatus.BALL) + SPACE + getHintMessage(strike, HintStatus.STRIKE);
        }
        if (strike == Game.NO_STRIKE && ball > Game.NO_BALL) {
            return getHintMessage(ball, HintStatus.BALL);
        }
        if (strike > Game.NO_STRIKE && ball == Game.NO_BALL) {
            return getHintMessage(strike, HintStatus.STRIKE);
        }
        return HintStatus.NOTHING.getHint();
    }

    private static String getHintMessage(int count, HintStatus hint) {
        return count + hint.getHint();
    }

    public static void printInputUserNumber() {
        printWithOutNewline(INPUT_PLAYER_NUMBER_MESSAGE);
    }

    public static void printEndGame() {
        print(END_MESSAGE);
    }

    public static void printStartGame() {
        print(START_MESSAGE);
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void printWithOutNewline(String message) {
        System.out.print(message);
    }

}
