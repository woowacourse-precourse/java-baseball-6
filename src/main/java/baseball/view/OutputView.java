package baseball.view;

import baseball.constants.MessageConstants;

public class OutputView {
    public void printlnMessage(MessageConstants message) {
        System.out.println(message.getMessage());
    }

    public void printMessage(MessageConstants message) {
        System.out.print(message.getMessage());
    }

    public void printContents(String contents) {
        System.out.println(contents);
    }

}
