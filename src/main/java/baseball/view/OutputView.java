package baseball.view;

import baseball.dto.StrikeBallCount;

public class OutputView {

    private static final String ZERO_HIT_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public static boolean generateResultMessage(StrikeBallCount strikeBallCount) {

        if (strikeBallCount.getStrikeCount() == 3) {

            System.out.println(strikeBallCount.getStrikeCount() + STRIKE_MESSAGE);

            System.out.println(THREE_STRIKE_MESSAGE);
            
            return true;

        } else if (strikeBallCount.getStrikeCount() == 0 && strikeBallCount.getBallCount() == 0) {

            System.out.println(ZERO_HIT_MESSAGE);

        } else if (strikeBallCount.getStrikeCount() == 0) {

            System.out.println(strikeBallCount.getBallCount() + BALL_MESSAGE);

        } else if (strikeBallCount.getBallCount() == 0) {

            System.out.println(strikeBallCount.getStrikeCount() + STRIKE_MESSAGE);

        } else {

            System.out.println(strikeBallCount.toString());

        }

        return false;
    }

}
