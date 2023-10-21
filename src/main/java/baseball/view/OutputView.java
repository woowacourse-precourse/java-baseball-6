package baseball.view;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NONE_MESSAGE = "낫싱";


    public static void baseballGameStart(){
        System.out.println(START_MESSAGE);
    }

    public static void detailMessage(int strike, int ball){
        isZeroStrikeAndBall(strike, ball);
        isZeroStrike(strike, ball);
        isZeroball(strike, ball);
        isNotZeroStrikeAndBall(strike,ball);
    }
}
