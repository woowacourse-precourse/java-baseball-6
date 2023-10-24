package baseball.domain;

import baseball.validation.PickNumberValidation;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Player {
    private List<Integer> pickNumbers;

    public Player(List<Integer> pickNumbers) {
        PickNumberValidation.checkValidInput(pickNumbers);
        this.pickNumbers = pickNumbers;
    }

    public List<Integer> getPickNumbers() {
        return pickNumbers;
    }

    //    public List<Integer> storeNumber(String[] picksToArray) {
//        for(String pick : picksToArray) {
//            int parsedPick = parseInt(pick);
//            pickNumbers.add(parsedPick);
//        }
//        return pickNumbers;
//    }
    public boolean isGameEnd(String gameRestart) {
        return gameRestart.equals("1");
    }


}
