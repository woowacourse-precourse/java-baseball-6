package baseball;

public class GameResult {
    private final int ball;
    private final int strike;
    public GameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public void printResult() {
        if (ball == 0 & strike == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0 & strike == 0) {
            System.out.println(ball+"볼");
        }
        if (ball == 0 & strike > 0 & strike < 3) {
            System.out.println(strike+"스트라이크");
        }
        if (ball != 0 & strike > 0 & strike < 3) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        if (strike == 3) {
            System.out.println(strike+"스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}
