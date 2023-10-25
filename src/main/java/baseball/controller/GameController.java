package baseball.controller;

import baseball.io.Input;
import baseball.io.Output;
import baseball.umpire.Judgement;
import baseball.umpire.Result;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameController {
    private final static int IN_GAME_INPUT = 3;
    private final static int REPLAY_INPUT = 1;
    private final static int MINIMUM_RANDOM_VALUE = 1;
    private final static int MAXIMUM_RANDOM_VALUE = 9;
    private final static int BASEBALL_NUMBER_SIZE = 3;
    private final static int REPLAY_VALUE = 1;

    public List<Integer> createOpponent() {
        Set<Integer> opponent = new HashSet<Integer>();

        while (opponent.size() < BASEBALL_NUMBER_SIZE) {
            int randomNumber =
                    Randoms.pickNumberInRange(MINIMUM_RANDOM_VALUE, MAXIMUM_RANDOM_VALUE);
            opponent.add(randomNumber);
        }
        return setIntoList(opponent);
    }

    public void guessTilSuccess(List<Integer> opponent) {
        Output.printTryNumber();

        Result resultData = Judgement.countSB(opponent, getInput(IN_GAME_INPUT));
        //Recursive
        if (Output.printResult(resultData)) {
            guessTilSuccess(opponent);
        }
    }

    public boolean replay() {
        Output.printGameAgain();
        return getInput(REPLAY_INPUT).get(0) == REPLAY_VALUE;
    }

    private List<Integer> getInput(int inputType) {
        return Input.playerInput(inputType);
    }

    private List<Integer> setIntoList(Set<Integer> target) {
        return target.stream().toList();
    }
}
