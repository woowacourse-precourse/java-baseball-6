package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.InputMismatchException;
import java.util.List;

public class Application {
//
//    private static List<Integer> computerNumbers;
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
//    private static final String ERROR_MESSAGE_INVALID_INPUT = "3자리 양의 정수만 입력해주세요.";
//    private static final String ERROR_MESSAGE_NOT_POSITIVE_NUMBER = "양의 정수만 입력해주세요.";
//    private static final int INPUT_LIMIT = 3;
//
//    public static void isValidInput(String line) {
//        if (line.length() != INPUT_LIMIT) {
//            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_INPUT);
//        }
//        char[] charArray = line.toCharArray();
//        for (char c : charArray) {
//            if (!Character.isDigit(c) && c == '0') {
//                throw new IllegalArgumentException(ERROR_MESSAGE_NOT_POSITIVE_NUMBER);
//            }
//        }
//    }
//
//    public static boolean runGame() {
//        System.out.print(INPUT_MESSAGE);
//        String line = Console.readLine();
//
//        isValidInput(line);
//
//        int ball = 0, strike = 0;
//        for (int index = 0; index < INPUT_LIMIT; index++) {
//            int num = Character.getNumericValue(line.charAt(index));
//            if (computerNumbers.get(index) == num) {
//                strike++;
//            } else if (computerNumbers.contains(num)) {
//                ball++;
//            }
//        }
//
//        // Output Process
//        scorePrint(strike, ball);
//        scoreGame(strike, ball);
//        return false;
//
//    }
//
//    private static boolean scoreGame(int strike, int ball) {
//
//        if (strike == 3) {
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//            String retryInput = Console.readLine();
//            if (retryInput == null || retryInput.length() != 1 || !Character.isDigit(
//                    retryInput.charAt(0)) || retryInput.charAt(0) > '2') {
//                throw new IllegalArgumentException();
//            } else {
//                return !retryInput.equals("2");
//            }
//        }
//        return false;
//    }
//
//    private static void scorePrint(int strike, int ball) {
//        if (strike == 0 && ball == 0) {
//            System.out.println("낫싱");
//        } else if (strike == 0 && ball != 0) {
//            System.out.println(ball + "볼");
//        } else if (strike != 0 && ball == 0) {
//            System.out.println(strike + "스트라이크");
//        } else {
//            System.out.println(ball + "볼 " + strike + "스트라이크");
//        }
//    }
//
//
//    public static void initGame() {
//
//        computerNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
//        // NEED TO BE DELETED AT FINAL
//        System.out.println(computerNumbers);
//        System.out.println(STARTING_MESSAGE);
//    }

    public static void main(String[] args) {
        System.out.println(STARTING_MESSAGE);

        GameNumber computerNumber = new GameNumber();
        GameNumber userInput;
        while (true) {
//            System.out.println(computerNumber.getBoard());
            System.out.println(INPUT_MESSAGE);
            userInput = new GameNumber(Console.readLine());

            int strikes = computerNumber.countAndPrintGameScore(userInput);
            if (strikes == 3) {
                String line = Console.readLine();
                if (Character.getNumericValue(line.charAt(0)) == 2) {
                    System.out.println("게임 종료");
                    return;
                }
                computerNumber = new GameNumber();
            }
        }

    }
}