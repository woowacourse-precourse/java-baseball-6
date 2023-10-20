package baseball;

import baseball.io.Output;

public class Application {

    public static void main(String[] args) {
        BaseballGameTransaction gameTransaction = new BaseballGameTransaction();
        try {
            gameTransaction.run();
        } catch (IllegalArgumentException e) {
            Output.consoleLine("예외가 발생하여 어플리케이션을 종료합니다.");
            throw e;
        }
    }

}
