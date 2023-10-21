package baseball.view;

import baseball.service.BaseballGame;
import java.util.List;

public class OutputView {
    private BaseballGame baseballGame = new BaseballGame();

    public static void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printSuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printCalculateResult(List<Integer> computerNumber, List<Integer> playerNumber) {
        baseballGame.calculateNumbers(computerNumber, playerNumber);
        if (baseballGame.strikeCount != 0 && baseballGame.ballCount != 0) {
            System.out.println(baseballGame.ballCount + "볼 " + baseballGame.strikeCount + "스트라이크");
        }
        if (baseballGame.strikeCount == 0 && baseballGame.ballCount == 0) {
            System.out.println("낫싱");
        }
        if (baseballGame.strikeCount == 0 && baseballGame.ballCount != 0) {
            System.out.println(baseballGame.ballCount + "볼 ");
        }
        if (baseballGame.strikeCount != 0 && baseballGame.ballCount == 0) {
            System.out.println(baseballGame.strikeCount + "스트라이크");
        }
    }
}
