package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int MIN_GAME_NUMBER_RANGE = 1;
    private static final int MAX_GAME_NUMBER_RANGE = 9;
    private List<Integer> answer;

    public GameNumbers generateAnswer() {
        answer = new ArrayList<>();

        while (answer.size() != GAME_NUMBER_SIZE) {
            int randomNumber = pickRandomNumber();

            if (answer.contains(randomNumber)) {
                continue;
            }
            answer.add(randomNumber);
        }
        return new GameNumbers(answer);
    }

    public Hint getHint(GameNumbers user) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < GAME_NUMBER_SIZE; i++) {
            int userNumber = user.getNumberByIndex(i);
            int computerNumber = answer.get(i);

            if (answer.contains(userNumber) && userNumber != computerNumber) {
                ball++;
            } else if (answer.contains(userNumber) && userNumber == computerNumber) {
                strike++;
            }
        }
        return new Hint(List.of(ball, strike));
    }

    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_GAME_NUMBER_RANGE, MAX_GAME_NUMBER_RANGE);
    }
}
