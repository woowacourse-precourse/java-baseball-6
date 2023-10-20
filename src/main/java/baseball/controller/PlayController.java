package baseball.controller;

import baseball.model.GameNumber;
import baseball.model.GameState;
import baseball.view.GameOutput;

import java.util.List;

public class PlayController {
    GenerateController generateController;
    ValidateController validateController;
    GameOutput gameOutput;
    GameState gameState;
    private GameNumber gameNumber;
    private GameNumber userGameNumber;

    public PlayController(Integer length) {
        this.gameNumber = new GameNumber();
        this.userGameNumber = new GameNumber();

        this.generateController = new GenerateController();
        this.validateController = new ValidateController();
        this.gameOutput = new GameOutput();

        this.gameState = new GameState();
    }

    public void generateNumber() {
        List<Integer> generatedNumber = generateController.createRandomNumber(gameState.getMaximumNumberLength());
        gameNumber.setNumber(generatedNumber);
    }

    public boolean isSuccess(String input) {
        List<Integer> stringToIntegerList = generateController.stringToIntegerList(input); // 입력 변환 : String -> List<Integer>
        validateController.validateInputIntegerList(stringToIntegerList, gameState.getMaximumNumberLength()); // 입력 검사

        userGameNumber.setNumber(stringToIntegerList);

        matchingBallAndStrike();

        Integer ballCount = gameState.getBallCount();
        Integer strikeCount = gameState.getStrikeCount();
        gameOutput.printResult(ballCount, strikeCount);

        if (strikeCount == gameState.getMaximumNumberLength()) {
            return true;
        }

        return false;
    }

    private void matchingBallAndStrike() {
        gameState.initCount();

        List<Integer> computerNumbers = gameNumber.getNumber();
        List<Integer> userNumbers = userGameNumber.getNumber();

        for (Integer currentNumber : userNumbers) {
            Integer userIdx = userNumbers.indexOf(currentNumber);
            Integer computerIdx = computerNumbers.indexOf(currentNumber);

            if (userIdx == computerIdx) gameState.increaseStrikeCount();
            else if (computerIdx != -1) gameState.increaseBallCount();
        }
    }
}
