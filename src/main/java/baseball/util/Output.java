package baseball.util;

import baseball.game.GameResult;

public class Output {
    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printWaitUserInput() {
        System.out.println("숫자를 입력해주세요. : ");
    }

    public void printUserScore(GameResult gameResult) {
        if(gameResult.isNothing()) {
            System.out.println("낫싱");
        }

        if(gameResult.hasBallCount()) {
            System.out.print(gameResult.getBallCount() + "볼 ");
        }

        if(gameResult.hasStrikeCount()) {
            System.out.println(gameResult.getStrikeCount() + "스트라이크");
        }
    }

    public void printGameWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
