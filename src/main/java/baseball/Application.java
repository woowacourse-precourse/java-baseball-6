package baseball;

import baseball.controller.GameMechanism;
import baseball.domain.RetryNum;
import baseball.view.InputArea;
import baseball.view.OutputArea;

public class Application {
    public static void main(String[] args) {
        OutputArea.GameStartText();
        do{
            GameMechanism gameMechanism = new GameMechanism();
            gameMechanism.start();
        }while (ReStarting());
    }

    public static boolean ReStarting(){
        RetryNum retryNum = new RetryNum(InputArea.inputReStartNum());
        return retryNum.getRetryNum().equals("1");
    }
}
