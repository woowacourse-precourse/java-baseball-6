package baseball.game;

import baseball.Computer;
import java.util.List;

public class PredictGamePlay implements GamePlay {
    @Override
    public String play(List<String> args) {
        String inputNumber = args.get(0);
        String errMsg = "잘못된 입력입니다, 예측 가능한 수는 세자리(1~9) 숫자입니다.";

        // exception handling
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException(errMsg);
        }

        if (inputNumber.contains("0")) {
            throw new IllegalArgumentException(errMsg);
        }

        if (inputNumber.charAt(0) == inputNumber.charAt(1) ||
                inputNumber.charAt(1) == inputNumber.charAt(2) ||
                inputNumber.charAt(2) == inputNumber.charAt(0)) {
            throw new IllegalArgumentException(errMsg);
        }

        int nStrike = 0;
        int nBall = 0;

        for (int i = 0; i < 3; ++i) {

            char target = inputNumber.charAt(i);

            if (target == Computer.number.charAt(i)) {
                nStrike++;
            } else if (Computer.number.contains("" + target)) {
                nBall++;
            }
        }

        String ret = "";

        if (nBall > 0) {
            ret += nBall + "볼";
        }

        if (nStrike > 0) {
            if (nBall > 0) {
                ret += " ";
            }
            ret += nStrike + "스트라이크";
        }

        if (ret == "") {
            ret = "낫싱";
        }

        return ret;
    }
}
