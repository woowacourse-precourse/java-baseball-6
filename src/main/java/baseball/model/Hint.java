package baseball.model;

public class Hint {
    private Integer strike;
    private Integer ball;

    public Hint() {
        this.strike = 0;
        this.ball = 0;
    }

    public void compareNumbers(Numbers computer, Numbers player) {
        this.strike = computer.countIdentity(player);
        this.ball = computer.countEquality(player);
    }

    public String generateHint() {
        if (strike != 0 && ball != 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else if (strike != 0) {
            return strike + "스트라이크";
        } else if (ball != 0) {
            return ball + "볼";
        }
        return "낫싱";
    }

    public Boolean hasThreeStrike() {
        return strike == 3;
    }
}
