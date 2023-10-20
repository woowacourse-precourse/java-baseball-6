package baseball.gameLogic;

import baseball.models.Computer;

import java.util.List;

public class ComputerAction {
    public Computer computer = new Computer();
    public void generateNumber(){
        computer.numberList = computer.randomNumberGenerator.generateRandomNumber();
    }
}
