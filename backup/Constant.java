package baseball;

public class Constant {

    // 게임 시작 시 사용하는 공 개수 설정 상수
    public static int BALL_COUNT = 3; // 랜덤 생성할 전체 공 개수
    public static int START_COUNT = 1; // 랜덤 시작 숫자
    public static int END_COUNT = 9; // 끝 숫자
    public static int NUMBER_LENGTH = 3; // 숫자 길이, 사용시 객체 0부터 시작


    public static String GAME_START_PRINT = "숫자 야구 게임을 시작합니다.";
    public static String PLZ_INPUT_NUMBER = "숫자를 입력해주세요 :";

    public static String NUMBER_LENGTH_ERROR = "숫자 3자리를 입력해야 합니다.";
    public static String INPUT_NUMBER_ERROR = "숫자 입력을 확인 해주세요. 가능한 숫자는 1 ~ 9 입니다.";


    public static String STRIKES_OUT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료.";
    public static String STRIKES_COUNT = "스트라이크";
    public static String BALLS_COUNT = " 볼";

    public static String NOTHING = "낫싱";
}
