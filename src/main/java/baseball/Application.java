package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int[] generateRandomAnswer() {
        int[] answer;

        answer = new int[3];
        do {
            for (int i = 0; i < 2; i++) {
                answer[i] = Randoms.pickNumberInRange(1, 9);
            }
        } while(!duplicateNumber(answer));
        return answer;
    }

    private static boolean duplicateNumber(int[] number) {
        return ((number[0] == number[1])
                || (number[1] == number[2])
                || (number[2] == number[0]));
    }

    private static int[] getInputNumber() {
        String input;

        input = Console.readLine();
        if (!isValidInput(input)) {
            throw (new IllegalArgumentException());
        };
        return (stringToIntArray(input));
    }

    private static boolean isValidInput(String input) {
        return (isLengthThree(input)
                && isInRange(input)
                && !duplicateInput(input));
    }

    private static boolean isLengthThree(String input) {
        return (input.length() == 3);
    }

    private static boolean isInRange(String input) {
        for (char ch : input.toCharArray()) {
            if (!('1' <= ch && ch <= '9')) {
                return false;
            }
        }
        return true;
    }

    private static boolean duplicateInput(String input) {
        return ((input.charAt(0) == input.charAt(1))
                || (input.charAt(1) == input.charAt(2))
                || (input.charAt(2) == input.charAt(0)));
    }

    private static int[] stringToIntArray(String input) {
        int[] inputNumber;

        inputNumber = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            inputNumber[i] = (int) input.charAt(i);
        }
        return inputNumber;
    }

    private static boolean getResult(int[] answer, int[] inputNumber) {
        int ball, strike;

        strike = getStrike(answer, inputNumber);
        ball = getCount(answer, inputNumber) - strike;
        printResult(ball, strike);
        return (strike == 3);
    }

    private static int getStrike(int[] answer, int[] inputNumber) {
        int strike;

        strike = 0;
        for (int i = 0; i < inputNumber.length; i++) {
            if (answer[i] == inputNumber[i]) {
                strike++;
            }
        }
        return strike;
    }

    private static int getCount(int[] answer, int[] inputNumber) {
        int count;

        count = 0;
        for (int number : inputNumber) {
            if (isInArray(number, answer)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isInArray(int number, int[] arr) {
        for (int arrNum : arr) {
            if (number == arrNum) {
                return true;
            }
        }
        return false;
    }

    private static void printResult(int ball, int strike) {
        if ((ball < 0) && (strike < 0)) {
            System.out.print("낫싱");
            return ;
        }
        printBall(ball);
        if ((ball > 0) && (strike > 0)) {
            System.out.print(" ");
        }
        printStrike(strike);
        System.out.println();
    }

    private static void printBall(int ball) {
        if (ball > 0) {
            System.out.print(ball);
            System.out.print("볼");
        }
    }

    private static void printStrike(int strike) {
        if (strike > 0) {
            System.out.print(strike);
            System.out.print("스트라이크");
        }
    }

    private static int getContinueGame() {
        String choice;

        choice = Console.readLine();
        if (!isValidChoice(choice)) {
            throw (new IllegalArgumentException());
        }
        return (stringToInt(choice));
    }

    private static boolean isValidChoice(String choice) {
        return (isLengthOne(choice) && isValidNumber(choice));
    }

    private static boolean isLengthOne(String choice) {
        return (choice.length() == 1);
    }

    private static boolean isValidNumber(String choice) {
        return ((choice.charAt(0) == '1') || (choice.charAt(0) == '2'));
    }

    private static int stringToInt(String choice) {
        return (choice.charAt(0) - '0');
    }
}
