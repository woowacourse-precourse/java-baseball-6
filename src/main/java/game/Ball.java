package client;

public class Ball {

    private final String ball;

    public Ball(String ball) {
        this.ball = ball;
    }

    public char ballAt(int i) {
        return ball.charAt(i);
    }

    public boolean contains(char number) {
        return ball.contains(String.valueOf(number));
    }
}
