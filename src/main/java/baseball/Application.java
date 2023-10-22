package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static void playBaseBall() {
        int numOfBall, numOfStrike;
        List<Integer> computerNumber = getComputerNumber();
        do {
            List<Integer> playerNumber = getPlayerNumber();
            numOfBall = getNumberOfBall(computerNumber, playerNumber);
            numOfStrike = getNumberOfStrike(computerNumber, playerNumber);
            printBaseBallResult(numOfBall, numOfStrike);
        } while(numOfStrike < 3);
    }

    private static List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while(computerNumber.size() < 3) {
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
            playBaseBall();
            choice = askToContinue();
        } while(choice == 1);
    }
}
