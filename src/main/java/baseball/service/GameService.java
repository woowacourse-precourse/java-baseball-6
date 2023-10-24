package baseball.service;

import baseball.DTO.GameStatus;
import baseball.constant.GameRule;
import baseball.util.InputValidator;
import baseball.util.MakeRandomAnswer;
import baseball.view.OutputHandler;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class GameService {

    GameStatus status = new GameStatus();
    OutputHandler outputHandler = new OutputHandler();
    InputValidator validator = new InputValidator();
    int[] answer;
    int[] userInput;

    public void initGame() {
        status.initGameStatus();
        answer = MakeRandomAnswer.getRandomNumber();
    }

    public void startGame() {
        while (status.getStrikeCount() != GameRule.DIGIT) {
            userInput = parseUserInput(getUserInput());
            check();
            outputHandler.noticeCurrentScore(status.getBallCount(), status.getStrikeCount());
        }
    }

    private void check() {
        status.initGameStatus();
        calculateScore(userInput);
    }

    private void calculateScore(int[] userInput) {
        for (int baseIndex = 0; baseIndex < GameRule.DIGIT; baseIndex++) {
            calculate(answer, userInput, baseIndex);
        }
    }

    private void calculate(int[] answer, int[] userInput, int baseIndex) {
        for (int compareIndex = 0; compareIndex < GameRule.DIGIT; compareIndex++) {
            if (answer[baseIndex] == userInput[compareIndex]) {
                setStatus(baseIndex, compareIndex);
                break;
            }
        }
    }

    private void setStatus(int baseIndex, int compareIndex) {
        if (baseIndex != compareIndex) {
            status.setBallCount(status.getBallCount() + 1);
        } else if (baseIndex == compareIndex) {
            status.setStrikeCount((status.getStrikeCount()) + 1);
        }
    }

    private String getUserInput() {
        OutputHandler.requestInput();
        String userInput = Console.readLine();
        if (!validator.validateHasNoChar(userInput)) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }

    private int[] parseUserInput(String userInput) {
        int[] parsedUserInput = Stream.of(userInput.split(""))
            .mapToInt(Integer::parseInt)
            .toArray();

        if (!validator.validateParsedInput(parsedUserInput)) {
            throw new IllegalArgumentException();
        }
        return parsedUserInput;
    }
}
