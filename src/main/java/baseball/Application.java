package baseball;

import static baseball.enums.GameOverSignal.FINISH;
import static baseball.enums.Message.END_MESSAGE;
import static baseball.enums.Message.GAME_END_PROMPT;
import static baseball.enums.Message.INPUT_NUMBER_PROMPT;
import static baseball.enums.Message.NOTHING;
import static baseball.enums.Message.START_MESSAGE;
import static baseball.util.PrintUtils.printMessage;
import static baseball.util.PrintUtils.println;
import static baseball.util.ValidationUtils.validateInput;

import baseball.dto.Score;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static boolean isGameToBeContinued = true;

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        printMessage(START_MESSAGE);
        do {
            List<Integer> pickedIntegers = getRandomIntegers();

            while (true) {
                printMessage(INPUT_NUMBER_PROMPT);

                String inputValue = getInputValue();
                Score score = getScoreFrom(inputValue, pickedIntegers);

                printScoreBoardMessageFrom(score);
                printIfStrikeOutFrom(score);

                if (score.isStrikeOut()) {
                    break;
                }
            }
            askIfContinue();
        } while (isGameToBeContinued);
        Console.close();
    }

    private static Score getScoreFrom(String inputValue, List<Integer> pickedIntegers) {
        Score score = Score.builder().build();

        for (int i = 0; i < inputValue.length(); i++) {
            for (int j = 0; j < pickedIntegers.size(); j++) {
                if (inputValue.charAt(i) == pickedIntegers.get(j).toString().charAt(0) && i == j) {
                    score.increaseStrikeCount();
                    break;
                }

                if (inputValue.charAt(i) == pickedIntegers.get(j).toString().charAt(0)) {
                    score.increaseBallCount();
                }
            }
        }
        return score;
    }

    private static String getInputValue() {
        String inputValue = Console.readLine();

        validateInput(inputValue);
        return inputValue;
    }

    private static List<Integer> getRandomIntegers() {
        List<Integer> pickedIntegers = new ArrayList<>();
        while (pickedIntegers.size() < 3) {
            int pickedInteger = Randoms.pickNumberInRange(1, 9);
            if (!pickedIntegers.contains(pickedInteger)) {
                pickedIntegers.add(pickedInteger);
            }
        }

        return pickedIntegers;
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

        isGameToBeContinued = !Console.readLine().equals(FINISH.getNumber());
    }
}
