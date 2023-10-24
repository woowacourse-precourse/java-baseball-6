package baseball.model;


public class BaseBallNumber {
    private final Integer first;
    private final Integer second;
    private final Integer third;

    public BaseBallNumber(Integer first, Integer second, Integer third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public BaseBallResult compareNumber(BaseBallNumber num) {
        //todo: 구현
        int strike = countCorrectPlaceNumber(this, num);
        int ball = countDiffPlaceNumber(this, num);

        return new BaseBallResult(ball, strike);
    }

    private Integer countCorrectPlaceNumber(BaseBallNumber a, BaseBallNumber b) {
        int strike = 0;
        strike += isEqualNumber(a.first, b.first);
        strike += isEqualNumber(a.second, b.second);
        strike += isEqualNumber(a.third, b.third);
        return strike;
    }

    private Integer countDiffPlaceNumber(BaseBallNumber a, BaseBallNumber b) {
        int ball = 0;
        if (isEqualNumber(a.first, b.second) == 1 || isEqualNumber(a.first, b.third) == 1) {
            ball++;
        }
        if (isEqualNumber(a.second, b.first) == 1 || isEqualNumber(a.second, b.third) == 1) {
            ball++;
        }
        if (isEqualNumber(a.third, b.first) == 1 || isEqualNumber(a.third, b.second) == 1) {
            ball++;
        }
        return ball;
    }

    private Integer isEqualNumber(Integer a, Integer b) {
        if (a.equals(b)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "BaseBallNumber{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
