package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class GameRunner {
    void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean exitFlag;
        do {
            List<Integer> computerNumber = generateRandomNumbers();
            while (true) {
                List<Integer> playerNumber = inputPlayerNumber();
                int balls = countBall(computerNumber, playerNumber);
                int strikes = countStrike(computerNumber, playerNumber);
                printResult(balls, strikes);
                if (strikes == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            exitFlag = askExit();
        } while (!exitFlag);
    }

    static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    void printResult(int balls, int strikes) {
        if (balls == 0 & strikes == 0) {
            System.out.println("낫싱");
        } else if (balls > 0 && strikes > 0) {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
        } else if (balls > 0) {
            System.out.printf("%d볼\n", balls);
        } else if (strikes > 0) {
            System.out.printf("%d스트라이크\n", strikes);
        }
    }

    List<Integer> inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input;
        List<Integer> number;
        try {
            input = Console.readLine();
            int[] intArray = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
            number = Arrays.stream(intArray).boxed().collect(Collectors.toList());
            validateNumber(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.");
        }
        return number;
    }

    void validateNumber(List<Integer> number) {
        if (number.size() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.");
        }
        Set<Integer> numberSet = new HashSet<>(number);
        if (numberSet.size() != number.size()) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.");
        }
        for (int index = 0; index < 3; index++) {
            if (number.get(index) < 1) {
                throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.");
            }
        }
    }

    int countBall(List<Integer> computerNumber, List<Integer> playerNumber) {
        int ball = 0;
        for (int index = 0; index < 3; index++) {
            if (computerNumber.contains(playerNumber.get(index)) && !(computerNumber.get(index).equals(playerNumber.get(index)))) {
                ball++;
            }
        }
        return ball;
    }

    int countStrike(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (computerNumber.contains(playerNumber.get(index)) && (computerNumber.get(index).equals(playerNumber.get(index)))) {
                strike++;
            }
        }
        return strike;
    }

    boolean askExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input;
        input = Integer.parseInt(Console.readLine());
        if (input == 1) {
            return false;
        } else if (input == 2) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.");
    }
}
