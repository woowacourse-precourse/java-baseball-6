package baseball;

public class GameView {

    public GameView() {
    }

    public void printMessage(String Message) {
        System.out.println(Message);
    }

    public void printStrikeAndBall(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void displayResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            printMessage(GameModel.NOTHING);
        } else if (strike == 0) {
            printMessage(ball + GameModel.BALL);
        } else if (ball == 0) {
            printMessage(strike + GameModel.STRIKE);
        } else {
            printStrikeAndBall(strike, ball);
        }
    }
}
