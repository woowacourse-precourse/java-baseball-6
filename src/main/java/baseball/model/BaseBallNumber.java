package baseball.model;


import java.util.ArrayList;

public class BaseBallNumber {
    private final ArrayList<Integer> nums;

    public BaseBallNumber(ArrayList<Integer> nums) {
        this.nums = nums;
    }

    public BaseBallResult compareNumber(BaseBallNumber num) {
        int strike = 0;
        int ball = 0;

        ArrayList<Integer> a = this.nums;
        ArrayList<Integer> b = num.nums;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(b.get(i))) {
                strike++;
            }
            for (int j = 0; j < b.size(); j++) {
                if (j == i) {
                    continue;
                }
                if (a.get(i).equals(b.get(j))) {
                    ball++;
                }
            }
        }
        return new BaseBallResult(ball, strike);
    }

    @Override
    public String toString() {
        return "BaseBallNumber{" +
                "nums=" + nums +
                '}';
    }
}
