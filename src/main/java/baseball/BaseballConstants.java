package baseball;


public abstract class BaseballConstants {
    //GameController
    public static final int THREE_COUNT = 3;
    public static final int ZERO_COUNT = 0;
    public static final int MAX_LENGTH_USER_NUMBER_SIZE = 3;

    //GameSupervisor
    public static final String STRIKE_MESSAGE = "3스트라이크";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String STRING_BALL = "볼";
    public static final String STRING_STRIKE = "스트라이크";

    //User
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    //InputValueValidator
    public static final int VALID_NUMBER_LENGTH = 3;
    public static final char MIN_DIGIT = '1';
    public static final char MAX_DIGIT = '9';

    //NumbersGenerator
    public static final int NUM_MAX_SIZE = 3;
    public static final int PICK_MIN_NUM = 1;
    public static final int PICK_MAX_NUM = 9;

    //BaseballGame
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다";
    public static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    public static final String RESTART_CHOICE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static final String GAME_END_MESSAGE = "게임 종료";
    public static final String END_CHOICE = "2";
}
