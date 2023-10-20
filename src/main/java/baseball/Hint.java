package baseball;

import java.util.List;

public class Hint {

    private static final int NUMBER_SIZE = 3;
    private int strike = 0;
    private int ball = 0;

    public Hint(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        countStrike(computerNumbers, playerNumbers);
    }

    private void countStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for(int i=0; i<NUMBER_SIZE; i++) {
            if(playerNumbers.get(i).equals(computerNumbers.get(i)))
                strike++;
        }
    }
}
