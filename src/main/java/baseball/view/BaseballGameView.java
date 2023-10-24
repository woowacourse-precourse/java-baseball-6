package baseball.view;

public class BaseballGameView {
    public void startGame() {
        System.out.print("숫자야구 게임을 시작합니다.");
        this.newLine();
    }

    public void enterNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void resultByScore(int ball, int strike, int max) {
        if(ball + strike == 0) {
            this.resultNothing();
            return;
        }

        if(ball > 0) {
            this.resultBall(ball);
        }

        if(strike > 0) {
            this.resultStrike(strike);

            if(strike == max) {
                this.newLine();
                this.resultStrikeFull(max);
            }
        }

        this.newLine();
    }

    public void restartOrQuit() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        this.newLine();
    }

    private void resultNothing() {
        System.out.print("낫싱");
        this.newLine();
    }

    private void resultBall(int ball) {
        System.out.print(ball + "볼 ");
    }

    private void resultStrike(int strike) {
        System.out.print(strike + "스트라이크");
    }

    private void resultStrikeFull(int n) {
        System.out.print(n + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void newLine() {
        System.out.println();
    }
}
