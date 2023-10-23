package baseball;

import java.util.Map;

public class Output {

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean printResultAndContinue(Map<String, Integer> result) {

        int strikes = result.get("strikes");
        int balls = result.get("balls");

        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }

        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }

        if (balls == 0 && strikes == 0) {
            System.out.print("낫싱");
        }

        System.out.println();

        if (strikes == GameConstants.NUM_DIGITS) {
            printGameEnd();
            return true;
        }

        return false;
    }

}
