package baseball.view;

import baseball.dto.GameResult;

import static baseball.constant.GameConstant.*;
import static baseball.view.message.GameMessage.*;

public class OutputView {
    public void printStartMessage(){
        System.out.print(GAME_START_MESSAGE.getMessage());
    }
    public void printInputMessage(){
        System.out.print(PROMPT_FOR_NUMBER.getMessage());
    }
    public void printEndMessage(){
        System.out.print(GAME_SUCCESS_MESSAGE.formatMessage(GAME_DIGIT.getValue()));
    }
    public void printRestartMessage(){
        System.out.print(
                RESTART_CHOICE_MESSAGE.formatMessage(RESTART_CHOICE.getValue(),END_CHOICE.getValue()));
    }
    public void printResultMessage(GameResult gameResult){
        System.out.println(
                ResultFormatter.formatResult(gameResult.strike(),gameResult.ball()));
    }
}
