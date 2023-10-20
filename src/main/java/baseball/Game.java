package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private final int firstPositionAnswer;
    private final int secondPositionAnswer;
    private final int thirdPositionAnswer;

    public Game() {
        firstPositionAnswer =  Randoms.pickNumberInRange(1, 9);
        secondPositionAnswer = Randoms.pickNumberInRange(1, 9);
        thirdPositionAnswer = Randoms.pickNumberInRange(1, 9);
    }
}
