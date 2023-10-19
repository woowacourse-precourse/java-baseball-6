package baseball.controller;

import baseball.model.GameNumber;

import java.util.List;

public class PlayController {
    private final Integer MAXIMUM_NUMBER_LENGTH;
    private GameNumber gameNumber;
    private GameNumber userGameNumber;
    private Integer ballCount;
    private Integer strikeCount;


    GenerateController generateController;
    ValidateController validateController;

    public PlayController(GenerateController generateController, ValidateController validateController, Integer length) {
        this.gameNumber = new GameNumber();
        this.userGameNumber = new GameNumber();

        this.generateController = generateController;
        this.validateController = validateController;

        this.MAXIMUM_NUMBER_LENGTH = length;
    }

    public void generateNumber() {
        List<Integer> generatedNumber = generateController.createRandomNumber(MAXIMUM_NUMBER_LENGTH);
        gameNumber.setNumber(generatedNumber);
    }

    public boolean isSuccess(String input) {
        List<Integer> stringToIntegerList = generateController.stringToIntegerList(input);
        validateController.validateInputIntegerList(stringToIntegerList, MAXIMUM_NUMBER_LENGTH);

        userGameNumber.setNumber(stringToIntegerList);

        matchingBallAndStrike();

        return false;
    }

    private void matchingBallAndStrike() {
        ballCount = 0;
        strikeCount = 0;

        List<Integer> computerNumbers = gameNumber.getNumber();
        List<Integer> userNumbers = userGameNumber.getNumber();

        for (Integer currentNumber : userNumbers) {
            Integer userIdx = userNumbers.indexOf(currentNumber);
            Integer computerIdx = computerNumbers.indexOf(currentNumber);

            if (userIdx == computerIdx) ++strikeCount;
            else if (computerIdx != -1) ++ballCount;
        }
    }
}
