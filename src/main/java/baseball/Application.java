package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class Game {
    public static final int MIN_RANDOM_NUMBER = 1;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int RANDOM_NUMBER_SIZE = 3;

    public static String INPUT_STRING = "숫자를 입력해주세요 : ";
    public static String WRONG_INPUT_SIZE = "입력 문자열의 길이가 3이 아닙니다.";
    public static String WRONG_INPUT_TYPE = "숫자가 아닌 문자가 포함되어 있습니다.";
    public static String NOTHING = "낫싱";
    public static String END_GAME_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String RESTART_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static String WRONG_INPUT_STRING = "restart() error";

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
        } while (game.restart());
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
            System.out.print(INPUT_STRING);
            inputNumber = Console.readLine();
            validationNumberCheck(inputNumber);
        } while (!equalToAnswer(inputNumber));
    }

    private void validationNumberCheck(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException(WRONG_INPUT_SIZE);
        }

        for (char c : inputString.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
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
            try {
                inputList[i] = Character.getNumericValue(inputNumber.charAt(i));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(WRONG_INPUT_TYPE);
            }
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
                ball++;
            }
        }
        return ball;
    }

    private static void printResult(int strike, int ball) {
        printBall(ball);
        printStrike(strike);
        System.out.println();
        if(isNothing(strike, ball)) {
            printNothing();
        }
    }

    private static boolean isNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }

    private static void printNothing() {
        System.out.println(NOTHING);
    }

    private static void printBall(int ball) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
    }

    private static void printStrike(int strike) {
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (strike == 3) {
            endGame();
        }
    }

    private static void endGame() {
        System.out.println(END_GAME_STRING);
    }

    private boolean restart() {
        System.out.println(RESTART_STRING);

        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException(WRONG_INPUT_STRING);
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
