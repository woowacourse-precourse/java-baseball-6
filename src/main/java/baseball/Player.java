package baseball;

import static baseball.Computer.COUNTS;
import static baseball.Computer.MAXIMUM_NUMBER;
import static baseball.Computer.MINIMUM_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            validatePlayerNumbers(playerNumbers);

            strike = computer.checkStrikeCount(playerNumbers);
            ball = computer.checkBallCount(playerNumbers);
            printBallCount();
        }
    }

    private void validateNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not an Integer.");
        }
    }

    private void validatePlayerNumbers(List<Integer> playerNumbers) {
        validateCount(playerNumbers);
        validateRange(playerNumbers);
        validateDuplicates(playerNumbers);
    }

    private void validateCount(List<Integer> playerNumbers) {
        if (playerNumbers.size() != COUNTS) {
            throw new IllegalArgumentException("");
        }
    }

    private void validateRange(List<Integer> playerNumbers) {
        boolean isInvalid = playerNumbers.stream()
                .anyMatch(number -> number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER);
        if (isInvalid) {
            throw new IllegalArgumentException("the input range is invalid.");
        }
    }

    private void validateDuplicates(List<Integer> playerNumbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int number : playerNumbers) {
            if (numberSet.contains(number)) {
                throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
            }
            numberSet.add(number);
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

    public void printBallCount() {
        String result = "";
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        } else if (ball == 0 && strike > 0) {
            result = strike + "스트라이크";
        } else if (ball > 0 && strike == 0) {
            result = ball + "볼";
        } else if (ball > 0 && strike > 0) {
            result = ball + "볼" + " " + strike + "스트라이크";
        }
        System.out.println(result);
    }
}
