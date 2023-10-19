package baseball;

import baseball.game.validator.GameResult;

public class Output {
    public void success() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void result(GameResult gameResult) {
        if (gameResult.getBall() != 0) {
            System.out.print(gameResult.getBall()+"볼 ");
        }
        if (gameResult.getStrike() != 0) {
            System.out.print(gameResult.getStrike() + "스트라이크");
        }
        if (gameResult.getBall() == 0 && gameResult.getStrike() == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
