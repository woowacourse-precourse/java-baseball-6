package baseball.constant;

public class Const {

    //view message
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_RESET_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    //validation message
    public final static String INPUT_ERROR_MESSAGE = "입력은 1과 2 둘 중 하나 여야 합니다";
    public final static String NOT_NUMERIC_ERROR_MESSAGE = "입력 값이 숫자 여야 합니다.";


    public final static String INVALID_DIGIT_NUMBER_ERROR_MESSAGE = "입력 값은 세 자리 어야 합니다";
    public final static String DUPLICATED_NUMBER_ERROR_MESSAGE = "중복된 숫자가 있습니다";
    public final static String OUT_OF_RANGE_ERROR_MESSAGE = "숫자는 1과 9사이 어야 합니다";


    //number
    public final static int MAX_NUMBER_SIZE = 3;
    public final static int MAX_NUMBER_RANGE = 9;
    public final static int MIN_NUMBER_RANGE = 1;

    public final static int RESTART_GAME = 1;

}
