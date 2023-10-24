package baseball;

import java.util.List;

public class GameSystem {
    public void playGame() {
        do {
            startGame();
        } while (restartGame());
    }

    private void startGame() {
        InputMsgView inputMsgView = new InputMsgView();
        inputMsgView.printStartMsg();

        Computer computer = new Computer();
        computer.generateNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        inputMsgView.printInputNumberMsg();
    }

    private boolean restartGame() {
        // TO-DO restart game 로직 작성

        return false;
    }
}
