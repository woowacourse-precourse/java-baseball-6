package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE3 = "3스트라이크";
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    private List<Integer> computerNumber;
    private List<Integer> playerNumber;
    private boolean exit = false;

    private NumberGenerator numberGenerator = new NumberGenerator();
    private HintGenerator hintGenerator = new HintGenerator();

    public void gameStart() {
        System.out.println(GAME_START_MESSAGE);
        computerNumber = numberGenerator.setComputerNumber();
        while (!exit) {
            playerNumber = numberGenerator.setPlayerNumber();
            String hint = hintGenerator.getHint(computerNumber, playerNumber);
            System.out.println(hint);
            if (hint.equals(STRIKE3)) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println(GAME_OVER_MESSAGE);
        String num = Console.readLine();
        if (!num.equals(RESTART) && !num.equals(EXIT)) {
            throw new IllegalArgumentException();
        }
        if (num.equals(RESTART)) {
            computerNumber = numberGenerator.setComputerNumber();
        }
        if (num.equals(EXIT)) {
            exit = true;
        }
    }
}