package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.exception.CommandException.validateRestartNumber;


public class GameRunner {
    private final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static int RESTART = 1;
    private final static int OUT_COUNT = 3;


    public void startGame() {
        while(true) {
            System.out.println(GAME_START_MESSAGE);
            BaseballGame game = BaseballGame.createGame();
            boolean isGameEnded = false;

            do {
                List<Integer> userInput = Player.getUserInput();
                GameResult result = game.play(userInput);
                result.display();

                if (result.getStrikeCount() == OUT_COUNT) {
                    isGameEnded = true;
                }
            } while(!isGameEnded);

            System.out.println(GAME_RESTART_OR_END_MESSAGE);
            String option = Console.readLine();

            validateRestartNumber(option);
            if (Integer.parseInt(option) != RESTART) {
                break;
            }
        }
    }
}
