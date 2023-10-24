package baseball.service;

import baseball.domain.BaseBall;
import baseball.util.HintGenerator;

import static baseball.constant.GameConstant.*;

public class PrintService {

    public static String printResult(int[] answer, int[] input){
        BaseBall baseBall= HintGenerator.getHint(answer,input);
        int size=input.length;
        if(baseBall.checkNothing()){
            return NOTHING;
        } else {
            if (size == baseBall.getStrike()) {
                return getGameOverMessage(size);
            } else {
                int ball = baseBall.getBall();
                int strike = baseBall.getStrike();
                StringBuilder result = new StringBuilder();
                if (ball > 0) {
                    result.append(ball).append(BALL);
                }
                if (strike > 0) {
                    if (result.length() > 0) result.append(" ");
                    result.append(strike).append(STRIKE);
                }
                return result.toString();
            }
        }
    }

    private static String getGameOverMessage(int size) {
        return size + STRIKE + "\n" + size + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }
}
