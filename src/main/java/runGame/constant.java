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
    public static int ANSWER_SIZE = 3; // 숫자 야구 정답 크기
    public static int START_RANGE = 1; // 난수 생성 시작 부분
    public static int END_RANGE = 9; //  난수 생성 끝 부분

    // 게임 시작
    public static String START_GAME = "숫자 야구 게임을 시작합니다."; // 게임 시작 멘트
    public static String INPUT_NUMBER = "숫자를 입력해주세요 : "; // 게임 시작 시 유저 입력 멘트


    // 게임 판단
    public static int SUCCESS_STRIKE = 3; // 성공한 스트라이크 수
    public static String SUCCESS = SUCCESS_STRIKE + "스트라이크"; // 성공 출력
    public static String NOTHING = "낫싱"; // 아무것도 겹치지 않았을 때
    public static String BALL = "볼 "; // 숫자는 같지만 자릿 수가 다를 때
    public static String STRIKE = "스트라이크"; // 숫자와 자릿 수 둘 다 같을 때


    // 게임 종료
    public static String GAME_OVER = SUCCESS_STRIKE + "개의 숫자를 모두 맞히셨습니다! 게임 종료"; // 종료 멘트
    public static String RESTART_NUMBER = "1"; // 재시작 숫자
    public static String EXIT_NUMBER = "2"; // 종료 숫자
    public static String RESTART_GAEM = "게임을 새로 시작하려면 " + RESTART_NUMBER
            + ", 종료하려면 " + EXIT_NUMBER + "를 입력하세요."; // 게임 재시작 혹은 종료할 지 정하는 멘트

}
