package baseball;

import static baseball.GameNumber.NUMBER_LENGTH;

public class GameJudge {
    private GameJudge() {
    }

    public static GameResult judge(GameNumber target, GameNumber guessed) {
        int strike = 0;
        int ball = 0;
        boolean isCorrectAnswer;

        for (int idx = 0; idx < NUMBER_LENGTH; idx++) {
            if (isStrike(target, guessed, idx)) {
                strike++;
            } else if (isBall(target, guessed, idx)) {
                ball++;
            }
        }

        isCorrectAnswer = (strike == NUMBER_LENGTH);

        return new GameResult(strike, ball, isCorrectAnswer);
    }

    private static boolean isStrike(GameNumber target, GameNumber guessed, int index) {
        return target.getCharAt(index) == guessed.getCharAt(index);
    }

    private static boolean isBall(GameNumber target, GameNumber guessed, int index) {
        String keyword = String.valueOf(guessed.getCharAt(index));
        return target.getValue().contains(keyword);
    }
}
