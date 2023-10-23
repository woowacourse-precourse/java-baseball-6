package baseball.game;

import baseball.util.InputUtil;
import baseball.util.OutputUtil;
import baseball.util.RandomNumberUtil;
import baseball.util.StrikeBallUtil;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    static boolean restartFlag = true;

    public static void start() {
        while (restartFlag) {

            final String answerNumbers = RandomNumberUtil.getThreeRandomNumbers();

            boolean isCorrect = false;
            while (!isCorrect) {

                String userNumbers = InputUtil.inputNumber();

                Hint hint = StrikeBallUtil.getHint(answerNumbers, userNumbers);
                StrikeBallUtil.printHint(hint);

                if (isThreeStrike(hint.getStrike())) {
                    isCorrect = true;

                    OutputUtil.printRestartOrClose();
                    restartFlag = InputUtil.inputRestartOrClose();
                }
            }
        }
        Console.close();
    }

    private static boolean isThreeStrike(int strike) {
        return strike == 3;
    }
}
