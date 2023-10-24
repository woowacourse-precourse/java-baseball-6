package baseball.utils;

import baseball.domain.BaseBall;

public class HintGenerator {

    public static BaseBall getHint(int[] answer, int[] guess) {
        if(answer.length!=guess.length) throw new IllegalArgumentException();
        int size=answer.length;
        BaseBall result = new BaseBall();
        for (int i = 0; i < size ; i++) {
            if (answer[i] == guess[i]) {
                result.addStrike();
            } else if (contains(guess, answer[i])) {
                result.addBall();
            }
        }
        return result;
    }

    private static boolean contains(int[] array, int element) {
        for (int number : array) {
            if (number == element) {
                return true;
            }
        }
        return false;
    }
}
