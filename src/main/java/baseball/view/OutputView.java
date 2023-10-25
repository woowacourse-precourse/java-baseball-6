package baseball.view;

import static baseball.constant.Message.START_GAME;
import static baseball.constant.Message.USER_INPUT;
import static baseball.constant.Message.NOTHING;
import static baseball.constant.Message.BALL;
import static baseball.constant.Message.STRIKE;
import static baseball.constant.Message.SUCCESS;
import static baseball.constant.Message.RETRY;

public class OutputView {

    public void startGameMessage(){
        System.out.println(START_GAME);
    }

    public void userInputMessage(){
        System.out.print(USER_INPUT);
    }

    public void resultMessage(int balls, int strikes){
        StringBuilder result = new StringBuilder("");

        if (balls == 0 && strikes == 0){
            result.append(NOTHING);
        }
        if (balls!=0){
            result.append(balls).append(BALL);
        }
        if (balls!=0 && strikes!=0){
            result.append(" ");
        }
        if (strikes!=0){
            result.append(strikes).append(STRIKE);
        }
        System.out.println(result);
    }

    public void winMessage(){
        System.out.println(SUCCESS);
    }

    public void retryMessage(){
        System.out.println(RETRY);
    }
}
