package baseball.view;

import baseball.BaseballGameMessage;

public class BaseballOutputView {

    public void printMessage(BaseballGameMessage message) {
        System.out.println(message);
    }

    public void printUserInputMessage(BaseballGameMessage message) {
        System.out.print(message);
    }

    public void printGameResult(String result) {
        System.out.println(result);
    }
}
