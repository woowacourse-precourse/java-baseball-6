package baseball.console.game.numberbaseball;

import baseball.console.game.numberbaseball.config.GameStatus;
import baseball.console.game.numberbaseball.domain.computer.Computer;
import baseball.console.game.numberbaseball.domain.user.UserPrediction;
import camp.nextstep.edu.missionutils.Console;

import static baseball.console.game.numberbaseball.config.GameMessage.REQUEST_USER_INPUT;

public class NumberBaseballGame {
    UserPrediction userPrediction;
    Computer computer;
    GameStatus status;

    public NumberBaseballGame() {
        computer = new Computer();
        status = GameStatus.CONTINUE;
    }

    public void start() {
        generateNumber();
        while (status == GameStatus.CONTINUE) {
            userPredict();
            computeResult();
            printResult();
            refreshStatus();
        }
    }

    private void generateNumber() {
        computer.generate();
    }

    private void userPredict() {
        printGameMessage(REQUEST_USER_INPUT);
        userPrediction = new UserPrediction(Console.readLine());
    }

    private void computeResult() {
            computer.compute(userPrediction.getNumber());
    }

    private void printResult() {
            printGameMessage(computer.result());
    }

    private void refreshStatus() {
        if (computer.answer()) {
            status = GameStatus.CLEAR;
        }
    }

    private void printGameMessage(String message) {
        System.out.print(message);
    }
}
