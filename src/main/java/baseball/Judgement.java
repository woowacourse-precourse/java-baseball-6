package baseball;

import java.util.List;public class Judgement {
    Compare compare = new Compare();

    public String judgement(List<String> computerNumList, List<String> userNumList) {
        int ball = compare.compareNumbers(computerNumList, userNumList)[0];
        int strike = compare.compareNumbers(computerNumList, userNumList)[1];

        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike == 0 && ball > 0) {
            return ball + "볼";
        } else if (strike > 0 && ball == 0) {
            return strike + "스트라이크";
        } else if (strike > 0 && ball > 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else {
            throw new IllegalArgumentException("Invalid argument: [" + ball + ", " + strike + "]");
        }
    }
}

