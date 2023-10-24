package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Application {

    private static final int NUMBER_SIZE = 3;
    private static final int CONTINUE_CHOICE = 1;
    private static final int EXIT_CHOICE = 2;

    private static void playBaseball() {
        int numberOfBalls, numberOfStrikes;
        List<Integer> computerNumber = getComputerNumber();

        do {
            List<Integer> playerNumber = getPlayerNumber();
            numberOfBalls = getNumberOfBalls(computerNumber, playerNumber);
            numberOfStrikes = getNumberOfStrikes(computerNumber, playerNumber);
            printBaseballResult(numberOfBalls, numberOfStrikes);
        } while (numberOfStrikes < NUMBER_SIZE);

        System.out.println(NUMBER_SIZE + " 개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void printBaseballResult(int numberOfBalls, int numberOfStrikes) {
        StringBuilder resultBuilder = new StringBuilder();

        if (numberOfBalls == 0 && numberOfStrikes == 0) {
            resultBuilder.append("낫싱");
        } else {
            if (numberOfBalls > 0)
                resultBuilder.append(numberOfBalls).append("볼 ");
            if (numberOfStrikes > 0)
                resultBuilder.append(numberOfStrikes).append("스트라이크");
        }

        System.out.println(resultBuilder);
    }

    private static int getNumberOfStrikes(List<Integer> computerNumber, List<Integer> playerNumber) {
        int numberOfStrikes = 0;
        for (int index = 0; index < NUMBER_SIZE; index++) {
            if (playerNumber.get(index).equals(computerNumber.get(index)))
                numberOfStrikes++;
        }
        return numberOfStrikes;
    }

    private static int getNumberOfBalls(List<Integer> computerNumber, List<Integer> playerNumber) {
        int numberOfBalls = 0;
        for (int computerIndex = 0; computerIndex < NUMBER_SIZE; computerIndex++) {
            int computerDigit = computerNumber.get(computerIndex);

            for (int playerIndex = 0; playerIndex < NUMBER_SIZE; playerIndex++) {
                if (computerIndex != playerIndex) {
                    int playerDigit = playerNumber.get(playerIndex);
                    if (computerDigit == playerDigit) {
                        numberOfBalls++;
                    }
                }
            }
        }
        return numberOfBalls;
    }

    private static List<Integer> getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        try {
            List<Integer> integerList = Arrays.stream(Console.readLine().split(""))
                    .map(Integer::parseInt)
                    .toList();

            if (!isValidInput(integerList)) {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
            return integerList;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }

    private static boolean isValidInput(List<Integer> input) {
        return input.size() == NUMBER_SIZE && !hasDuplicates(input) && !input.contains(0);
    }

    private static boolean hasDuplicates(List<Integer> input) {
        return input.size() > new HashSet<>(input).size();
    }

    private static List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while(computerNumber.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    private static int askToContinue() {
        System.out.println("게임을 새로 시작하려면 " + CONTINUE_CHOICE + ", 종료하려면 " + EXIT_CHOICE + "를 입력하세요.");
        String continueOrNot = Console.readLine();

        if (!isValidChoice(continueOrNot)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        return Integer.parseInt(continueOrNot);
    }

    private static boolean isValidChoice(String choice) {
        return (choice.equals(String.valueOf(CONTINUE_CHOICE)) || choice.equals(String.valueOf(EXIT_CHOICE)));
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do playBaseball(); while (askToContinue() == CONTINUE_CHOICE);
    }
}
