package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class CheckCount {

    private final List<Integer> computerNumberList;
    private final List<Integer> userNumberList;
    private final int length;

    public CheckCount(ComputerNumber computerNumber, List<Integer> userNumberList) {
        this.computerNumberList = computerNumber.getComputerNumber();
        this.userNumberList = userNumberList;
        this.length = computerNumberList.size();
    }

    public List<Integer> compareNumber() {
        return countAll(checkSameNum(), countStrike());
    }

    private int checkSameNum() {
        int sameNum = 0;

        for (int i = 0; i < length; i++) {
            if (computerNumberList.contains(userNumberList.get(i))) {
                sameNum += 1;
            }
        }
        return sameNum;
    }

    private int countStrike() {
        int strike = 0;

        for (int i = 0; i < length; i++) {
            if (computerNumberList.get(i).equals(userNumberList.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    private List<Integer> countAll(int sameNum, int strike) {
        List<Integer> ballStrike = new ArrayList<>();
        int ball = sameNum - strike;

        ballStrike.add(ball);
        ballStrike.add(strike);

        return ballStrike;
    }
}
