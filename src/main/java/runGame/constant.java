package runGame;

/*
 * 클래스 이름 : constant
 *
 * 버전 정보 : Java 17
 *
 * 최종 수정날짜 : 2023-10-22
 *
 * 작성자 : 문재경
 */
public class constant {

    //초기화
    public static int ANSWER_SIZE = 3;
    public static int START_RANGE = 1;
    public static int END_RANGE = 9;

    // 게임 시작
    public static String START_GAME = "숫자 야구 게임을 시작합니다.";
    public static String INPUT_NUMBER = "숫자를 입력해주세요 : ";


    // 게임 판단
    public static int SUCCESS_STRIKE = 3;
    public static String SUCCESS = SUCCESS_STRIKE + "스트라이크";
    public static String NOTHING = "낫싱";
    public static String BALL = "볼 ";
    public static String STRIKE = "스트라이크";


    // 게임 종료
    public static String GAME_OVER = SUCCESS_STRIKE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String RESTART_NUMBER = "1";
    public static String EXIT_NUMBER = "2";
    public static String RESTART_GAEM = "게임을 새로 시작하려면 " + RESTART_NUMBER + ", 종료하려면 " + EXIT_NUMBER + "를 입력하세요.";

}
