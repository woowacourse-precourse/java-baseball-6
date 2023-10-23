package baseball.view;

import baseball.model.Computer;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printResult(Computer computer) {
        int ballCount = computer.getBallCount();
        int strikeCount = computer.getStrikeCount();

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 3) {
            System.out.println("3스트라이크\n"
                    + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else {
            System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
        }
    }

    public static void printGameExitMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}