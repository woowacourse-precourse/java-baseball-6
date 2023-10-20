package baseball;

import java.util.List;
import java.util.Map;

public class PrintResult {

    public static String printResult(Map<String, Integer> strikeOrBall) {
        int strike = strikeOrBall.get("strike");
        int ball = strikeOrBall.get("ball");

        if(strike == 0 && ball == 0){
            return "낫싱";
        }
        else if (strike != 0 && strike < 3 && ball == 0) {
            return strike + " 스트라이크";
        }
        else if (strike == 3) {
            return strike + " 스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        else if (strike == 0 && ball != 0) {
            return ball + " 볼";
        }

        return strike + " 스트라이크 " + ball + " 볼";
    }
}
