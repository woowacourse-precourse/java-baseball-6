package baseball;

import static baseball.Computer.COUNTS;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Player {
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private Computer computer = new Computer();
    private int strike;
    private int ball;

    public Player() {
    }

    public void init() {
        computer.init();
        strike = 0;
        ball = 0;
    }

    public void play() {
        List<Integer> userNumbers;
        while (strike < COUNTS) {
            System.out.print(INPUT_REQUEST_MESSAGE);
            String userInput = Console.readLine();
            validateNumber(userInput);
        }
    }

    private void validateNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not an Integer.");
        }
    }
}
