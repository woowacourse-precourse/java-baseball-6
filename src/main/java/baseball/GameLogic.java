package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    static final Integer COMPUTER_ANSWER_SIZE = 3;
    static final Integer ANSWER_RANGE_START = 1;
    static final Integer ANSWER_RANGE_END = 9;

    static boolean isSuccessGuess(GuessResult guessResult) {
        return guessResult.getStrikeCount() == COMPUTER_ANSWER_SIZE;
    }

    static GuessResult checkGuess(List<Integer> answer, List<Integer> guess) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0 ; i < COMPUTER_ANSWER_SIZE ; i++) {
            if (answer.get(i).equals(guess.get(i))) {
                strikeCount++;
            } else if (answer.contains(guess.get(i))) {
                ballCount++;
            }
        }

        return new GuessResult(strikeCount, ballCount);
    }

    static List<Integer> createComputerAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(ANSWER_RANGE_START, ANSWER_RANGE_END);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static List<Integer> createUserGuess(String guessInput) {
        if (guessInput.length() == COMPUTER_ANSWER_SIZE) {
            try {
                return List.of(
                        Integer.parseInt(guessInput.substring(0, 1)),
                        Integer.parseInt(guessInput.substring(1, 2)),
                        Integer.parseInt(guessInput.substring(2, 3)));
            } catch (Exception e) {
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }
        } else {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }
}
