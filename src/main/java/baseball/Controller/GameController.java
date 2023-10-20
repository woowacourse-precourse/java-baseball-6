package baseball.Controller;

import baseball.ComputerNumberGenerator;

public class GameController {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "숫자 야구 게임을 종료합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력하세요.";


    public GameController() {
        System.out.println(START_MESSAGE);
    }

    public void run() {
        String ComputerNumber = ComputerNumberGenerator.generate();
        System.out.println(ComputerNumber);
    }
}
