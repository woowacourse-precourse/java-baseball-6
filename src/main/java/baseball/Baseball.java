package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private List<Integer> baseballCount;
    private boolean isEndState;

    public Baseball() {
        baseballCount = new ArrayList<>();
        isEndState = false;
        while (baseballCount.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballCount.contains(randomNumber)) baseballCount.add(randomNumber);
        }
    }

    public void readBallCount(List<Integer> playerGuess) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < playerGuess.size(); i++) {
            int guessNumber = playerGuess.get(i);
            int targetNumber = baseballCount.get(i);

            if (guessNumber == targetNumber) {
                strikes++;
            }
            else if (baseballCount.contains(guessNumber)) {
                balls++;
            }
        }
        announceCount(balls, strikes);
        isEndState = (strikes == 3);
    }

    public void announceCount(int balls, int strikes) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes == 3) {
            System.out.println("3스트라이크");
        } else {
            String message = (balls > 0 ? balls + "볼 " : "") + (strikes > 0 ? strikes + "스트라이크" : "");
            System.out.println(message);
        }
    }

    public boolean isEndCount() {
        return isEndState;
    }
}
