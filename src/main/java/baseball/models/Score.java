package baseball.models;

/*
 볼과 스트라이크 수를 기억하는 클래스
 */

public class Score {
    public int ballCount;
    public int strikeCount;
    public Score(int ballCount, int strikeCount){
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }
}
