package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballModel {
    private static final int ANSWER_MIN_NUMBER = 1;
    private static final int ANSWER_MAX_NUMBER = 9;
    private static final int ANSWER_LENGTH = 3;
    private List<Integer> answer;

    public void generateAnswer() {
        answer = new ArrayList<>();
        while (answer.size() < ANSWER_LENGTH) {
            int randomNum;
            do {
                randomNum = Randoms.pickNumberInRange(ANSWER_MIN_NUMBER, ANSWER_MAX_NUMBER);
            } while (answer.contains(randomNum));
            answer.add(randomNum);
        }
    }

    public Score calculateScore(List<Integer> playerGuess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(playerGuess.get(i))) {
                strike++;
            } else if (playerGuess.contains(answer.get(i))) {
                ball++;
            }
        }
        return new Score(strike, ball);
    }

    public List<Integer> parseStringToIntegerList(String input) {
        List<Integer> list = new ArrayList<>();
        for (char c : input.toCharArray()) {
            list.add(Character.getNumericValue(c));
        }
        return list;
    }

    public boolean isValidGuess(String input) {
        if (input.length() != 3) {
            return false;
        }
        Set<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (c < ANSWER_MIN_NUMBER + '0' || c > ANSWER_MAX_NUMBER + '0') {
                return false;
            }
            if (seen.contains(c)) {
                return false;
            }
            seen.add(c);
        }
        return true;
    }

    public boolean isValidChoice(String input) {
        return input.equals("1") || input.equals("2");
    }
}
