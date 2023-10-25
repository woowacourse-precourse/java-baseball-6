package baseball;

import Game.BaseballGame;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args){
        OutputView.startMessage();
        do {
            BaseballGame game = new BaseballGame();
            game.start();
        } while(isContinue());

    }

    public static boolean isContinue() {
        int checkNumber = Integer.parseInt(InputView.setRetryInput());
        if (checkNumber == 1) {
            return true;
        }
        return false;

    }
}
