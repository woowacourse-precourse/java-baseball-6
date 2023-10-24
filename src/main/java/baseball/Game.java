package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Computer computer;
    private User user;
    private Hint hint;
    private boolean continueGame;

    private static final String VICTORY_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private static final int RESTART = 1;
    private static final int END = 2;

    private static final int NUMBER_LEN = 3;

    public Game() {
        initGame();
        System.out.println(START_MESSAGE);
    }

    private void initGame() {
        computer = new Computer();
        user = new User();
        hint = new Hint();
        continueGame = true;
    }

    public void start() {
        do {
            playGame();
        } while (continueGame);
    }

    private void playGame() {
        user.enterNumber();
        hint.calculateHint(user.userAnswer, computer.computerAnswer);
        hint.printHint();
        if (hint.getStrike() == NUMBER_LEN) {
            boolean res = askRestartGame();

            if (!res) {
                toggleContinue();
            } else {
                initGame();
            }
        }

    }

    private boolean askRestartGame() {
        System.out.println(VICTORY_MESSAGE);
        System.out.println(END_MESSAGE);
        int userInput = Integer.parseInt(Console.readLine());
        if (userInput == RESTART) {
            return true;
        } else if (userInput == END) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void toggleContinue() {
        continueGame = !continueGame;
    }
}
