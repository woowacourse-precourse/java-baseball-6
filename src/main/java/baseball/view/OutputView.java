package baseball.view;

import baseball.domain.GameResult;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInsertNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printBaseBallResults(GameResult result) {
        int strikeCount = result.getStrikeCnt();
        int ballCount = result.getBallCnt();

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else {
            if (ballCount != 0) {
                System.out.print(ballCount + "볼" + " ");
            }
            if (strikeCount != 0) {
                System.out.println(strikeCount + "스트라이크");
            }
        }
        System.out.println();
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println();
        }
    }

    public static void printAskRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
