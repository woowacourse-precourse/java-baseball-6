package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import baseball.GameResult;

public class Application {

    private static List<Integer> computer;
    private static List<Integer> user;
    private static int strike;
    private static int ball;

    public static void main(String[] args) {
        try {
            boolean continueFlag = true;
            startBaseballGame();
            while (continueFlag) {
                createComputerNumber();
                while (strike != 3) {
                    inputUserNumber();
                    compareNumbers();
                    printResult();
                }
                continueFlag = inputContinueOrExit();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("잘못된 값 입력: " + e.getMessage());
            throw e;
        }
    }

    public static void startBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void createComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("세 자리가 아닙니다.");
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (i == j) continue;
                if (inputNumber.charAt(i) == inputNumber.charAt(j)) {
                    throw new IllegalArgumentException("서로 다른 세 자리의 수가 아닙니다.");
                }
            }
        }

        user = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            char digit = inputNumber.charAt(i);
            if (!(digit >= '1' && digit <= '9')) {
                throw new IllegalArgumentException("올바른 숫자가 아닙니다.");
            }
            int number = digit - '0';
            user.add(number);
        }
    }

    public static void compareNumbers() {
        ball = 0;
        strike = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
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
            throw new IllegalArgumentException("1 또는 2가 아닙니다.");
        }
        if (inputNumber.equals("1")) {
            return true;
        }
        return false;
    }
}

