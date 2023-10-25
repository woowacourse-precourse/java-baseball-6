package baseball;

import Game.BaseballGame;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import model.NumberInput;
import view.InputView;
import view.OutputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

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
        if(checkNumber == 1) {
            return true;
        }
        return false;

    }
}
