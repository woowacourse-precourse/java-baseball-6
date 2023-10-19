package baseball.controller;

import baseball.model.GameNumber;

import java.util.List;

public class PlayController {
    private final Integer MAXIMUM_NUMBER_LENGTH;
    private GameNumber gameNumber;

    GenerateController generateController;

    public PlayController(GenerateController generateController, Integer length) {
        this.gameNumber = new GameNumber();
        this.generateController = generateController;
        this.MAXIMUM_NUMBER_LENGTH = length;
    }

    public void generateNumber() {
        List<Integer> generatedNumber = generateController.createRandomNumber(MAXIMUM_NUMBER_LENGTH);
        gameNumber.setNumber(generatedNumber);
    }
}
