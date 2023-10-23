package baseball.view;


import baseball.dto.GameResult;

public class OutputView {
    public void printStartMessage(){
        System.out.print(GameMessage.GAME_START_MESSAGE.getMessage());
    }

    public void printInputMessage(){
        System.out.print(GameMessage.PROMPT_FOR_NUMBER.getMessage());
    }

    public void printEndMessage(){
        System.out.print(GameMessage.GAME_SUCCESS_MESSAGE.getMessage());
    }

    public void printRestartMessage(){
        System.out.print(GameMessage.RESTART_CHOICE_MESSAGE.getMessage());
    }

    public void printResultMessage(GameResult gameResult){
        System.out.println(ResultFormatter.formatResult(gameResult.strike(),gameResult.ball()));
    }
}
