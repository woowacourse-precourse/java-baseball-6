package game;

public class Ball {

    private String ball;

    public Ball(String ball) {
        this.ball = ball;
    }

    public boolean ballContains(String number) {
        return ball.contains(number);
    }

    public String ballSubString(int i) {
        return ball.substring(i, i + 1);
    }
}
