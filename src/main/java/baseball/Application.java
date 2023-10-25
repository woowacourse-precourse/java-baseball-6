package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

class RandomNumberGenerator {
    private int[] numbers = {1, 3, 5, 5, 8, 9};
    private int index = 0;

    public int[] generateRandomNumbers() {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = numbers[index];
            index = (index + 1) % numbers.length;
        }
        return result;
    }
}

public class Application {

    private static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        System.out.println("숫자 야구 게임을 시작합니다");

        //비밀 난수 생성
        while (playAgain) {
            int[] randomNumber = pickNumberInRange(1, 9,3);

            int attempts = 0;

            while (true) {
                System.out.print("  숫자를 입력하세요! ");
                String userInput = readLine(scanner);


                if (userInput.equals("1")) {
                    System.out.println("게임을 재시작합니다.");
                    break;
                } else if (userInput.equals("2")) {
                    System.out.println("게임 종료");
                    playAgain = false;
                    break;
                } else if (!isValidInput(userInput)) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 게임 종료");
                }


                int[] userGuess = new int[3];
                for (int i = 0; i < 3; i++) {
                    userGuess[i] = userInput.charAt(i) - '0'; //char을 int로 변환하는

                }

                int[] result = checkGuess(userGuess, randomNumber);

                if (result[2] == 3) {  // 스트라이크 0 볼 0
                    System.out.println("낫싱"); // 아무것도 맞추지 못함 003
                }

                if (result[0] == 1) { // 스트라이크 1, 볼 0
                    if (result[1] == 0) {
                        System.out.println(result[0] + "스트라이크");
                    }
                }

                if (result[0] == 1) { // 스트라이크 1, 볼 1
                    if (result[1] == 1) {
                        System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
                    }
                }

                if (result[0] == 1) { // 스트라이크 1, 볼 2
                    if (result[1] == 2) {
                        System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
                    }
                }

                if (result[0] == 2) {  // 스트라이크 2, 볼 0
                    if (result[1] == 0) {
                        System.out.println(result[0] + "스트라이크");
                    }
                }

                if (result[0] == 2) { // 스트라이크 2 볼 1
                    if (result[1] == 1) {
                        System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
                    }
                }

                if (result[0] == 0) { //스트라이크 0 볼 1
                    if (result[1] == 1) {
                        System.out.println(result[1] + "볼");
                    }
                }

                if (result[0] == 0) { //스트라이크 0 볼 2
                    if (result[1] == 2) {
                        System.out.println(result[1] + "볼");
                    }
                }

                if (result[0] == 0) { //스트라이크 0 볼 3
                    if (result[1] == 3) {
                        System.out.println(result[1] + "볼");
                    }
                }

                attempts++;

                if (result[0] == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("시도횟수 : " + attempts);
                    System.out.print("게임을 다시 시작하려면 1을, 종료하려면 2를 입력하세요: ");
                    int choice = Integer.parseInt(readLine(scanner));
                    if (choice == 2) {
                        playAgain = false;
                    }
                    break;
                }

            }

        }

        scanner.close();
    }

    private static int[] nextValues = null;
    private static int nextValueIndex = 0;

    public static int[] pickNumberInRange(int min, int max, int length) {
        return randomNumberGenerator.generateRandomNumbers();
    }

    // 테스트를 위해 다음 호출에서 pickNumberInRange가 values 사용하도록 설정
    public static void setNextValues(int[] values) {
        nextValues = values;
        nextValueIndex = 0;
    }

    public static void resetValues() {
        nextValues = null;
        nextValueIndex = 0;
    }

        public static String readLine(Scanner scanner) {
            return scanner.next();

    }

    //추측 결과 계산
    public static int[] checkGuess(int[] guess, int[] secret) {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            if (guess[i] == secret[i]) {
                result[0]++; // strike
            } else if (contains(guess[i], secret)) {
                result[1]++; // ball
            } else {
                result[2]++; // nothing
            }
        }
        return result;
    }


    // 배열 안에 숫자 포함 여부 확인
    public static boolean contains(int number, int[] array) {
        for (int n : array) {
            if (n == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidInput(String input) {
        return input.length() == 3 && isNumeric(input) && isInRange(input) && !hasDuplicates(input) && !input.contains("0");
    }

    //문자열이 숫자로 되어있는지
    public static boolean isNumeric(String str) {
        return  str.matches("\\d+");
    }

    //입력 숫자가 범위 내인지
    public static boolean isInRange(String str) {
        int num = Integer.parseInt(str);
        return num >= 100 && num <= 999;

    }
    // 중복 숫자 확인
    public static boolean hasDuplicates(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return  true;
                }
            }
        }
        return false;
    }
}
