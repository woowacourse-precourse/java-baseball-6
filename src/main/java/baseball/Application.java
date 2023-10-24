package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean playAgain = true;
        while (playAgain) {
            int[] computerNumbers = generateRandomNumbers();
            int attempts = 0;

            while (true) {
                int[] userGuess = null;
                try {
                    userGuess = getUserGuess();
                } catch (IllegalArgumentException e) {
                    // 사용자가 잘못된 값을 입력한 경우 예외 처리
                    System.out.println(e.getMessage());
                    System.out.println("게임을 종료합니다.");
                    System.exit(0); // 프로그램 종료
                }
                attempts++;

                if (isCorrectGuess(computerNumbers, userGuess)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    int[] result = calculateResult(computerNumbers, userGuess);
                    if (result[0] == 0 && result[1] == 0) {
                        System.out.println("낫싱");
                    } else {
                        System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
                    }
                }
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(Console.readLine());
            if (choice == 2) {
                playAgain = false;
            }
        }

        System.out.println("게임을 종료합니다.");
    }

    private static boolean isCorrectGuess(int[] computerNumbers, int[] userGuess) {
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] != userGuess[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] generateRandomNumbers() {
        int[] computerNumbers = new int[3];
        int index = 0;
        while (index < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            boolean exists = false;
            for (int i = 0; i < index; i++) {
                if (computerNumbers[i] == randomNumber) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                computerNumbers[index] = randomNumber;
                index++;
            }
        }

        return computerNumbers;
    }

    private static int[] getUserGuess() {
        int[] userGuess = new int[3];
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();
            if (input.length() != 3) {
                throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
            }

            boolean validInput = true;
            for (int i = 0; i < 3; i++) {
                char c = input.charAt(i);
                if (c < '1' || c > '9') {
                    throw new IllegalArgumentException("");
                }
                userGuess[i] = c - '0';
            }

            if (validInput) {
                break;
            }
        }

        return userGuess;
    }

    private static int[] calculateResult(int[] computerNumbers, int[] userGuess) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userGuess[i]) {
                result[0]++;
            } else if (contains(computerNumbers, userGuess[i])) {
                result[1]++;
            }
        }

        return result;
    }

    private static boolean contains(int[] arr, int num) {
        for (int value : arr) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }
}


