package baseball.gameRule;

import baseball.outputProcess.ComputerOutput;

public class ShowScore {

    public void eachScore(int strike, int ball) {
        String result = "";
        if (strike != 0 && ball != 0) {
            result = ball + "볼 " + strike + "스트라이크";
        } else if (strike == 0 && ball != 0) {
            result = ball + "볼";
        } else if (strike != 0 && ball == 0) {
            result = strike + "스트라이크";
        } else {
            result = "낫싱";
        }
        System.out.println(result);
    }
}
