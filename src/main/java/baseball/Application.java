package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private static final int NUMBER_COUNT = 3;
//    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
//    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
//    private static final String GAME_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
//    private static final String ALL_STRIKES_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String GAME_START_MESSAGE = "Starting the Baseball Game!";
    private static final String INPUT_NUMBER_MESSAGE = "Please enter the numbers: ";
    private static final String GAME_END_MESSAGE = "To start a new game, press 1. To exit, press 2.";
    private static final String ALL_STRIKES_MESSAGE = "You guessed all numbers! Game over.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GAME_START_MESSAGE);
        while (true) {
            List<Integer> computerNumbers = generateComputerNumbers();
            boolean isGameEnded = playGame(computerNumbers);
            if (isGameEnded) {
                System.out.println(GAME_END_MESSAGE);
                String userInput = Console.readLine();
                if ("2".equals(userInput)) {
                    break;
                }
            }
        }

    }

    private static List<Integer> generateComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }


    private static boolean playGame(List<Integer> computerNumbers) {
        while(true) {
            System.out.println(INPUT_NUMBER_MESSAGE);
            List<Integer> userNumbers = parseInputNumbers(Console.readLine());
            int strikes = countStrikes(computerNumbers, userNumbers);
            if(strikes == NUMBER_COUNT) {
                System.out.println(ALL_STRIKES_MESSAGE);
                return true;
            }
            int balls = countBalls(computerNumbers, userNumbers) - strikes;
            printResult(strikes, balls);
        }
    }

    private static List<Integer> parseInputNumbers(String input) {
        if(input.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException("Input should be "+NUMBER_COUNT+" digits.");
        }
        List<Integer> numbers = new ArrayList<>();
        for(char ch : input.toCharArray()) {
            int number = ch - '0';
            if(number < MIN_NUMBER || number > MAX_NUMBER || numbers.contains(number)) {
                throw new IllegalArgumentException("Invalid input.");
            }
            numbers.add(number);
        }
        return numbers;
    }

    private static int countStrikes(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        for(int i=0; i<NUMBER_COUNT; i++) {
            if(computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    private static int countBalls(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int balls = 0;
        for (int userNumber : userNumbers) {
            if (computerNumbers.contains(userNumber)) {
                balls++;
            }
        }
        return balls;
    }

    private static void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("nothing");
            return;
        }
        if (balls > 0) {
            System.out.print(balls + "ball ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "strike");
        }
        System.out.println();
    }

}

