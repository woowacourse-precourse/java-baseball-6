package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private List<Integer> baseballCount;

    public Baseball() {
        baseballCount = new ArrayList<>();
        while (baseballCount.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballCount.contains(randomNumber)) baseballCount.add(randomNumber);
        }
    }

    public void setBallCount(List<Integer> playerGuess) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < playerGuess.size(); i++) {
            int guessNumber = playerGuess.get(i);
            int targetNumber = baseballCount.get(i);

            if (guessNumber == targetNumber) strikes++;
            else if (baseballCount.contains(guessNumber)) balls++;
        }
        announceCount(balls, strikes);
        isEndCount(strikes == 3);
    }

    public void announceCount(int balls, int strikes) {

    }

    public boolean isEndCount(boolean state) {

    }
}
