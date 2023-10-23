package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.startGame();
        while (true) {
            playBasketBallGame();

            String restartOrQuit = InputView.getRestartOrQuit();
            Validator.validateRestartOrQuit(restartOrQuit);

            if (Integer.parseInt(restartOrQuit) == Constants.QUIT){
                break;
            }
        }
    }

    private static void playBasketBallGame() {
        AnswerNumberGenerator answerNumberGenerator = new AnswerNumberGenerator();
        List<Integer> answerNumberList = answerNumberGenerator.getAnswerNumberList();

        while (true) {
            String userInputNumber = InputView.getInputNumber();
            Validator.validateUserInputNumber(userInputNumber);

            List<Integer> userInputNumberList = setStringToListInteger(userInputNumber);
            int[] strikeAndBallCount = getStrikeAndBallCount(answerNumberList, userInputNumberList);
            OutputView.showGameResult(strikeAndBallCount);

            if (strikeAndBallCount[Constants.STRIKE_INDEX] == Constants.NUMBER_SIZE) {
                OutputView.finishGame();
                return;
            }
        }
    }

    private static List<Integer> setStringToListInteger(String userInputNumber){
        List<Integer> userInputNumberList = new ArrayList<>();
        for (char digit : userInputNumber.toCharArray()) {
            userInputNumberList.add(Character.getNumericValue(digit));
        }
        return userInputNumberList;
    }

    public static int[] getStrikeAndBallCount(List<Integer> answerNumber,
        List<Integer> userNumber) {

        int[] strikeAndBallCount = new int[2];

        for (int index = 0; index < Constants.NUMBER_SIZE; index++) {
            if (answerNumber.get(index) == userNumber.get(index)) {
                strikeAndBallCount[Constants.STRIKE_INDEX]++;
                continue;
            }
            if (answerNumber.contains(userNumber.get(index))) {
                strikeAndBallCount[Constants.BALL_INDEX]++;
            }
        }

        return strikeAndBallCount;
    }
}