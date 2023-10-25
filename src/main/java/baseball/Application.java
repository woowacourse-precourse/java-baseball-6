package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static int ball = 0;
    static int strike = 0;
    static final int GAME_CONTINUE = 1;
    static final int GAME_QUIT = 2;
    static final int NUMBER_OF_DIGITS = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }

    static void playGame() {
        // 초기화
        ball = 0;
        strike = 0;
        int[] answer = makeRandomNumber();
        while (!isGameWon()) {
            String userInput = getInputFromUser();
            validateUserInput(userInput);
            evaluateGuess(userInput, answer);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        int gameStatus = getUserChoiceToContinueOrQuit();
        if (gameStatus == GAME_CONTINUE) {
            playGame();
        }
    }

    static int[] makeRandomNumber() {
        int[] targetNumber = new int[NUMBER_OF_DIGITS];
        int answerIndex = 0;
        while (answerIndex < NUMBER_OF_DIGITS) {
            int singleDigit = Randoms.pickNumberInRange(1, 9);
            if (!hasDuplicates(targetNumber, singleDigit)) {
                targetNumber[answerIndex++] = singleDigit;
            }
        }
        return targetNumber;
    }

    static boolean isGameWon() {
        return strike == 3;
    }

    static String getInputFromUser() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }


    static void validateUserInput(String input) {
        if (input.length() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("입력값의 자리수가 유효하지 않습니다. 입력값의 자리수: " + input.length());
        }
        if (contains('0', input)) {
            throw new IllegalArgumentException("입력값에 0이 포함되었습니다. 유효 숫자 범위: 1~9");
        }
        if (hasDuplicates(input)) {
            throw new IllegalArgumentException("입력값 중 중복되는 숫자가 있습니다.");
        }
    }

    static void evaluateGuess(String input, int[] answer) {
        ball = 0;
        strike = 0;

        int[] inputArray = convertStringToIntArray(input);

        for (int i = 0; i < answer.length; i++) {
            int value = answer[i];
            if (inputArray[i] == value) {
                strike++;
            } else if (contains(value, inputArray)) {
                ball++;
            }
        }
        printResultMessage();
    }

    static void printResultMessage() {
        String ballComment = "";
        String strikeComment = "";
        if (ball > 0) {
            ballComment = ball + "볼 ";
        }
        if (strike > 0) {
            strikeComment = strike + "스트라이크 ";
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ballComment + strikeComment);
        }
    }

    static int getUserChoiceToContinueOrQuit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userChoiceStr = Console.readLine();
        int userChoice;
        try {
            userChoice = Integer.parseInt(userChoiceStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }

        if (userChoice != GAME_CONTINUE && userChoice != GAME_QUIT) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다. 1과 2 이외의 숫자 입력");
        }
        return userChoice;
    }

    static boolean hasDuplicates(int[] targetNumber, int singleDigit) {
        for (int i : targetNumber) {
            if (i == singleDigit) {
                return true;
            }
        }
        return false;
    }

    static boolean hasDuplicates(String input) {
        boolean[] board = new boolean[10];
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            if (board[c - '0']) {
                return true;
            }
            board[c - '0'] = true;
        }
        return false;
    }

    static boolean contains(char character, String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == character) {
                return true;
            }
        }
        return false;
    }

    static boolean contains(int value, int[] array) {
        for (int item : array) {
            if (item == value) {
                return true;
            }
        }
        return false;
    }

    static int[] convertStringToIntArray(String input) {
        int[] intArray = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            intArray[i] = input.charAt(i) - '0';
        }
        return intArray;
    }

}
