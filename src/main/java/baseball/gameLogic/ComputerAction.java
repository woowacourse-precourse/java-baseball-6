package baseball.gameLogic;

import java.util.List;

public class ComputerAction {
    public List<Integer> numberList;
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    public void generateNumber(){
        numberList = randomNumberGenerator.generateRandomNumber();
    }
}
