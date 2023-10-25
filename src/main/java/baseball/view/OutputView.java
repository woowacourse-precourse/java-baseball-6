package baseball.view;

import baseball.constants.GameMessages;

public class OutputView {

    public void printlnMessage(GameMessages message) {
        System.out.println(message.getMessage());
    }

    public void printMessage(GameMessages message) {
        System.out.print(message.getMessage());
    }

    public void printContents(String contents) {
        System.out.println(contents);
    }

}
