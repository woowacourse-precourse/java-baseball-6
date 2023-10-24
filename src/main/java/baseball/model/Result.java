package baseball.model;

import java.util.List;

public class Result {
    private List<Integer> computerArr;
    private List<Integer> inputNumArr;

    public Result(List<Integer> userNum, List<Integer> comNum) {
        this.computerArr = comNum;
        this.inputNumArr = userNum;
    }

    public int calculateStrike() {
        int strikeNum = 0;
        int index = 0;
        for (Integer num : computerArr) {
            if (num.equals(inputNumArr.get(index))) {
                strikeNum++;
            }
            index++;
        }
        return strikeNum;
    }

    public int calculateBall() {
        int ballNum = 0;
        for (Integer num : inputNumArr) {
            if (computerArr.contains(num)) {
                ballNum++;
            }
        }
        ballNum -= calculateStrike();
        return ballNum;
    }
}