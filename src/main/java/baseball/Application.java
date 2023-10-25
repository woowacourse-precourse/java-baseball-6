package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        startGame();
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = generateRandomNumbers();

        while (true) {
            playGame(computer);

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Integer.parseInt(Console.readLine());

            if (choice == 2) {
                System.out.println("게임을 종료합니다. 감사합니다!");
                break;
            } else if (choice == 1) {
                computer = generateRandomNumbers();
            } else {
                System.out.print("올바른 수를 입력하세요.");
            }
        }
    }

    public static void playGame(List<Integer> computer) {

        while (true) {
            List<Integer> playerNumbers = getPlayerInput();
            int[] result = checkGuess(computer, playerNumbers);

            if (result[1] == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if (result[0] == 0 && result[1] == 0) {
                System.out.println("낫싱");
            } else {
                System.out.println( result[0] + "볼 " + result[1] + "스트라이크" );
            }
        }
    }

    public static List<Integer> getPlayerInput() {
        List<Integer> playerNumbers = new ArrayList<>();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            try {
                // 사용자 입력 파싱
                for (int i = 0; i < 3; i++) {
                    char digitChar = input.charAt(i);
                    int digit = Character.getNumericValue(digitChar);
                    if (digit < 1 || digit > 9) {
                        throw new IllegalArgumentException("1부터 9까지의 수를 입력하세요.");
                    }
                    playerNumbers.add(digit);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                playerNumbers.clear();
            }
        }

        return playerNumbers;
    }

    public static int[] checkGuess(List<Integer> computer, List<Integer> playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int playerDigit = playerNumbers.get(i);
            int computerDigit = computer.get(i);

            if (playerDigit == computerDigit) {
                strikes++;
            } else if (computer.contains(playerDigit)) {
                balls++;
            }
        }

        return new int[]{balls, strikes};
    }

}