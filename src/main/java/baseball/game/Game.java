package baseball.game;

import baseball.util.InputUtil;
import baseball.util.OutputUtil;
import baseball.util.RandomNumberUtil;
import baseball.util.StrikeBallUtil;

public class Game {
    static boolean restartFlag = true;

    public static void start() {

        restartFlag = true;
        while (restartFlag) {

            final char[] answerNumbers = RandomNumberUtil.getThreeRandomNumbers();

            boolean isCorrect = false;
            while (!isCorrect) {

                String userNumbers = InputUtil.inputNumber();

                Hint hint = StrikeBallUtil.getHint(answerNumbers, userNumbers.toCharArray());
                StrikeBallUtil.printHint(hint);

                if (isThreeStrike(hint.getStrike())) {
                    isCorrect = true;

                    OutputUtil.printRestartOrClose();
                    restartFlag = InputUtil.inputRestartOrClose();
                }
            }
        }
    }

    private static boolean isThreeStrike(int strike) {
        return strike == 3;
    }
}
