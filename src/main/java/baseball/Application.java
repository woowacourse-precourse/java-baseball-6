import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int[] computerNumber = generateRandomNumber();
            int attempts = 0;

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (true) {
                System.out.print("숫자를 입력해주세요: ");
                String input = scanner.nextLine();

                if (input.length() != 3 || !input.matches("[0-9]+")) {
                    System.out.println("유효하지 않은 입력입니다. 0부터 9까지의 서로 다른 3자리 숫자를 입력하세요.");
                    continue;
                }

                int[] userGuess = new int[3];
                for (int i = 0; i < 3; i++) {
                    userGuess[i] = input.charAt(i) - '0';
                }

                int[] result = checkGuess(userGuess, computerNumber);

                if (result[0] == 0 && result[1] == 0) {
                    System.out.println("낫싱");
                } else if (result[0] == 0) {
                    System.out.println(result[1] + "스트라이크");
                } else if (result[1] == 0) {
                    System.out.println(result[0] + "볼");
                } else {
                    System.out.println(result[0] + "볼" + " " + result[1] + "스트라이크");
                }


                attempts++;

                if (result[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String choice = scanner.nextLine();
            if (choice.equals("2")) {
                break;
            }
        }

        scanner.close();
    }

    public static int[] generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber;
            do {
                randomNumber = new Random().nextInt(9) + 1; // 1부터 9 사이의 숫자 생성
            } while (computer.contains(randomNumber));
            computer.add(randomNumber);
        }

        int[] number = new int[3];
        for (int i = 0; i < 3; i++) {
            number[i] = computer.get(i);
        }

        return number;
    }


    public static boolean containsDigit(int[] array, int digit) {
        for (int num : array) {
            if (num == digit) {
                return true;
            }
        }
        return false;
    }

    public static int[] checkGuess(int[] userGuess, int[] computerNumber) {
        int[] result = new int[2]; // result[0]는 볼, result[1]은 스트라이크

        for (int i = 0; i < 3; i++) {
            if (userGuess[i] == computerNumber[i]) {
                result[1]++;
            } else if (containsDigit(computerNumber, userGuess[i])) {
                result[0]++;
            }
        }

        return result;
    }
}

