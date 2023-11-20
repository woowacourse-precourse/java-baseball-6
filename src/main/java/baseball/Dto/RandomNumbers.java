package baseball.Dto;

import java.util.List;

public class RandomNumbers {
    private RandomNumber randomNumber;
    private static RandomNumbers instance;

    private RandomNumbers() {
        this.randomNumber = new RandomNumber();
    }

    public static synchronized RandomNumbers getInstance() {
        if (instance == null) {
            instance = new RandomNumbers();
        }
        return instance;
    }

    public void generateNewRandomNumbers() {
        randomNumber.createRandomNumber();
    }

    public List<Integer> requestRandomNumbers() {
        return randomNumber.requestComputer();
    }
}