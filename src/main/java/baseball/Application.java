package baseball;

import java.util.*;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자야구 게임을 시작합니다. 1부터 9까지의 숫자 중 중복되지 않는 3자리 숫자를 맞춰보세요.");

        Scanner scanner = new Scanner(System.in);  // Scanner를 main 메소드 내에서 선언
        List<Integer> computer = generateRandomNumber();
        int attempts = 0;

        while (true) {
            List<Integer> userGuess = getUserGuess();  // scanner를 getUserGuess 메소드에 전달
            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (userGuess.get(i).equals(computer.get(i))) {
                    strikes++;
                } else if (computer.contains(userGuess.get(i))) {
                    balls++;
                }
            }

            System.out.println("결과: " + strikes + " 스트라이크, " + balls + " 볼");
            attempts++;

            if (strikes == 3) {
                System.out.println("축하합니다! " + attempts + "번 만에 숫자를 맞추셨습니다.");
                System.out.print("게임을 종료하려면 1, 재시작하려면 2를 입력하세요: ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    break; // 게임 종료
                } else if (choice == 2) {
                    // 게임을 다시 시작 (원하는 동작 수행)
                } else {
                    System.out.println("올바른 선택이 아닙니다. 다시 입력하세요.");
                }
            }
        }
    }



    private static List<Integer> generateRandomNumber() {
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

    private static List<Integer> getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> userGuess = new ArrayList<>();

        System.out.print("숫자 3자리를 입력하세요 (1부터 9까지, 중복 없이): ");
        try {
            int number = scanner.nextInt();
            if (number < 100 || number > 999) {
                throw new InputMismatchException("올바른 입력이 아닙니다. 3자리 숫자를 입력하세요.");
            }

            int digit;
            Set<Integer> digitSet = new HashSet<>();

            while (number > 0) {
                digit = number % 10;
                if (digit < 1 || digit > 9 || digitSet.contains(digit)) {
                    throw new InputMismatchException("올바른 입력이 아닙니다. 1부터 9까지의 중복되지 않는 숫자로 입력하세요.");
                }
                digitSet.add(digit);
                userGuess.add(digit);
                number /= 10;
            }
            if (userGuess.size() != 3) {
                throw new InputMismatchException("올바른 입력이 아닙니다. 3자리 숫자를 입력하세요.");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return getUserGuess();
        }
        return userGuess;
    }
}
