package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    public static void main(String[] args) {
        // 컴퓨터가 생각하고 있는 숫자를 생성합니다.
        int[] computerNumbers = generateRandomNumbers(3);

        // 게임을 시작합니다.
        startGame(computerNumbers);
    }

    private static void startGame(int[] computerNumbers) {
        // 게임 시작을 알립니다.
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임을 반복합니다.
        while (true) {
            // 사용자로부터 숫자를 입력받습니다.
            int[] userNumbers = getValidUserNumbers();

            // 입력한 숫자에 대한 결과를 출력합니다.
            printResult(userNumbers, computerNumbers);

            // 게임이 종료되었는지 확인합니다.
            if (isGameOver(userNumbers, computerNumbers)) {
                break;
            }
        }

        // 게임이 종료되었음을 알립니다.
        System.out.println("게임 종료");
    }

    private static int[] generateRandomNumbers(int n) {
        // 1~9 사이의 난수를 생성합니다.
        Random random = new Random();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(MAX_NUMBER) + 1;
        }

        // 중복된 숫자가 없도록 정렬합니다.
        Arrays.sort(numbers);

        return numbers;
    }

    private static int[] getValidUserNumbers() {
        // 사용자로부터 숫자를 입력받습니다.
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();

        // 입력한 숫자를 3자리의 정수 배열로 변환합니다.
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(input.charAt(2 * i) + "" + input.charAt(2 * i + 1));
        }

        // 입력한 숫자가 유효한지 확인합니다.
        if (!isValidNumbers(numbers)) {
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }

        return numbers;
    }

    private static boolean isValidNumbers(int[] numbers) {
        // 숫자가 1~9 사이의 정수인지 확인합니다.
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                return false;
            }
        }

        // 숫자가 서로 다른지 확인합니다.
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (numbers[i] == numbers[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printResult(int[] userNumbers, int[] computerNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers[i]) {
                strike++;
            } else if (Arrays.stream(computerNumbers).anyMatch(number -> number == userNumbers[i])) {
                ball++;
            }
        }

        System.out.println(strike + "스트라이크 " + ball + "볼");
    }

    private static boolean isGameOver(int[] userNumbers, int[] computerNumbers) {
        return Arrays.equals(userNumbers, computerNumbers);
    }
}
