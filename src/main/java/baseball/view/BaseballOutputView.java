package baseball.view;

import baseball.BaseballGameMessage;

public class BaseballOutputView {

    public void printMessage(BaseballGameMessage message) {
        System.out.println(message);
    }

    public void printGameResult(String result) {
        System.out.println(result);
    }
}
