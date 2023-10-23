package baseball.model;


import java.util.ArrayList;

public class BaseBallNumber {
    private final Integer first;
    private final Integer second;
    private final Integer third;

    public BaseBallNumber(Integer first, Integer second, Integer third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public BaseBallNumber(ArrayList<Integer> num) {
        this.first = num.get(0);
        this.second = num.get(1);
        this.third = num.get(2);
    }

    public BaseBallResult compareNumber(BaseBallNumber num) {
        //todo: 구현
        return new BaseBallResult(1, 1);
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
