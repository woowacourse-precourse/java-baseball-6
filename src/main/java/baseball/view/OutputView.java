package baseball.view;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NONE_MESSAGE = "낫싱";
    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void baseballGameStart(){
        System.out.println(START_MESSAGE);
    }

    public static void detailMessage(int strike, int ball){
        isZeroStrikeAndBall(strike, ball);
        isZeroStrike(strike, ball);
        isZeroBall(strike, ball);
        isNotZeroStrikeAndBall(strike,ball);
    }

    public static void isZeroStrikeAndBall(int strike, int ball) {
        if(strike ==0 && ball == 0){
            System.out.println(NONE_MESSAGE);
        }
    }

    public static void isZeroStrike(int strike, int ball) {
        if(strike ==0 && ball != 0){
            System.out.println(ball+BALL_MESSAGE);
        }
    }

    public static void isZeroBall(int strike, int ball) {
        if(strike != 0 && ball == 0){
            System.out.println(strike+STRIKE_MESSAGE);
        }
    }

    public static void isNotZeroStrikeAndBall(int strike, int ball) {
        if(strike != 0 && ball != 0){
            System.out.println(ball+BALL_MESSAGE+" "+strike+STRIKE_MESSAGE);
        }
    }

    public static void threeStrikeMessage(){
        System.out.println(THREE_STRIKE_MESSAGE);
    }
}
