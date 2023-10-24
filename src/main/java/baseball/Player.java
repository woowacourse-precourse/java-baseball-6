package baseball;

import static baseball.Computer.COUNTS;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
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
        List<Integer> playerNumbers;
        while (strike < COUNTS) {
            System.out.print(INPUT_REQUEST_MESSAGE);
            String playerInput = Console.readLine();
            validateNumber(playerInput);
            playerNumbers = convertToIntegerList(playerInput);
        }
    }

    private void validateNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not an Integer.");
        }
    }

    private List<Integer> convertToIntegerList(String userInput) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (Character.isDigit(c)) {
                integerList.add(Character.getNumericValue(c));
            }
        }
        return integerList;
    }
}
