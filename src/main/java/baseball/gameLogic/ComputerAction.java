package baseball.gameLogic;

import java.util.List;

public class Computer {
    public List<Integer> numberList;

    public void generateNumber(RandomNumberGenerator randomNumberGenerator){
        numberList = randomNumberGenerator.generateRandomNumber();
    }
}
