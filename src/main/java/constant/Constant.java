package constant;

public class Constant {
    //숫자 자리수
    public static int NUM_DIGITS = 3;

    //숫자 범위 제한
    public static int MIN_NUM = 1;
    public static int MAX_NUM = 9;


    //코멘트
    public static String START_MSG = "숫자 야구 게임을 시작합니다.";
    public static String ASK_RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static String ASK_INPUT_NUMBER_MSG = "숫자를 입력해주세요 : ";
    public static String SUCCESS_MSG = "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    //게임 실행 여부 결정
    public static char RESTART_GAME_NUMBER = '1';
    public static char EXIT_GAME_NUMBER = '2';

    //게임 결과
    public static String NOTHING_MSG = "낫싱";
    public static String BALL = "볼";
    public static String STRIKE = "스트라이크";

    //예외상황
    public static String LENGTH_EXCEPTION_MSG = "입력값의 길이가 유효하지 않습니다.";
    public static String RANGE_EXCEPTION_MSG = "유효하지 않은 숫자 범위입니다.";
    public static String DUPLI_EXCEPTION_MSG = "중복된 값이 존재합니다.";
}