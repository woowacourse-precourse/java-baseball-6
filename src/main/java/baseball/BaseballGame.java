package baseball;

import java.util.List;

public class BaseballGame {

    public void play() {
        printStart();
        List<Integer> computerNumbers = getComputerNumber();


    }

    private List<Integer> getComputerNumber() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.selectNumbers();
        return computerNumbers;
    }

    private void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}

