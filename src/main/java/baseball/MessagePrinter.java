package baseball;

public abstract class MessagePrinter {
    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public final static String INPUT_YOUR_NUMBER = "숫자를 입력해 주세요 : ";
    public final static String STRIKE_BALL_COUNT = "%d볼 %d스트라이크";
    public final static String NOTHING = "낫싱";
    public final static String GAME_CLEAR_MESSAGE =
            "3스트라이크\n" +
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printResultMessage(BallCount ballCount) {
        int strike = ballCount.strike();
        int ball = ballCount.ball();

        if(strike == 0 && ball == 0){
            System.out.println(NOTHING);
        } else if (strike == 3) {
            System.out.println(GAME_CLEAR_MESSAGE);
        } else {
            System.out.println(String.format(STRIKE_BALL_COUNT, ball, strike));
        }
    }

}
