package baseball.view;

import baseball.constants.Constants;

public class EndView {
    public void displayEndMessage(){
        System.out.print(Constants.GAME_OVER_MESSEAGE);
    }
    public void displayRestartMessage(){
        System.out.println(Constants.RESTART_MESSEAGE);
    }
}
