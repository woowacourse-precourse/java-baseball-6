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
    GameNumber gameNumber;
    GameNumber userGameNumber;

    public PlayController() {
        this.gameNumber = new GameNumber();
        this.userGameNumber = new GameNumber();

        this.generateController = new GenerateController();
        this.validateController = new ValidateController();
        this.gameOutput = new GameOutput();

        this.gameState = new GameState();
    }

    public void generateNumber() {
        List<Integer> generatedNumber = generateController.createRandomNumber(GameState.MAXIMUM_NUMBER_LENGTH);
        gameNumber.setNumber(generatedNumber);
    }

    public boolean isSuccess(String input) {
        List<Integer> stringToIntegerList = generateController.stringToIntegerList(input); // 입력 변환 : String -> List<Integer>
        validateController.validateInputIntegerList(stringToIntegerList, GameState.MAXIMUM_NUMBER_LENGTH); // 입력 검사

        userGameNumber.setNumber(stringToIntegerList);

        matchingBallAndStrike();

        Integer ballCount = gameState.getBallCount();
        Integer strikeCount = gameState.getStrikeCount();
        gameOutput.printResult(ballCount, strikeCount);

        return strikeCount.equals(gameState.getMaximumNumberLength()); // 자릿수와 스트라이크의 수가 같다면 종료
    }

    private void matchingBallAndStrike() {
        gameState.initCount();

        List<Integer> computerNumbers = gameNumber.getNumber();
        List<Integer> userNumbers = userGameNumber.getNumber();

        for (Integer currentNumber : userNumbers) {
            int userIdx = userNumbers.indexOf(currentNumber);
            int computerIdx = computerNumbers.indexOf(currentNumber);

            if (userIdx == computerIdx) gameState.increaseStrikeCount();
            else if (computerIdx != -1) gameState.increaseBallCount();
        }
    }
}
