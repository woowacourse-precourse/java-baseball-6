package baseball.controller;

import baseball.model.Number;

import java.util.List;

public class ComputerController {

    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void generateRandomNumbers(Number numbers) {
        List<Integer> computerNumbers = randomNumberGenerator.generateRandomNumbers();
        numbers.setComputerNumbers(computerNumbers);
    }
}
