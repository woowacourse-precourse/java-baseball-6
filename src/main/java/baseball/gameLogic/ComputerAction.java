package baseball.gameLogic;

import baseball.models.Computer;

import java.util.List;

import static baseball.utils.RandomNumberGenerator.generateRandomNumberList;

/*
  Computer의 행동들을 수행하는 클래스
*/

public class ComputerAction {
    private final Computer computer = new Computer();

    public void generateNumber(){
        computer.numberList = generateRandomNumberList();
    }

    public List<Integer> getNumberList(){
        return computer.numberList;
    }
}
