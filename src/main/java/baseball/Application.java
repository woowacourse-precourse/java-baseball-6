package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import baseball.GameResult;

import static baseball.Constants.MAX_STRIKE;
import static baseball.Constants.NUM_LENGTH;

public class Application {

    private static List<Integer> computer;
    private static List<Integer> user;
    private static int strike;
    private static int ball;

    public static void main(String[] args) {
        try {
            startBaseballGame();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void startBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean continueFlag = true;
        while (continueFlag) {
            createComputerNumber();
            while (strike != MAX_STRIKE) {
                inputUserNumber();
                compareNumbers();
                printResult();
            }
            continueFlag = inputContinueOrExit();
        }
    }

    public static void createComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        if (inputNumber.length() != NUM_LENGTH) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < NUM_LENGTH; i++) {
            for(int j = 0; j < NUM_LENGTH; j++) {
                if (i == j) continue;
                if (inputNumber.charAt(i) == inputNumber.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }

        user = new ArrayList<>();
        for(int i = 0; i < NUM_LENGTH; i++) {
            char digit = inputNumber.charAt(i);
            if (!(digit >= '1' && digit <= '9')) {
                throw new IllegalArgumentException();
            }
            int number = digit - '0';
            user.add(number);
        }
    }

    public static void compareNumbers() {
        ball = 0;
        strike = 0;
        for(int i = 0; i < NUM_LENGTH; i++) {
            for(int j = 0; j < NUM_LENGTH; j++) {
                if (computer.get(i) != user.get(j)) continue;
                if (i == j) {
                    strike += 1;
                } else if (i != j) {
                    ball += 1;
                }
            }
        }
    }

    public static void printResult() {
        String message = GameResult.getMessage(ball, strike);
        System.out.println(message);
    }

    public static boolean inputContinueOrExit() {
        ball = 0;
        strike = 0;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNumber = Console.readLine();
        if (!inputNumber.equals("1") && !inputNumber.equals("2")) {
            throw new IllegalArgumentException();
        }
        if (inputNumber.equals("1")) {
            return true;
        }
        return false;
    }
}

