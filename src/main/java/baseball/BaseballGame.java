package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {

    private List<Integer> inputBalls;
    private boolean gameOver;

    public BaseballGame() {
        gameOver = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void playGame() {

        while (!gameOver) {
            Computer computer = new Computer();

            startBaseball(computer);

            playNextGameOrStop();
        }
        System.out.println("게임 종료");
    }

    private void startBaseball(Computer computer) {
        boolean strikeOut = false;

        while (!strikeOut) {
            receiveInput();

            BallCounter ballCounter = computer.checkAnswer(inputBalls);

            ballCounter.printResult();

            if (ballCounter.isGameOver()) {
                strikeOut = true;
            }
        }

    }

    private void receiveInput() {
        System.out.print("숫자를 입력해주세요: ");
        String balls = Console.readLine();

        checkInput(balls);

        makeInputBalls(balls);
    }

    private void makeInputBalls(String balls) {
        inputBalls = new ArrayList<>();
        stringToInteger(balls);
    }

    private void stringToInteger(String balls) {
        for (int i = 0; i < balls.length(); i++) {
            inputBalls.add(balls.charAt(i) - '0');
        }
    }

    private void playNextGameOrStop() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        checkInputLength(input, 1);
        checkInputNumeric(input);

        selectGameOver(Integer.valueOf(input));
    }

    private void selectGameOver(int input) {
        if (input == 1) {
            gameOver = false;
        } else if (input == 2) {
            gameOver = true;
        }
    }

    private void checkInput(String balls) {
        checkInputNumeric(balls);
        checkInputLength(balls, 3);
        checkForDuplicateNumbers(balls);
    }

    private void checkInputLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void checkInputNumeric(String input) {
        char[] ballsCharArray = input.toCharArray();
        for (char ball : ballsCharArray) {
            isInputNumeric(ball);
        }
    }

    private void isInputNumeric(char input) {
        if (!Character.isDigit(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void checkForDuplicateNumbers(String input) {
        Set<Character> set = new HashSet<>();
        for (char ball : input.toCharArray()) {
            set.add(ball);
        }

        if (set.size() != input.length()) {
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
        }

    }

}
