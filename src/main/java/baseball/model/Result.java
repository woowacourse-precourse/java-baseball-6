package baseball.model;

import java.util.List;

public class Result {
    private List<Integer> computerArr;
    private List<Integer> inputNumArr;
    private int calculateStrike() {
        int strikeNum = 0;
        int index = 0;
        for (Object num : computerArr) {
            if (num.equals(inputNumArr.toArray()[index])) {
                strikeNum++;
            }
            index++;
        }
        System.out.println(strikeNum);
        return strikeNum;
    }

    private int calculateBall() {
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
