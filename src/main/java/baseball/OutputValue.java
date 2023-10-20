package baseball;

public class OutputValue {

    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String THREE_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    OutputValue() {}

    public void resultMessage(int strike, int ball) {
        StringBuilder sb = new StringBuilder();

        if(strike == 0 && ball == 0) {
            sb.append(NOTHING_MESSAGE);
        }

        if(ball > 0) {
            sb.append(ball).append(BALL_MESSAGE);
        }

        if(strike > 0) {
            if(sb.length() != 0) sb.append(" ");
            sb.append(strike).append(STRIKE_MESSAGE);
        }

        System.out.println(sb);

        if(strike == 3) {
            System.out.println(THREE_STRIKE);
        }
    }

}
