package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        boolean keepPlaying = true;

        while (keepPlaying) {
            List<Integer> computerNumbers = generateRandomNumbers();
            boolean gameWon = false;

            while (!gameWon) {
                System.out.print("숫자를 입력해주세요 :");
                String userInput = Console.readLine();
                gameWon = checkUserInput(computerNumbers, userInput);
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            keepPlaying = "1".equalsIgnoreCase(Console.readLine());
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int nextRandom = Randoms.pickNumberInRange(1,9);
            if (!numbers.contains(nextRandom)) {
                numbers.add(nextRandom);
            }
        }

        return numbers;
    }

    private static boolean checkUserInput(List<Integer> computerNumbers, String userInput) {
        if (userInput.length() != 3) {
            System.out.println("3자리를 입력해주세요");
            return false;
        }

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int userNum = Character.getNumericValue(userInput.charAt(i));

            if (computerNumbers.get(i) == userNum) {
                strikes++;
            } else if (computerNumbers.contains(userNum)) {
                balls++;
            }
        }

        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strikes > 0 || balls > 0) {
            System.out.println(balls + "볼" +strikes + "스트라이크");
        } else {
            System.out.println("낫싱");
        }

        return false;
    }
}

