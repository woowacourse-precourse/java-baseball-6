package baseball;

import static baseball.User.END_GAME;

public class Application {
    
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {

        System.out.println(GAME_START_MESSAGE);

        Game game = new Game();

        while (true) {
            game.startGame();
            if (END_GAME.equals(User.startNewGameOrNot())) {
                break;
            }
        }

    }
}