package baseball.view;

import baseball.dto.StrikeBallCount;

public class OutputView {

    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int SELECTION_COUNT = 3;

    // 유저가 제시한 번호에 따른 결과 메시지 출력
    public static boolean generateResultMessage(StrikeBallCount strikeBallCount) {

        System.out.println(strikeBallCount.countPrint());

        if (strikeBallCount.getStrikeCount() == SELECTION_COUNT) {

            System.out.println(THREE_STRIKE_MESSAGE);

            return true;

        }

        return false;
    }

}