package baseball;

import baseball.trasaction.BaseballGameTransaction;

public class Application {

    public static void main(String[] args) {
        BaseballGameTransaction gameTransaction = new BaseballGameTransaction();
        gameTransaction.run();
    }

}
