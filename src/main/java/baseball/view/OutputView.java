package baseball.view;

import baseball.util.GameConstant;

public class OutputView {

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void askForNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printCountForBallsAndStrikes(int ballCount, int strikeCount) {
        if (noBallsOrStrikes(ballCount, strikeCount)) {
            System.out.println("낫싱");
            askForNumber();
            return;
        }
        if (onlyStrikes(ballCount, strikeCount)) {
            System.out.println(strikeCount + "스트라이크");
            if (strikeCount != GameConstant.GAME_END_STRIKE_COUNT) {
                askForNumber();
            }
            return;
        }
        if (onlyBalls(ballCount, strikeCount)) {
            System.out.println(ballCount + "볼");
            askForNumber();
            return;
        }
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        askForNumber();
    }

    public void printEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private boolean noBallsOrStrikes(int ballCount, int strikeCount) {
        return ballCount == 0 && strikeCount == 0;
    }

    private boolean onlyStrikes(int ballCount, int strikeCount) {
        return ballCount == 0 && strikeCount > 0;
    }

    private boolean onlyBalls(int ballCount, int strikeCount) {
        return ballCount > 0 && strikeCount == 0;
    }

}
