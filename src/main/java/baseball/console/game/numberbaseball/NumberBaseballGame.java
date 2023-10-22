package baseball.console.game.numberbaseball;

import baseball.console.game.numberbaseball.config.GameStatus;
import baseball.console.game.numberbaseball.domain.computer.Computer;
import baseball.console.game.numberbaseball.domain.user.UserPrediction;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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
            compute();
            print();
            refreshStatus();
        }
    }

    private void generateNumber() {
        computer.generate();
    }

    private void userPredict() {
        printGameMessage("숫자를 입력해주세요: ");
        userPrediction = new UserPrediction(Console.readLine());
    }
    private void compute() {
            computer.compute(userPrediction.getNumber());
    }
    private void print() {
            printGameMessage(computer.result());
    }
    private void refreshStatus() {
        if (computer.answer()) {
            status = GameStatus.EXIT;
        }
    }
    private void printGameMessage(String message) {
        System.out.print(message);
    }
}
