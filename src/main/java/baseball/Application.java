package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final int GAME_ON = 1;
    private static final int GAME_OVER = 2;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playBaseballGame();
    }

    private static void playBaseballGame() {
        int status = GAME_ON;
        List<Integer> randomList = generateRandomNumber();

        while (status == GAME_ON) {
            int randomNumber = randomList.get(0) * 100 + randomList.get(1) * 10 + randomList.get(2);
            System.out.print("숫자를 입력해주세요 : ");
            String num = readLine();
            runException(num);
            int userNumber = Integer.parseInt(num);

            if (status == GAME_OVER) {
                break;
            }

            int[] userDigits = getDigits(userNumber);
            int[] randomDigits = getDigits(randomNumber);

            int strike = countStrikes(userDigits, randomDigits);
            int ball = countBalls(userDigits, randomDigits);

            printResult(strike, ball);

            if (userNumber == randomNumber) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                status = getUserInput(readLine());

                if (status == GAME_OVER) {
                    break;
                } else if (status == GAME_ON) {
                    randomList = generateRandomNumber();
                }
            }
        }
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static void runException(String input) {
        validateUserInput(input);
        if (input.length() != 3) {
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
    }

    private static int getUserInput(String input) {
        int num = Integer.parseInt(input);
        validateUserInput(input);
        if (num < 1 || num > 2) {
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
        return num;
    }

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

}