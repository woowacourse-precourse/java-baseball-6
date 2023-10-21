package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Baseball {
    private List<Integer> answer;

    public Baseball() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public Result guess(String userInput) throws IllegalArgumentException {
        List<Integer> userGuess = filterUserInput(userInput);

        Result result = new Result();
        for (int i = 0; i < 3; i++) {
            Integer pieceOfGuess = userGuess.get(i);

            if (pieceOfGuess.equals(answer.get(i))) {
                // strike
                result.addStrike();
            } else {
                // ball or not
                if (answer.contains(pieceOfGuess)) {
                    // ball
                    result.addBall();
                }
            }
        }
        return result;
    }

    private List<Integer> filterUserInput(String userInput) throws IllegalArgumentException {
        if (userInput == null) {
            throw new IllegalArgumentException("Null input");
        }
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("Wrong length");
        }

        LinkedList<Integer> userGuess = new LinkedList<>();
        try {
            int parsedInput = Integer.parseInt(userInput);
            while (userGuess.size() < 3) {
                int i = parsedInput % 10;
                parsedInput = parsedInput / 10;
                if (userGuess.contains(i)) {
                    throw new IllegalArgumentException("Duplicated");
                }
                userGuess.push(i);
            }

        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("NaN");
        }

        return userGuess;
    }

    public static class Result {
        private int ball = 0;
        private int strike = 0;

        public void addStrike() {
            strike = strike + 1;
        }

        public void addBall() {
            ball = ball + 1;
        }

        public boolean isCorrect() {
            return strike == 3;
        }

        public String toHangul() {
            if (ball == 0 && strike == 0) {
                return "낫싱";
            }
            if (ball > 0 && strike > 0) {
                // ball and strike
                return String.format("%d볼 %d스트라이크", ball, strike);
            } else if (ball > 0) {
                // only ball
                return String.format("%d볼", ball);
            } else {
                // only strike
                return String.format("%d스트라이크", strike);
            }

        }
    }
}
