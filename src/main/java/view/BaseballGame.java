package view;

import number.ComputerNumber;
import number.ComputerNumberGenerator;

public class BaseballGame {

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        run();
    }

    public void run() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        ComputerNumber computerNumber = computerNumberGenerator.createComputerNumber();

    }
}
