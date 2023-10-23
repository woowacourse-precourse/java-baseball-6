package baseball;

import baseball.domain.Computer;

public class Game {
    Computer computer = new Computer();

    public void startGame() {
        View.printStartGameMessage();
        computer.createAnswerNumberList();
    }
}
