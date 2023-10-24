package baseball;

public class Application {
    private static final String WELCOME_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MSG = "숫자를 입력해주세요 : ";
    private static final String BALL_MSG = "볼";
    private static final String STRIKE_MSG = "스트라이크";
    private static final String NOTHING_MSG = "낫싱";
    private static final String END_MSG = "3스트라이크\n" +
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CONTINUE_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static void main(String[] args) {
        // 게임 시작
        println(WELCOME_MSG);
    }

    private static void println(String msg){
        System.out.println(msg);
    }
}
