package baseball;

public class PrintResult {
    public boolean print(int strikes, int balls) {
        balls -= strikes; // 중복 제거

        if (printBallAndStrike(strikes, balls)) {
            return false;
        }
        if (printStrike(strikes)) {
            return true;
        }
        if (printBall(balls)) {
            return false;
        }
        printNothing();
        return false;
    }

    private boolean printBallAndStrike(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
            return true;
        }
        return false;
    }

    private boolean printStrike(int strike) {
        if (strike != 0) {
            System.out.println(strike + "스트라이크");
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        }
        return false;
    }

    private boolean printBall(int ball) {
        if (ball != 0) {
            System.out.println(ball + "볼");
            return true;
        }
        return false;
    }

    private void printNothing() {
        System.out.println("낫싱");
    }
}
