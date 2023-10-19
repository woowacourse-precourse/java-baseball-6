package baseball.view;

import baseball.messages.BaseballGameMessage;

public class OutputView {

    public void printGameStart(){
        System.out.println(BaseballGameMessage.GAME_START_MESSAGE);
    }
}
