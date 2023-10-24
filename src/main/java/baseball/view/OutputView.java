package baseball.view;

import static baseball.constant.Message.*;

public class OutputView {

    public void startGameMessage(){
        System.out.println(START_GAME);
    }

    public void userInputMessage(){
        System.out.println(USER_INPUT);
    }

    public void resultMessage(int ball, int strike){
        StringBuilder result = new StringBuilder("");

        if (ball == 0 && strike == 0){
            result.append(NOTHING);
        }
        if (ball!=0){
            result.append(ball).append(BALL);
        }
        if (ball!=0 && strike!=0){
            result.append(" ");
        }
        if (strike!=0){
            result.append(strike).append(STRIKE);
        }
        System.out.println(result.toString());
    }

    public void winMessage(){
        System.out.println(SUCCESS);
    }

    public void retryMessage(){
        System.out.println(RETRY_GAME);
    }
}
