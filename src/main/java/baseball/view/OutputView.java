package baseball.view;

import baseball.constants.ScoreConstant;
import baseball.messages.BaseballGameMessage;

public class OutputView {

    public void printGameStart(){
        System.out.println(BaseballGameMessage.GAME_START_MESSAGE);
    }
    public void printNothing(){
        System.out.println(ScoreConstant.NOTHING);
    }
    public void printBall(int ball){
        System.out.print(ball + ScoreConstant.BALL + ScoreConstant.BLANK);
    }
    public void printStrike(int strike){
        System.out.println(strike + ScoreConstant.STRIKE);
    }
    public void printBlank(){
        System.out.println();
    }
    public void printGameEnd(){
        System.out.println(BaseballGameMessage.GAME_END_MESSAGE);
    }
}
