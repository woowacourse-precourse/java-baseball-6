package baseball.game.printmanager;

import static baseball.game.constant.Constants.BASEBALL_SIZE;

public class OutputManager {

    public static final String ALL_MATCHED_INFO_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printHint(int strike, int ball) {
        if (strike == BASEBALL_SIZE) {
            System.out.println(String.format("%s스트라이크", strike));
            System.out.println(ALL_MATCHED_INFO_MESSAGE);
            return;
        }

        if (strike > 0 && ball > 0) {
            System.out.println(String.format("%s볼 %s스트라이크", ball, strike));
            return;
        }

        if (ball > 0) {
            System.out.println(String.format("%s볼", ball));
            return;
        }

        System.out.println("낫싱");
    }

    public void printEndMessage() {
        System.out.println(ALL_MATCHED_INFO_MESSAGE);
    }
}
