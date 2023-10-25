package baseball.controller;

import static baseball.model.RandomNumberGenerator.pickRandomNumbers;
import static baseball.view.SystemMessagePrinter.printHintMessage;

import baseball.model.Game;
import baseball.model.InputManager;
import baseball.view.SystemMessagePrinter;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    static final int SIZE = 3;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static final int RESTART = 1;
    static final int EXIT = 2;
    static String userInput;
    static int ball;
    static int strike;
    static int[] pickedNumbers;

    // 게임 진행
    public static void playGame() {
        startGame();
        while (!Game.isGameWon()) {
            initializeCounts();
            getUserInput();
            validateUserInput(userInput);
            Game.generateHint(userInput, pickedNumbers);
            printHintMessage(ball, strike);
        }
        endGame();
    }

    // 시작 화면 출력 요청
    public static void startGame() {
        SystemMessagePrinter.printGameStartMessage();
        pickedNumbers = pickRandomNumbers(SIZE, MIN_NUMBER, MAX_NUMBER);
    }

    public static void getUserInput() {
        userInput = Console.readLine();
    }

    public static void initializeCounts() {
        ball = 0;
        strike = 0;
    }

    // 사용자 입력 처리
    // 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    public static void validateUserInput(String value) {
        if (!InputManager.isNumberInRange(userInput, MIN_NUMBER, MAX_NUMBER) ||
                !InputManager.isSizeValid(userInput, SIZE) || !InputManager.hasDuplicates(userInput, SIZE)) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    // 입력한 숫자와 컴퓨터가 선택한 숫자 비교

    // 게임 종료 여부 판단
    public static void endGame() {
        SystemMessagePrinter.printGameEndMessage();
        askForRestartOrExit();
    }

    // 게임 종료 시, 재시작 또는 완전히 종료 여부 입력 요청
    // 사용자 입력에 따라 게임 재시작 or 완전히 종료
    public static void askForRestartOrExit() {
        SystemMessagePrinter.printRestartOrExit();
        int userInput = Integer.parseInt(Console.readLine());
        if (!InputManager.isRestartInputValid(userInput)) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        if (userInput == RESTART) {
            SystemMessagePrinter.printRestartGame();
            playGame();
        }
        if (userInput == EXIT) {
            SystemMessagePrinter.printExitGame();
        }
    }
}
