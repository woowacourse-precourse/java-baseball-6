package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int EXIT_COUNT = 3;

    public Game() {
    }

    public List<Integer> getTargetNumber() {
        List<Integer> targetArray = new ArrayList<>();
        while (targetArray.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetArray.contains(randomNumber)) {
                targetArray.add(randomNumber);
            }
        }
        return targetArray;
    }

    public List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (!input.matches("\\d{3}") || Util.checkForDuplicates(input.split(""))) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다!");
        }

        List<Integer> inputArray = new ArrayList<>();
        for (char c : input.toCharArray()) {
            inputArray.add(Character.getNumericValue(c));
        }

        return inputArray;
    }

    public int getStrikes(List<Integer> inputArray, List<Integer> targetArray) {
        int strikes = 0;

        for (int i = 0; i < targetArray.size(); i++) {
            if (inputArray.get(i) == targetArray.get(i)) {
                strikes++;
            }
        }

        return strikes;
    }

    public int getBalls(List<Integer> inputArray, List<Integer> targetArray) {
        int balls = 0;

        for (Integer i : inputArray) {
            if (targetArray.contains(i)) {
                balls++;
            }
        }

        return balls - getStrikes(inputArray, targetArray);
    }

    public boolean isGameEnd(int strikes) {
        return strikes == EXIT_COUNT;
    }

    public void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes == 0) {
            System.out.printf("%d볼\n", balls);
        } else if (balls == 0) {
            System.out.printf("%d스트라이크\n", strikes);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
        }

        if (isGameEnd(strikes)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInput = Integer.parseInt(Console.readLine());
        return userInput == 1;
    }
}
