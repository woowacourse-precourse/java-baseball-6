import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            playGame();

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice != 1) {
                break;
            }
        }
    }

    private static void playGame() {
        List<Integer> computer = generateRandomNumbers();
        System.out.println("컴퓨터가 숫자를 선택했습니다. 게임을 시작합니다!");

        int attempts = 0;
        while (true) {
            System.out.print("서로 다른 3자리 숫자를 입력해주세요: ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();
            if (!isValidInput(userInput)) {
                System.out.println("올바른 입력이 아닙니다. 서로 다른 3자리 숫자를 입력해주세요.");
                continue;
            }

            attempts++;
            int[] userGuess = parseUserInput(userInput);
            int[] result = calculateResult(computer, userGuess);

            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("시도 횟수: " + attempts);
                break;
            } else {
                printResult(result);
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        Random random = new Random();

        while (computer.size() < 3) {
            int randomNumber = random.nextInt(9) + 1;
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static boolean isValidInput(String input) {
        return input.matches("^[1-9]{3}$");
    }

    private static int[] parseUserInput(String userInput) {
        int[] userGuess = new int[3];
        for (int i = 0; i < 3; i++) {
            userGuess[i] = userInput.charAt(i) - '0';
        }
        return userGuess;
    }

    private static int[] calculateResult(List<Integer> computer, int[] userGuess) {
        int[] result = new int[2]; // [볼의 개수, 스트라이크의 개수]

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(userGuess[i])) {
                result[1]++; // 스트라이크
            } else if (computer.contains(userGuess[i])) {
                result[0]++; // 볼
            }
        }

        return result;
    }

    private static void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] == 0) {
            System.out.println(result[1] + "스트라이크");
        } else if (result[1] == 0) {
            System.out.println(result[0] + "볼");
        } else {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        }
    }
}
