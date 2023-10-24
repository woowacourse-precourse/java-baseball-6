package baseball.view;

public class OutputView {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void noStrikeNoBall() {
        System.out.println("낫싱");
    }

    public void printBall(int ball) {
        System.out.println(ball + "볼");
    }

    public void printStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public void printStrikeAndBall(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void printThreeStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }
}
