package baseball.gameutil;

/**
 * 야구게임의 결과를 나타내는 클래스, ResultCalculator와 ResultStringGenerator 클래스 사이의 DTO이다.
 */
public class Score {

    private int strike;
    private int ball;


    /**
     * 야구게임의 결과를 나타내는 클래스의 생성자이다.
     * @param ball 볼의 개수
     * @param strike 스트라이크의 개수
     */
    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
