package baseball.model;

public class GuessResult {

    private Integer ball;

    private Integer strike;

    public GuessResult() {
        this.ball = 0;
        this.strike = 0;
    }

    // IncreaseBall : ball를 1 증가시킨다.
    public void IncreaseBall() {
        this.ball++;
    }

    // IncreaseStrike : strike를 1 증가시킨다.
    public void IncreaseStrike() {
        this.strike++;
    }

    // is3Strike : strike가 3개인지 여부를 반환한다.
    public Boolean is3Strike() {
        return this.strike == 3;
    }

    // printHint : 결과에 맞춰 Hint를 출력한다.
    public void printHint() {
        if (this.ball > 0 && this.strike > 0) {
            // "x볼 x스트라이크"
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
        } else if (this.ball > 0) {
            // "x볼"
            System.out.println(this.ball + "볼");
        } else if (this.strike > 0) {
            // "x스트라이크"
            System.out.println(this.strike + "스트라이크");
        } else if (this.ball == 0 && this.strike == 0) {
            // "낫싱"
            System.out.println("낫싱");
        }
    }
}
