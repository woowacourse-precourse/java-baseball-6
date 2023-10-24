package baseball;

import baseball.io.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        User user = new User();
        Computer computer = new Computer();
        BaseBallGameMachine baseBallGameMachine = new BaseBallGameMachine(computer,user);
        Output.printStartMessage();

        do {
            baseBallGameMachine.playGame();
        } while (!user.finishOrRestart());

    }
}
