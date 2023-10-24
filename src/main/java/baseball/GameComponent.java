package baseball;

public class GameComponent {

    public static final int DIGIT = 3;
    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final Integer CompleteNumber = 3;
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    public static final String COMPLETE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String randNum = "";
    public static String userNum = "";

    public static int ballCnt = 0;
    public static int strikeCnt = 0;
}
