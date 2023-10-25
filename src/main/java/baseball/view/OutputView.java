package baseball.view;

import static baseball.logic.BaseballGame.*;

public class OutputView {
    public static void printGameIntroduction() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printScores(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0){
            System.out.println(NOTHING);
            return;
        } else if(ballCount != 0 && strikeCount != 0){
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
            return;
        } else if (ballCount != 0) {
            System.out.println(ballCount + BALL);
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + STRIKE);
        }
    }

}
