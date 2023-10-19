package baseball.controller;

import baseball.model.GameNumber;

import java.util.List;

public class PlayController {
    final Integer MAXIMUM_NUMBER_LENGTH = 3;
    private GameNumber gameNumber;

    public PlayController() {
        this.gameNumber = new GameNumber();
    }

    public void generateNumber() {
        GenerateController gc = super.generateController;
        List<Integer> generatedNumber = gc.createRandomNumber();
        gameNumber.setNumber(generatedNumber);
    }
}
