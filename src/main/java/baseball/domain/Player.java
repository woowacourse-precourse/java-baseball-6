package baseball.domain;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Player {
    List<Integer> pickNumbers =  new ArrayList<>();
    InputView inputView;

    public Player(InputView inputView) {
        this.inputView = inputView;
    }

    public List<Integer> storeNumber(String[] picksToArray) {
        for(String pick : picksToArray) {
            int parsedPick = parseInt(pick);
            pickNumbers.add(parsedPick);
        }
        return pickNumbers;
    }

    public boolean isGameEnd() {
        String gameRestart = inputView.askGameEnd();
        return gameRestart.equals("1");
    }
}
