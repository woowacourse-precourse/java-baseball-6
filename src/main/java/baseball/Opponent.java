package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Opponent {
    private List<Integer> answer;

    public Opponent() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public GuessResult guess(List<Integer> userGuess) throws IllegalArgumentException {
        GuessResult guessResult = new GuessResult();
        for (int i = 0; i < 3; i++) {
            Integer pieceOfGuess = userGuess.get(i);

            if (pieceOfGuess.equals(answer.get(i))) {
                // strike
                guessResult.addStrike();
            } else {
                // ball or not
                if (answer.contains(pieceOfGuess)) {
                    // ball
                    guessResult.addBall();
                }
            }
        }
        return guessResult;
    }

    public static class GuessResult {
        private GuessResult() {
        }

        private int ball = 0;
        private int strike = 0;

        private void addStrike() {
            strike = strike + 1;
        }

        private void addBall() {
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
