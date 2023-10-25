package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int[] computerNumbers;

    public static void main(String[] args) {
        gameStart();
    }

    private static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다");

        do {
            computerNumbers = randomNumbers();

            while (true) {
                System.out.print("숫자를 입력해주세요: ");

                String userInput = Console.readLine();

                int[] userNumbers = parseUserInput(userInput);
                int[] result = calculateResult(userNumbers);

                displayResult(result);

                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
        } while (askRetry());
    }

    public static boolean askRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        return choice.equals("1");
    }

    private static int[] parseUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 수를 입력하세요.");
        }
        int[] userNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            userNumbers[i] = userInput.charAt(i) - '0';
        }
        return userNumbers;
    }

    private static int[] randomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int[] computerArray = new int[3];
        for (int i = 0; i < 3; i++) {
            computerArray[i] = computer.get(i);
        }
        return computerArray;
    }

    private static int[] calculateResult(int[] userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers[i]) {
                strikes++;
            } else if (contains(computerNumbers, userNumbers[i])) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }

    private static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    private static void displayResult(int[] result) {
        int strikes = result[0];
        int balls = result[1];

        if (strikes > 0 && balls > 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        } else if (strikes > 0) {
            System.out.println(strikes + "스트라이크");
        } else if (balls > 0) {
            System.out.println(balls + "볼");
        } else {
            System.out.println("낫싱");
        }
    }
}
