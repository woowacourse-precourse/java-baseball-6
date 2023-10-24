package baseball.view;

import baseball.dto.StrikeBallCount;

public class OutputView {

    private static final String ZERO_HIT_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int SELECTION_COUNT = 3;

    // 유저가 제시한 번호에 따른 결과 메시지 출력
    public static boolean generateResultMessage(StrikeBallCount strikeBallCount) {

        int strikeCount = strikeBallCount.getStrikeCount();

        int ballCount = strikeBallCount.getBallCount();

        if (strikeCount == SELECTION_COUNT) {

            System.out.println(strikeBallCount.getStrikeCount() + STRIKE_MESSAGE);

            System.out.println(THREE_STRIKE_MESSAGE);

            return true;

        } else if (strikeCount == 0 && ballCount == 0) {

            System.out.println(ZERO_HIT_MESSAGE);

        } else if (strikeCount == 0) {

            System.out.println(strikeBallCount.getBallCount() + BALL_MESSAGE);

        } else if (ballCount == 0) {

            System.out.println(strikeBallCount.getStrikeCount() + STRIKE_MESSAGE);

        } else {

            System.out.println(strikeBallCount.toString());

        }

        return false;
    }

}
