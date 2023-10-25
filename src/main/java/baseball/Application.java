package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int GAME_NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        do {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while ("1".equals(Console.readLine()));
    }

    private static void playGame() {
        List<Integer> computerNumbers = generateRandomNumbers();
        boolean gameEnd = false;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!gameEnd) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            gameEnd = processUserInput(computerNumbers, userInput);
        }
    }

    private static boolean processUserInput(List<Integer> computerNumbers, String userInput) {
        if (userInput.length() != GAME_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        List<Integer> userNumbers = convertStringToList(userInput);

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        if (strikes == 3) {
            System.out.println("3스트라이크\n");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            return true;
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }

        return false;
    }

    private static List<Integer> convertStringToList(String userInput) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : userInput.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
