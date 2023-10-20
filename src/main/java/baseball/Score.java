package baseball;

// 비교 결과에 대한 값을 Score 라고 하는 클래스의 맴버 변수로 관리한다면 굳이 외부의 변수 strike 와 ball 을 인수로 받을 필요가 없어진다.
// strike 과 ball 의 점수를 올리기 위한 operation 을 public 으로 노출합니다.
public class Score {
    private int strike = 0;
    private int ball = 0;

    public Score() {
    }

    void increaseBallCount() {
        this.ball += 1;
    }

    void increaseStrikeCount() {
        this.strike += 1;
    }


    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
