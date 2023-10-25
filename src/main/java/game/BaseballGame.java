package game;

import player.Computer;
import player.User;
import view.InputView;
import view.OutputView;

public class BaseballGame {
    private Computer computer;
    private User player;

    public BaseballGame() {
        computer = new Computer();
    }

    public void start() {
        do {
            getNumberFromPlayer();
            showHint();
        } while(isGameContinue());
    }

    public void getNumberFromPlayer() {
        player = new User(InputView.setUserInput());
    }

    public void showHint() {
        int[] result = computer.getHint(player.getUserInput());
        if (result[0] != 0) {
            if(result[1] != 0) {
                OutputView.printBallStrike(result[0], result[1]);
            }
            else {
                OutputView.printBall(result[0]);
            }
        }

        else if (result[1] != 0){
            OutputView.printStrike(result[1]);
        }

        else {
            OutputView.printOut();
        }
    }

    public boolean isGameContinue() {
        if (computer.getIsThreeStrike()) {
            OutputView.endMessage();
            return false;
        }
        return true;
    }
}
