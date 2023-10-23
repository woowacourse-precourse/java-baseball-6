package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        PrintMessage.printGameStartMessage();
        playBasketBallGame();
    }

    public static void playBasketBallGame() {
        AnswerNumberGenerator answerNumberGenerator = new AnswerNumberGenerator();
        List<Integer> answerNumberList = answerNumberGenerator.getAnswerNumberList();

        PrintMessage.printReadNumberMessage();
        String userInputNumber = Console.readLine();
        try {
            Validator.validateUserInputNumber(userInputNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        List<Integer> userInputNumberList = new ArrayList<>();
        for (char digit : userInputNumber.toCharArray()) {
            userInputNumberList.add(Character.getNumericValue(digit));
        }

        int[] strikeAndBallCount = getStrikeAndBallCount(answerNumberList, userInputNumberList);
        PrintMessage.printGameResultMessage(strikeAndBallCount);
    }

    public static int[] getStrikeAndBallCount(List<Integer> answerNumber,
        List<Integer> userNumber) {

        int[] strikeAndBallCount = new int[2];

        for (int index = 0; index < Constants.NUMBER_SIZE; index++) {
            if (answerNumber.get(index) == userNumber.get(index)) {
                strikeAndBallCount[0]++;
                continue;
            }
            if (answerNumber.contains(userNumber.get(index))) {
                strikeAndBallCount[1]++;
            }
        }

        return strikeAndBallCount;
    }
}