package baseball.util;

    import baseball.constant.MessageConst;

public class MessageUtil {
    private static final String START_MESSAGE = MessageConst.START_MESSAGE;
    private static final String INPUT_NUMBER_MESSAGE = MessageConst.INPUT_NUMBER_MESSAGE;
    private static final String SUCCESS_GAME_MESSAGE =  MessageConst.SUCCESS_GAME_MESSAGE;
    private static final String GAME_CONTROL_MESSAGE = MessageConst.GAME_CONTROL_MESSAGE;
    private static final String BALL_MESSAGE = MessageConst.BALL_MESSAGE;
    private static final String STRIKE_MESSAGE = MessageConst.STRIKE_MESSAGE;
    private static final String NOTHING_MESSAGE = MessageConst.NOTHING_MESSAGE;
    private static final String INVALID_INPUT_DUPLICATE_NUMBER_MESSAGE = MessageConst.INVALID_INPUT_DUPLICATE_NUMBER_MESSAGE;
    private static final String INVALID_INPUT_LENGTH_MESSAGE = MessageConst.INVALID_INPUT_LENGTH_MESSAGE;
    private static final String INVALID_INPUT_IS_NUMERIC_MESSAGE = MessageConst.INVALID_INPUT_IS_NUMERIC_MESSAGE;
    private static final String INVALID_INPUT_RANGE_MESSAGE = MessageConst.INVALID_INPUT_RANGE_MESSAGE;
    private static final String INVALID_RESTART_STOP_VALUE_MESSAGE = MessageConst.INVALID_RESTART_STOP_VALUE_MESSAGE;


    public MessageUtil() {}

    /*
     * 게임 시작시 나오는 메시지
     */
    public void initGame() {
        // TODO:
        System.out.println(START_MESSAGE);
    }

    /*
     * 사용자에게 입력을 받기 위해 출력되는 메시지
     */
    public void inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    /*
     * 스트라이크 개수를 전부 맞힐 경우 출력
     */
    public void printSuccessGame() {
        System.out.println(SUCCESS_GAME_MESSAGE);
        System.out.println(GAME_CONTROL_MESSAGE);
    }

    /*
     * 사용자에게 입력 받은 이후 볼,스트라이크 개수, 낫싱인지 출력
     */
    public void printResultGame(int countBall, int countStrike) {
        StringBuilder result = new StringBuilder("");

        if(countBall == 0 && countStrike == 0) {
            result.append(NOTHING_MESSAGE);
        }
        if (countBall != 0) {
            result.append(countBall)
                    .append(BALL_MESSAGE)
                    .append(" ");
        }
        if (countStrike != 0) {
            result.append(countStrike)
                    .append(STRIKE_MESSAGE);
        }

        System.out.println(result);
    }

    /*
     * 입력받은 값 중 중복 숫자가 있을경우 메시지 출력
     */
    public void printDuplicatedInputNumber() {
        System.out.println(INVALID_INPUT_DUPLICATE_NUMBER_MESSAGE);
    }

    /*
     * 입력받은 값이 EXPECTED_INPUT_LENGTH 이 아닐 경우 메시지 출력
     */
    public void printInvalidNumber() {
        System.out.println(INVALID_INPUT_LENGTH_MESSAGE);
    }

    /*
     * 입력받은 값 중 숫자만 포함되지 않을 경우 메시지 출력
     */
    public void printInvalidNumeric() {
        System.out.println(INVALID_INPUT_IS_NUMERIC_MESSAGE);
    }

    /*
     * 1부터 9사이 값이 입력되지 않았을 경우 메시지 출력
     */
    public void printInvalidRange() {
        System.out.println(INVALID_INPUT_RANGE_MESSAGE);
    }

    /*
     * 게임 종료 이후 1,2 값이 아닌 경우 메시지 출력
     */
    public void printInvalidGameControlInput() {
        System.out.println(INVALID_RESTART_STOP_VALUE_MESSAGE);
    }
}
