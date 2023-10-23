package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    private NumberBoard numberBoard = new NumberBoard(NumberBoard.makeRandomBoard());
    public NumberBoard getNumberBoard() {
        return numberBoard;
    }
}