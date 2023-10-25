package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int COMPUTER_DIGIT = 3;
    private static final String RESTART_GAME = "1";
    private static final String EXIT_GAME = "2";

    private static final String WELCOME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String CONTINUE_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String FINISH_MESSAGE = COMPUTER_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CHECK_RESTART_MESSAGE =
            "게임을 새로 시작하려면 " + RESTART_GAME + ", 종료하려면 " + EXIT_GAME + "를 입력하세요.";
    private static final String NONE_MESSAGE = "낫싱";

    private static List<Integer> computerAnswer;
    private static List<Integer> userAnswer;

    public Game() {
    }

    public static void setComputerAnswer(List<Integer> computerAnswer) {
        Game.computerAnswer = computerAnswer;
        System.out.println(getComputerAnswer());
    }

    public static List<Integer> getComputerAnswer() {
        return computerAnswer;
    }

    public static void start() {
        System.out.println(WELCOME_MESSAGE);
        do {
            run();
        } while (checkRestart());
    }

    public static void run() {
        boolean restart;
        setComputerAnswer(createRandomNum(COMPUTER_DIGIT));
        do {
            System.out.print(CONTINUE_MESSAGE);
            List<Integer> answer = parsingInput();
            restart = compareAnswer(answer);
        } while (restart);
    }

    private static boolean checkRestart() {
        System.out.println(CHECK_RESTART_MESSAGE);
        String input = readLine();
        System.out.println("input:" + input);
        if (input.equals(RESTART_GAME)) {
            return true;
        } else if (input.equals(EXIT_GAME)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static boolean compareAnswer(List<Integer> answer) {
        // 1. 스트라이크 2. 볼 3. 정답 4. 낫싱
        String resultMessage = "";
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < COMPUTER_DIGIT; i++) {
            if (getComputerAnswer().contains(answer.get(i))) {
                if (answer.get(i) == computerAnswer.get(i)) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        if (ball != 0) {
            resultMessage += ball + "볼 ";
        }
        if (strike != 0) {
            resultMessage += strike + "스트라이크 ";
            if (strike == 3) {
                System.out.println(resultMessage);
                System.out.println(FINISH_MESSAGE);
                return false;
            }
        }
        if (ball == 0 && strike == 0) {
            System.out.println(NONE_MESSAGE);
        } else {
            System.out.println(resultMessage);
        }
        return true;
    }

    private static List<Integer> parsingInput() {
        List<Integer> parsedInput = new ArrayList<>();
        String input = readLine();
        System.out.println(input);

        if (input.isEmpty() || !isValidInput(input)) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < input.length(); i++) {
                char digitChar = input.charAt(i);
                int digit = Integer.parseInt(String.valueOf(digitChar));
                parsedInput.add(digit);
            }
            return parsedInput;
        }
    }

    private static boolean isValidInput(String input) {
        // 자릿수, 숫자만 허용
        return isValidDigit(COMPUTER_DIGIT, input.length()) && isNumber(input) ? true : false;
    }

    private static boolean isValidDigit(int computerDigit, int inputLength) {
        return computerDigit == inputLength ? true : false;
    }

    private static boolean isNumber(String input) {
        return input.matches("\\d+");
    }

    /* 서로 다른 3자리 난수 생성*/
    private static List<Integer> createRandomNum(int digit) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < digit) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
