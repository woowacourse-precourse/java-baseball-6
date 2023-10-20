package baseball;

public class GameResult {
    int ball;
    int strike;
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
            System.out.println(strike+"스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public boolean isStrike() {
        if (strike != 3) {
            return false;
        }
        return true;
    }
}
