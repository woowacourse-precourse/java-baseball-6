package baseball.domain;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Player {
    // 답변 리스트 저장 필드
    List<Integer> pickNumbers =  new ArrayList<>();
    InputView inputView;

    public Player(InputView inputView) {
        this.inputView = inputView;
    }

    // 답변 저장
    public List<Integer> storeNumber(String[] picksToArray) {
        for(String pick : picksToArray) {
            int parsedPick = parseInt(pick);
            pickNumbers.add(parsedPick);
        }
        return pickNumbers;
    }

    public boolean isGameEnd() {
        String gameRestart = inputView.askForGameEnd();
        return gameRestart.equals("1");
    }
}
