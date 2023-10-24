package baseball.game;

import baseball.util.NumberUtils;
import baseball.util.RandomNumber;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void start() {
        printStartMessage();
        playGame();
    }

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.print(GAME_INPUT_MESSAGE);
    }

    public static void successGame() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void playGame() {
        while (true) {
            BaseBall baseball = new BaseBall(RandomNumber.createRandomNumber());
            baseball.playBaseBallGame();
            successGame();
            if (!newGame()) {
                break;
            }
        }
    }

    public boolean newGame() {
        System.out.println(NEW_GAME_MESSAGE);
        String input = Console.readLine();
        NumberUtils.validateInputNewGameNumber(input);
        if (input.equals("1")) {
            return true;
        }
        return false;
    }
}
