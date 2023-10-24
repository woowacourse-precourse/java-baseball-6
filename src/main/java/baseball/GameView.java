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
}
