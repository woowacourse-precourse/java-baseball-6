package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private List<Integer> computerNumber;
    private Helper helper;
    private static final int BASEBALL_NUM_SIZE = 3;
    private static final int STRIKE = 1;


    public BaseBallGame(Helper helper) {
        this.helper = helper;
        computerNumber = helper.generatorComputerNumber(BASEBALL_NUM_SIZE);
    }

    public List<Integer> checkBallCount(List<Integer> userInput) {
        List<Integer> listBallStrike = new ArrayList<>();
        int totalCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < BASEBALL_NUM_SIZE; i++) {
            if (userInput.contains(computerNumber.get(i))) {
                totalCount++;
            }
            if (userInput.get(i) == computerNumber.get(i)) {
                strikeCount++;
            }
        }

        listBallStrike.add(totalCount - strikeCount);
        listBallStrike.add(strikeCount);
        return listBallStrike;
    }

    public boolean checkThreeStrike(List<Integer> listBallStrike) {
        if (listBallStrike.get(STRIKE) == BASEBALL_NUM_SIZE) {
            return true;
        }
        return false;
    }
}