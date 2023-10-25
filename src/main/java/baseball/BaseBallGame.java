package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private static final int INPUT_LENGTH = 3;
    private static final String RESTART_NUMBER = "1";
    private static final String QUIT_NUMBER = "2";

    private Computer computer = new Computer();
    private User user = new User();

    private int ballCount = 0;
    private int strikeCount = 0;


    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean quit = false;
        computer.generateComputerBaseBallNumber();

        while (!quit) {
            user.getUserInput();
            gameResultCalculation();
            printResultMessage();
            quit = isGameEnd();
        }
    }
}
