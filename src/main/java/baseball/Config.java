package baseball;

public class Config {
    // NUMBER CONFIG
    public final static Integer INPUT_NUMBER_LENGTH = 3;
    public final static Integer RESTART_NUMBER_LENGTH = 1;
    public final static Integer RANDOM_NUMBER_START = 1;
    public final static Integer RANDOM_NUMBER_END = 9;
    public final static String SUCCESS = "3스트라이크";

    // NOTIFY MESSAGE CONFIG
    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public final static String GAME_END_MESSAGE = INPUT_NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 :";
    public final static String RESTART_INPUT_NUMBER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    // ERROR MESSAGE CONFIG
    public final static String INPUT_LENGTH_ERROR_MESSAGE = "입력된 숫자는 "+INPUT_NUMBER_LENGTH+"자리여야 합니다.";
    public final static String RESTART_INPUT_LENGTH_ERROR_MESSAGE = "입력된 숫자는 1자리여야 합니다.";
    public final static String RESTART_INPUT_ERROR_MESSAGE = "1 또는 2를 입력해야 합니다.";
    public final static String INPUT_NUMBER_OVERLAP_ERROR_MESSAGE = "서로 다른" + INPUT_NUMBER_LENGTH + "자리를 입력해주세요";
    public final static String INPUT_NUMBER_NUMERIC_ERROR = "입력된 값은 숫자여야 합니다.";
}
