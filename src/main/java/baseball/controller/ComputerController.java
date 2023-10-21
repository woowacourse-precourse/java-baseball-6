package baseball.controller;

import baseball.domain.Computer;
import baseball.view.InputView;

public class ComputerController {
    InputView inputView = new InputView();
    Computer computer = new Computer();
    boolean gameState = false;

    public void start() {
        computer.setComputerNumber();
        int computerNumber = computer.getComputerNumber();
        while (!gameState) {
            int playerNumber = inputView.print_input_message();
            gameState = compareNumber(computerNumber, playerNumber);
        }

    }

    private boolean compareNumber(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            return true;
        }
        compareComputerAndPlayer();
        return false;
    }
    
}
