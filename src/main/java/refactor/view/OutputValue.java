package refactor.view;

import refactor.dto.Score;

public class OutputValue {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String THREE_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private StringBuilder sb;

    public OutputValue() {}

    public void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public void resultMessage(Score score) {

        sb = new StringBuilder();

        if(score.getStrike() == 0 && score.getBall() == 0)
            sb.append(NOTHING_MESSAGE);

        if(score.getBall() != 0) {
            sb.append(score.getBall()).append(BALL_MESSAGE);
        }

        if(score.getStrike() != 0) {
            spacingCheck();
            sb.append(score.getStrike()).append(STRIKE_MESSAGE);
        }

        System.out.println(sb);

        if(score.getStrike() == 3) {
            System.out.println(THREE_STRIKE);
        }
    }

    private void spacingCheck() {
        if(sb.length() != 0)
            sb.append(" ");
    }

}
