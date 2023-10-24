package baseball.view;

public class GameOutput {
    private int strike;
    private int ball;
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";

    public void printGameResult(int strikeResult, int ballResult) {
        this.strike = strikeResult;
        this.ball = ballResult;

        if (strike != 0 && ball != 0) {
            printStrikeAndBallResult();
        }

        if (strike != 0 && ball == 0) {
            printStrikeResult();
        }

        if (strike == 0 && ball != 0) {
            printBallResult();
        }

        if (strike == 0 && ball == 0) {
            printNothing();
        }
    }
    public void printStrikeAndBallResult() {
        System.out.printf(String.format("%d%s %d%s%n", ball, BALL, strike, STRIKE));
    }
    public void printStrikeResult(){
        System.out.println(strike + STRIKE);
    }

    public void printBallResult(){
        System.out.println(ball + BALL);
    }

    public void printNothing(){
        System.out.println("낫싱");
    }

    public void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameEnd() {
        System.out.println(3 + STRIKE);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
