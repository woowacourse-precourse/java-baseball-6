package baseball.domain.dto;

public class Result {
    private final int ball;
    private final int strike;

    // 스트라이크, 볼 저장 기능
    public Result(int ball, int strike){
        this.ball = ball;
        this.strike = strike;
    }

    // 스트라이크, 볼 결과 반환 기능

    public int getBall(){
        return ball;
    }

    public int getStrike(){
        return strike;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }
}
