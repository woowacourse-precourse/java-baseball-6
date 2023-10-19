package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


class Game {
    public static final int MIN_RANDOM_NUMBER = 1;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int RANDOM_NUMBER_SIZE = 3;
    static List<Integer> answer = new ArrayList<>();

    Game() {
        answer = makeRandomNumber();
        System.out.println("answer : " + answer);
    }

    public void set() {
        Game game;
        do {
            game = new Game();
            game.start();
        } while (restart());
    }

    private void start() {
        guessNumber();
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    private void guessNumber() {
        String inputNumber;
        do {
            inputNumber = Console.readLine();
            validationNumberCheck(inputNumber);
        } while (!equalToAnswer(inputNumber));
    }

    private void validationNumberCheck(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("입력 문자열의 길이가 3이 아닙니다.");
        }

        for (char c : inputString.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
            }
        }
    }

    private static boolean equalToAnswer(String inputNumber) {
        int[] intInputNumber = changeToIntegerList(inputNumber);
        int strike = getStrike(intInputNumber);
        int ball = getBall(intInputNumber);

        printResult(strike, ball);

        if (strike == 3) {
            return true;
        }
        return false;
    }

    private static int[] changeToIntegerList(String inputNumber) {
        int[] inputList = new int[answer.size()];
        for (int i = 0; i < RANDOM_NUMBER_SIZE; i++) {
            inputList[i] = Character.getNumericValue(inputNumber.charAt(i));
        }
        return inputList;
    }

    private static int getStrike(int[] inputNumber) {
        int strike = 0;

        for (int i = 0; i < RANDOM_NUMBER_SIZE; i++) {
            if (inputNumber[i] == answer.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private static int getBall(int[] inputNumber) {
        int ball = 0;

        for (int i = 0; i < RANDOM_NUMBER_SIZE; i++) {
            if (inputNumber[i] != answer.get(i) && answer.contains(inputNumber[i])) {
                System.out.println(inputNumber[i] + " * " + answer.get(i));
                ball++;
            }
        }
        return ball;
    }

    private static void printResult(int strike, int ball) {
        printBall(ball);
        printStrike(strike);
    }

    private static void printBall(int ball) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
    }

    private static void printStrike(int strike) {
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 3) {
            endGame();
        }
    }

    private static void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        if (input.equals("1")) {
            System.out.println("게임을 다시 시작합니다.");
            return true;
        } else if (input.equals("2")) {
            System.out.println("게임을 종료합니다.");
            return false;
        } else {
            System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
            return restart();
        }

    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.set();
    }
}
