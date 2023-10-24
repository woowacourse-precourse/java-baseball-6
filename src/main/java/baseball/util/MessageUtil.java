package baseball.util;

import baseball.constant.MessageConst;

public class MessageUtil {
    private static final String startMessage = MessageConst.START_MESSAGE;
    private static final String inputNumberMessage = MessageConst.INPUT_NUMBER_MESSAGE;
    private static final String successGameMessage = MessageConst.SUCCESS_GAME_MESSAGE;
    private static final String gameControlMessage = MessageConst.GAME_CONTROL_MESSAGE;
    private static final String ballMessage = MessageConst.BALL_MESSAGE;
    private static final String strikeMessage = MessageConst.STRIKE_MESSAGE;
    private static final String nothingMessage = MessageConst.NOTHING_MESSAGE;
    private static final String invalidInputDuplicateNumberMessage = MessageConst.INVALID_INPUT_DUPLICATE_NUMBER_MESSAGE;
    private static final String invalidInputLengthMessage = MessageConst.INVALID_INPUT_LENGTH_MESSAGE;
    private static final String invalidInputIsNumericMessage = MessageConst.INVALID_INPUT_IS_NUMERIC_MESSAGE;
    private static final String invalidInputRangeMessage = MessageConst.INVALID_INPUT_RANGE_MESSAGE;
    private static final String invalidRestartStopValueMessage = MessageConst.INVALID_RESTART_STOP_VALUE_MESSAGE;

    private MessageUtil() {
    }

    /*
     * 게임 시작시 나오는 메시지
     */
    public static void initGame() {
        // TODO:
        System.out.println(startMessage);
    }

    /*
     * 사용자에게 입력을 받기 위해 출력되는 메시지
     */
    public static void inputNumber() {
        System.out.print(inputNumberMessage);
    }

    /*
     * 스트라이크 개수를 전부 맞힐 경우 출력
     */
    public static void printSuccessGame() {
        System.out.println(successGameMessage);
        System.out.println(gameControlMessage);
    }

    /*
     * 사용자에게 입력 받은 이후 볼,스트라이크 개수, 낫싱인지 출력
     */
    public static void printResultGame(int countBall, int countStrike) {
        StringBuilder result = new StringBuilder("");

        if (countBall == 0 && countStrike == 0) {
            result.append(nothingMessage);
        }
        if (countBall != 0) {
            result.append(countBall)
                    .append(ballMessage)
                    .append(" ");
        }
        if (countStrike != 0) {
            result.append(countStrike)
                    .append(strikeMessage);
        }

        System.out.println(result);
    }

    /*
     * 입력받은 값 중 중복 숫자가 있을경우 메시지 출력
     */
    public static void printDuplicatedInputNumber() {
        System.out.println(invalidInputDuplicateNumberMessage);
    }

    /*
     * 입력받은 값이 EXPECTED_INPUT_LENGTH 이 아닐 경우 메시지 출력
     */
    public static void printInvalidNumber() {
        System.out.println(invalidInputLengthMessage);
    }

    /*
     * 입력받은 값 중 숫자만 포함되지 않을 경우 메시지 출력
     */
    public static void printInvalidNumeric() {
        System.out.println(invalidInputIsNumericMessage);
    }

    /*
     * NumberConst.MIN_INPUT_VALUE 부터 NumberConst.MAX_INPUT_VALUE 사이 값이 입력되지 않았을 경우 메시지 출력
     */
    public static void printInvalidRange() {
        System.out.println(invalidInputRangeMessage);
    }

    /*
     * 게임 종료 이후 NumberConst.RESTART_NUMBER, NumberConst.STOP_NUMBER 값이 아닌 경우 메시지 출력
     */
    public static void printInvalidGameControlInput() {
        System.out.println(invalidRestartStopValueMessage);
    }
}
