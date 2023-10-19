package baseball.controller;

import baseball.model.GameNumber;

import java.util.List;

public class PlayController {
    final Integer MAXIMUM_NUMBER_LENGTH = 3;
    private GameNumber gameNumber;

    GenerateController generateController;

    public PlayController(GenerateController generateController) {
        this.gameNumber = new GameNumber();
        this.generateController = generateController;
    }

    public void generateNumber() {
        List<Integer> generatedNumber = generateController.createRandomNumber(MAXIMUM_NUMBER_LENGTH);
        gameNumber.setNumber(generatedNumber);
    }
}
