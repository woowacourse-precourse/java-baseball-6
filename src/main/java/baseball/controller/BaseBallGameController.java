package baseball.controller;

import static baseball.enums.Message.END_MESSAGE;
import static baseball.enums.Message.GAME_END_PROMPT;
import static baseball.enums.Message.INPUT_NUMBER_PROMPT;
import static baseball.enums.Message.NOTHING;
import static baseball.enums.Message.START_MESSAGE;
import static baseball.util.PrintUtils.printMessage;
import static baseball.util.PrintUtils.println;
import static baseball.util.ValidationUtils.validateInput;
import static camp.nextstep.edu.missionutils.Console.close;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.dto.Score;
import baseball.dto.ThreeIntegers;
import baseball.enums.GameOverSignal;

public class BaseBallGameController {
    private static boolean isGameToBeContinued = true;

    private BaseBallGameController() {
    }

    public static void playGame() {
        printMessage(START_MESSAGE);
        do {
            ThreeIntegers pickedThreeIntegers = ThreeIntegers.createRandomThreeIntegers();

            playGameFrom(pickedThreeIntegers);
            askIfContinue();
        } while (isGameToBeContinued);
        close();
    }

    private static void playGameFrom(ThreeIntegers pickedThreeIntegers) {
        while (true) {
            printMessage(INPUT_NUMBER_PROMPT);

            String inputValue = getInputValue();
            Score score = pickedThreeIntegers.calculateScoreFrom(inputValue);

            printScoreBoardMessageFrom(score);
            printIfStrikeOutFrom(score);

            if (score.isStrikeOut()) {
                break;
            }
        }
    }

    private static String getInputValue() {
        String inputValue = readLine();

        validateInput(inputValue);
        return inputValue;
    }

    private static void printScoreBoardMessageFrom(Score score) {
        if (score.isNothing()) {
            printMessage(NOTHING);
            return;
        }
        println(score.getScoreBoardMessage());
    }

    private static void printIfStrikeOutFrom(Score score) {
        if (score.isStrikeOut()) {
            printMessage(END_MESSAGE);
        }
    }

    private static void askIfContinue() {
        printMessage(GAME_END_PROMPT);

        isGameToBeContinued = GameOverSignal.isNotFinished(readLine());
    }
}
