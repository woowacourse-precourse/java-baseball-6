package baseball.view;

import static baseball.constant.GameConstant.GAME_DIGIT;
import static baseball.view.GameMessage.*;

public class ResultFormatter {
    public static String formatResult(int strike, int ball){
        if (strike== GAME_DIGIT.getValue()){
            return strike+ STRIKE.getMessage();
        }
        if (strike==0 && ball>0){
            return ball+ BALL.getMessage();
        }
        if (strike>0 && ball==0){
            return strike+ STRIKE.getMessage();
        }
        if (strike>0 && ball>0){
            return ball+ BALL.getMessage()+ " "+ strike+ STRIKE.getMessage();
        }
        return NOTING.getMessage();
    }
}
