package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final int GAME_ON = 1;

    private static int gameStatus;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playBaseballGame();
    }

    private static void playBaseballGame() {
        gameStatus = GAME_ON;
        List<Integer> randomNumbers = generateRandomNumbers();

        while (gameStatus == GAME_ON) {
            int randomNumber = buildRandomNumber(randomNumbers);
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();

            int userNumber = runException(userInput);
            int[] userDigits = getDigits(userNumber);
            int[] randomDigits = getDigits(randomNumber);
            int strike = countStrikes(userDigits, randomDigits);
            int ball = countBalls(userDigits, randomDigits);
            printResult(strike, ball);

            if (userNumber == randomNumber) {
                handleGameEnd();
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private static int buildRandomNumber(List<Integer> randomNumbers) {
        return randomNumbers.get(0) * 100 + randomNumbers.get(1) * 10 + randomNumbers.get(2);
    }

    // 세자리 숫자 검증
    private static int runException(String input) {
        validateUserInput(input);
        if (input.length() != 3) {
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
        return Integer.parseInt(input);
    }

    // 1 또는 2 입력값 검증
    private static int getUserInput() {
        String input = readLine();
        int num = Integer.parseInt(input);
        validateUserInput(input);
        if (num < 1 || num > 2) {
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
        return num;
    }

    // 문자가 들어 있거나 0이 포함된 입력값 검증
    private static void validateUserInput(String input) {
        boolean isNumeric = true;
        boolean containsZero = false;
        Set<Character> uniqueDigits = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isDigit(ch)) {
                if (ch == '0') {
                    containsZero = true;
                }

                if (uniqueDigits.contains(ch)) {
                    throw new IllegalArgumentException("중복된 숫자를 입력하지 마세요.");
                } else {
                    uniqueDigits.add(ch);
                }
            } else {
                isNumeric = false;
                break;
            }
        }

        if (!isNumeric || containsZero) {
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
    }


    private static int[] getDigits(int number) {
        String numberString = String.valueOf(number);
        int[] digits = new int[numberString.length()];

        for (int i = 0; i < digits.length; i++) {
            digits[i] = Character.getNumericValue(numberString.charAt(i));
        }
        return digits;
    }

    private static int countStrikes(int[] userDigits, int[] randomDigits) {
        int strike = 0;
        for (int i = 0; i < userDigits.length; i++) {
            if (userDigits[i] == randomDigits[i]) {
                strike++;
            }
        }
        return strike;
    }

    private static int countBalls(int[] userDigits, int[] randomDigits) {
        int ball = 0;
        for (int i = 0; i < userDigits.length; i++) {
            for (int j = 0; j < randomDigits.length; j++) {
                if (i != j && userDigits[i] == randomDigits[j]) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private static void printResult(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크 ");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    // 정답 시 게임 재시작 혹은 종료 처리
    private static void handleGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameStatus = getUserInput();
        if (gameStatus == GAME_ON) {
            playBaseballGame();
        }
    }
}