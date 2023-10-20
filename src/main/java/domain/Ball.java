package domain;

public class Ball {

    private final BallNumber ballNumber;
    private final BallIndex ballIndex;

    public Ball(int number, int index) {
        this.ballNumber = new BallNumber(number);
        this.ballIndex = new BallIndex(index);
    }

    public BallIndex getBallIndex() {
        return ballIndex;
    }

    public BallNumber getBallNumber() {
        return ballNumber;
    }

}
