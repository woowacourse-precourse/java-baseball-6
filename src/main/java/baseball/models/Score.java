package baseball.models;

/*
 볼과 스트라이크 수(점수)를 기억하는 클래스
 점수는 그 누구라도 볼 수 있다.
 */

public class Score {
    public int ballCount;
    public int strikeCount;

    public Score(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }
}
