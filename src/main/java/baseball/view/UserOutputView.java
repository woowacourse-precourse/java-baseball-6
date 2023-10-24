package baseball.view;

import baseball.util.common.Common;
import baseball.util.dto.Baseball;

public class UserOutputView {
    private static final String HELLO_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String CORRECT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printHelloGame() {
        System.out.println(HELLO_GAME);
    }

    public void printRestartGame() {
        System.out.println(RESTART_GAME);
    }

    public void printSuccessAnswer() {
        System.out.println(Common.NUM_LENGTH + "스트라이크");
        System.out.println(CORRECT_ANSWER);
    }

    public void printMiddleWrong(Baseball baseball) {
        if (baseball.getBallNumber() != 0) {
            System.out.print(baseball.getBallNumber() + "볼 ");
        }
        if (baseball.getStrikeNumber() != 0) {
            System.out.print(baseball.getStrikeNumber() + "스트라이크");
        }
        System.out.println();
    }

    public void printTotallyWrong() {
        System.out.println("낫싱");
    }
}
