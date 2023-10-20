package baseball;

public class Ball {
    private int ballNum = 0;

    private static Ball instance = new Ball();

    private Ball() {
    }

    public static Ball getInstance() {
        return instance;
    }

    public int getBallNum() {
        return ballNum;
    }

    public void setBallNum(int ballNum) {
        this.ballNum = ballNum;
    }


}
