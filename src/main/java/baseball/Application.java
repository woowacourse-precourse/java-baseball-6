package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static final int NUMBER_SIZE = 3;
    private static final int CONTINUE_CHOICE = 1;
    private static final int EXIT_CHOICE = 2;

    private static void playBaseball() {
        int numOfBall, numOfStrike;
        List<Integer> computerNumber = getComputerNumber();
        do {
            List<Integer> playerNumber = getPlayerNumber();
            numOfBall = getNumberOfBall(computerNumber, playerNumber);
            numOfStrike = getNumberOfStrike(computerNumber, playerNumber);
            printBaseballResult(numOfBall, numOfStrike);
        } while(numOfStrike < NUMBER_SIZE);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void printBaseballResult(int numOfBall, int numOfStrike) {
        if (numOfBall == 0 && numOfStrike == 0) {
            System.out.println("낫싱");
            return;
        }
        String result = "";
        if (numOfBall > 0)
            result += (numOfBall + "볼 ");
        if (numOfStrike > 0)
            result += (numOfStrike + "스트라이크");
        System.out.println(result);
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
            for (int i = 1; i < NUMBER_SIZE; i++) {
                if (computer == playerNumber.get((index + i) % NUMBER_SIZE))
                    ballCount++;
            }
        }
        return ballCount;
    }

    private static List<Integer> getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();

        if (playerInput.length() != NUMBER_SIZE)
            throw new IllegalArgumentException("세자리 입력해야 합니다.");

        try {
            return Arrays.stream(playerInput.split(""))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
        do playBaseball(); while(askToContinue() == CONTINUE_CHOICE);
    }
}
