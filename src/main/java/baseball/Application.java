package baseball;

import baseball.dto.Score;
import baseball.enums.GameOverSignal;
import baseball.enums.Message;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.PrintUtils.printMessage;
import static baseball.util.PrintUtils.println;

public class Application {
    private static boolean isGameToBeContinued = true;

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        printMessage(Message.START_MESSAGE);
        do {
            List<Integer> pickedIntegers = getRandomIntegers();

            while (true) {
                printMessage(Message.INPUT_NUMBER_PROMPT);

                String inputValue = getInputValue();
                Score score = getScoreFrom(inputValue, pickedIntegers);

                printScoreBoardMessageFrom(score);
                printIfStrikeOutFrom(score);

                if (score.getStrikeCount() == 3) {
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

    private static void validateInput(String inputValue) {
        if (!inputValue.matches("^[0-9]{3}$")) {
            throw new IllegalArgumentException("숫자 세 자리만 입력해주세요.");
        }

        if (inputValue.charAt(0) == inputValue.charAt(1) || (inputValue.charAt(1) == inputValue.charAt(2))) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해주세요.");
        }
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
        if (score.getStrikeCount() + score.getBallCount() == 0) {
            printMessage(Message.NOTHING);
            return;
        }

        String ballMessage = (score.getBallCount() != 0) ? score.getBallCount() + Message.BALL.getMessage() : "";
        String strikeMessage = (score.getStrikeCount() != 0) ? score.getStrikeCount() + Message.STRIKE.getMessage() : "";

        println((ballMessage + " " + strikeMessage));
    }

    private static void printIfStrikeOutFrom(Score score) {
        if (score.getStrikeCount() == 3) {
            printMessage(Message.END_MESSAGE);
        }
    }

    private static void askIfContinue() {
        printMessage(Message.GAME_END_PROMPT);

        isGameToBeContinued = !Console.readLine().equals(GameOverSignal.FINISH.getNumber());
    }
}
