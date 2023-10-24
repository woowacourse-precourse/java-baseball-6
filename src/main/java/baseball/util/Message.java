package baseball.util;

import static baseball.domain.enums.Constants.NUM_SIZE;

public class Message {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    public void printStartMsg() {
        System.out.println(START_MESSAGE);
    }

    public void printInputMsg(String num) {
        System.out.println(INPUT_MESSAGE + num);
    }

    public void printScore(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING);
        } else if (strikeCount == 0) {
            System.out.println(ballCount + BALL);
        } else if (ballCount == 0) {
            System.out.println(strikeCount + STRIKE);
        } else {
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
        }
    }

    public void printEndMsg() {
        System.out.println(NUM_SIZE.getValue() + END_MESSAGE);
    }

    public void printRetryMsg(int answer) {
        System.out.println(RETRY_MESSAGE + answer);
    }

}
