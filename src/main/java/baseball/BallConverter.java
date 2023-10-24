package baseball;

/*
 * 입력된 숫자의 각 자리수를 배열로 만드는 클래스
 * */
public class BallConverter {

    private final int firstBall;
    private final int secondBall;
    private final int thirdBall;
    private final int[] balls;

    public BallConverter(int input) {
        this.firstBall = input / 100;
        this.secondBall = input % 100 / 10;
        this.thirdBall = input % 10;
        this.balls = new int[]{firstBall, secondBall, thirdBall};
    }

    public int[] convert() {
        return balls;
    }
}
