package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNumbers;
        List<Integer> playerNumbers;

        displayGameStartMessage();
        computerNumbers = generateComputerNumbers();
        playerNumbers = inputPlayerNumbers();
    }

    public static void displayGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> generateComputerNumbers() {
        List<Integer> computerNumbers;

        computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber;

            randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public static List<Integer> inputPlayerNumbers() {
        String input;
        List<Integer> playerNumbers;
        Set<Integer> playerNumbersSet;

        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }

        playerNumbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                throw new IllegalArgumentException("1~9로 이루어진 3자리의 수를 입력해주세요.");
            }
            playerNumbers.add(input.charAt(i) - '0');
        }

        playerNumbersSet = new HashSet<>(playerNumbers);

        if (playerNumbersSet.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자로 이루어진 수를 입력해주세요.");
        }
        return playerNumbers;
    }
}
