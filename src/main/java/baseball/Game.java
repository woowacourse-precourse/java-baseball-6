package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final String GAME_START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_SENTENCE = "숫자를 입력해주세요 : ";
    private static final String CORRECT_ANSWER_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART = "1";
    private static final String END = "2";

    private List<Integer> answer;
    private boolean restartFlag = true;

    public Game() {
        generateAnswerNumber();
    }

    public static void run() {
        Game game = new Game();
        game.start();
    }

    private void generateAnswerNumber() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        System.out.println("정답 : " + answer.toString());
    }

    public void start() {

        System.out.println(GAME_START_SENTENCE);
        do {
            System.out.print(INPUT_NUMBER_SENTENCE);

            String input = Console.readLine();

            validateAnswerNumber(input);

            List<Integer> inputList = castStringToListInteger(input);

            int strike = countStrike(inputList);
            int ball = countBall(inputList) - strike;

            // 출력
            printResult(strike, ball);
        } while (restartFlag);

    }

    private void printResult(int strike, int ball) {
        printHint(strike, ball);
        printVictory(strike);
    }

    private void printVictory(int strike) {
        if (strike == 3) {
            System.out.println(CORRECT_ANSWER_SENTENCE);
            System.out.println(RESTART_OR_END_SENTENCE);

            String input = Console.readLine();
            validateRestartNumber(input);

            if (input.equals(RESTART)) {
                restartFlag = true;
                generateAnswerNumber();
            } else {
                restartFlag = false;
            }
        }
    }

    private void printHint(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else {
            printBall(ball);
            printStrike(strike);
            System.out.println();
        }
    }

    private void printStrike(int strike) {
        if(strike != 0) {
            System.out.print(strike + "스트라이크");
        }
    }

    private void printBall(int ball) {
        if(ball != 0) {
            System.out.print(ball + "볼 ");
        }
    }

    private int countBall(List<Integer> inputList) {
        int ball = 0;
        for (int i=0; i<answer.size(); i++) {
            if(answer.contains(inputList.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrike(List<Integer> inputList) {
        int strike = 0;
        for (int i=0; i<answer.size(); i++) {
            if (answer.get(i) == inputList.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private void validateAnswerNumber(String input) {
        boolean matches = input.matches("\\d{3}");
        if (!matches) {
            throw new IllegalArgumentException("공백없이 숫자 3자리만 입력해야 합니다. 예시) 123");
        }

        for(int i=0; i<input.length(); i++) {
            if (input.indexOf(input.charAt(i)) != i) {
                throw new IllegalArgumentException("숫자는 중복해서 입력하면 안됩니다.");
            }
        }
    }

    private static void validateRestartNumber(String input) {
        if (!input.equals(RESTART) && !input.equals(END)) {
            throw new IllegalArgumentException("'1' 또는 '2' 중 하나만 입력해주세요!");
        }
    }

    private List<Integer> castStringToListInteger(String input) {
        List<Integer> inputList = new ArrayList<>();
        for (int i=0; i<input.length(); i++) {
            inputList.add(Integer.valueOf(input.substring(i, i+1)));
        }
        return inputList;
    }
}
