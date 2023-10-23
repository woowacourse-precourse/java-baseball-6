package baseball.view;


import baseball.dto.GameResult;
import baseball.game.constant.GameConstant;

public class OutputView {
    public void printStartMessage(){
        System.out.print(GameMessage.GAME_START_MESSAGE.getMessage());
    }
    public void printInputMessage(){
        System.out.print(GameMessage.PROMPT_FOR_NUMBER.getMessage());
    }
    public void printEndMessage(){
        System.out.print(GameMessage.GAME_SUCCESS_MESSAGE.formatMessage(
                GameConstant.GAME_DIGIT.getValue()));
    }
    public void printRestartMessage(){
        System.out.print(GameMessage.RESTART_CHOICE_MESSAGE.formatMessage(
                GameConstant.RESTART_CHOICE.getValue(),GameConstant.END_CHOICE.getValue()));
    }
    public void printResultMessage(GameResult gameResult){
        System.out.println(ResultFormatter.formatResult(gameResult.strike(),gameResult.ball()));
    }
}
