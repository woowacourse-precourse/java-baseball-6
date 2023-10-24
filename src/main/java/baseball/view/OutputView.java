package baseball.view;

import baseball.dto.BaseBallResult;

public class OutputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void printResultMessage(BaseBallResult result) {
        if (result.isNothing()) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        if (result.getBallCnt() == 0) {
            System.out.print(result.getStrikeCnt() + STRIKE_MESSAGE);
        } else {
            System.out.print(result.getBallCnt() + BALL_MESSAGE);
            if (result.getStrikeCnt() != 0) {
                System.out.print(" " + result.getStrikeCnt() + STRIKE_MESSAGE);
            }
        }
        System.out.println();
    }

    public static void printContinue() {
        System.out.println(GAME_OVER_MESSAGE);
        System.out.println(CONTINUE_MESSAGE);
    }
}
