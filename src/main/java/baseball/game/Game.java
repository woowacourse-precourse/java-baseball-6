package baseball.game;

public class Game {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void startGame() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void successGame() {
        System.out.println(GAME_END_MESSAGE);
        newGame();
    }

    public static void newGame() {
        System.out.println(NEW_GAME_MESSAGE);

    }
}
