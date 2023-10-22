package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static final int NUMBER_SIZE = 3;

    private static void playBaseball() {
        int numOfBall, numOfStrike;
        List<Integer> computerNumber = getComputerNumber();
        do {
            List<Integer> playerNumber = getPlayerNumber();
            numOfBall = getNumberOfBall(computerNumber, playerNumber);
            numOfStrike = getNumberOfStrike(computerNumber, playerNumber);
            printBaseballResult(numOfBall, numOfStrike);
        } while(numOfStrike < NUMBER_SIZE);
    }

    private static int getNumberOfStrike(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strikeCount = 0;
        for (int index = 0; index < NUMBER_SIZE; index++) {
            if (playerNumber.get(index).equals(computerNumber.get(index)))
                strikeCount++;
        }
        return strikeCount;
    }

    private static int getNumberOfBall(List<Integer> computerNumber, List<Integer> playerNumber) {
        int ballCount = 0;
        for (int index = 0; index < NUMBER_SIZE; index++) {
            int computer = computerNumber.get(index);
            for (int i = 1; i <= NUMBER_SIZE; i++) {
                if (computer == playerNumber.get((index + i) % NUMBER_SIZE))
                    ballCount++;
            }
        }
        return ballCount;
    }

    private static List<Integer> getPlayerNumber() {
        String playerInput = Console.readLine();
        try {
            return Arrays.stream(playerInput.split(""))
                    .map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
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
        int choice = Integer.parseInt(Console.readLine());
        if (choice != 1 && choice != 2) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
        return choice;
    }

    public static void main(String[] args) {
        int choice;
        do {
            playBaseball();
            choice = askToContinue();
        } while(choice == 1);
    }
}
