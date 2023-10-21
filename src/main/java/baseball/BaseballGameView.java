package baseball;

public class BaseballGameView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING = "낫싱";
    private static final String FORMAT_BALL_STRIKE = "%d볼 %d스트라이크";
    private static final String FORMAT_BALL = "%d볼";
    private static final String FORMAT_STRIKE = "%d스트라이크";

    public BaseballGameView() {}

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printInputGuideMessage() {
        System.out.print(INPUT_GUIDE_MESSAGE);
    }

    public void printEndMessage(){
        System.out.println(END_MESSAGE);
    }

    public void printRestartMessage(){
        System.out.println(RESTART_MESSAGE);
    }

    public String printBallCount(BallCount ballCount){
        int strike = ballCount.getStrike();
        int ball = ballCount.getBall();
        String resultMessage;

        if(strike > 0 && ball > 0){
            resultMessage = String.format(FORMAT_BALL_STRIKE, ball, strike);
            System.out.println(resultMessage);
            return resultMessage;
        }

        if(strike == 0 && ball > 0){
            resultMessage = String.format(FORMAT_BALL, ball);
            System.out.println(resultMessage);
            return resultMessage;
        }

        if(strike > 0 && ball == 0){
            resultMessage = String.format(FORMAT_STRIKE, strike);
            System.out.println(resultMessage);
            return resultMessage;
        }

        resultMessage = NOTHING;
        System.out.println(resultMessage);
        return resultMessage;
    }
}
