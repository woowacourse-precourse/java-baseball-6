package baseball.view;

import baseball.game.constant.GameConstant;

public class ResultFormatter {
    public static String formatResult(int strike, int ball){
        if (strike== GameConstant.GAME_DIGIT.getValue()){
            return strike+ GameMessage.STRIKE.getMessage();
        }
        if (strike==0 && ball>0){
            return ball+ GameMessage.BALL.getMessage();
        }
        if (strike>0 && ball==0){
            return strike+ GameMessage.STRIKE.getMessage();
        }
        if (strike>0 && ball>0){
            return ball+ GameMessage.BALL.getMessage()
                    +" "+strike+ GameMessage.STRIKE.getMessage();
        }
        return GameMessage.NOTING.getMessage();
    }
}
