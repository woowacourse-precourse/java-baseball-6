package baseball.model;

import java.util.List;

public class Result {
    private List<Integer> computerArr;
    private List<Integer> inputNumArr;

    public Result(List UserNum, List ComNum){
        this.computerArr = ComNum;
        this.inputNumArr = UserNum;
//        System.out.println("Result ComNum : " + ComNum);
    }
    public int calculateStrike() {
        int strikeNum = 0;
        int index = 0;
        for (Object num : computerArr) {
            if (num.equals(inputNumArr.toArray()[index])) {
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
