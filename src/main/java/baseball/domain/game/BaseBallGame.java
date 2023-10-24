package baseball.domain.game;

import baseball.domain.computer.GameState;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.domain.game.GameMessage.*;

public class BaseBallGame {

    public static List<Integer> inputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String inputBaseBallNumbers = Console.readLine();
        List<Integer> playerNumbers = Arrays.stream(inputBaseBallNumbers.split(INPUT_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return playerNumbers;
    }

    public static void gameResultMessage(GameResult gameResult) {
        if (gameResult.isNothing()) {
            System.out.println(GAME_RESULT_NOTHING_MESSAGE);
            return;
        }
        if (gameResult.ballCount() == 0) {
            System.out.printf(GAME_RESULT_STRIKE_MESSAGE + LINE_BREAK, gameResult.strikeCount());
            return;
        }
        if (gameResult.strikeCount() == 0) {
            System.out.printf(GAME_RESULT_BALL_MESSAGE + LINE_BREAK, gameResult.ballCount());
            return;
        }
        System.out.printf(GAME_RESULT_BALL_MESSAGE + BLANK + GAME_RESULT_STRIKE_MESSAGE + LINE_BREAK, gameResult.ballCount(),
                gameResult.strikeCount());
    }

    public static GameState inputGameStateCommand(GameResult gameResult) {
        if (!gameResult.isFinished()) {
            return GameState.init();
        }
        System.out.println(GAME_OVER_MESSAGE);
        System.out.println(INPUT_GAME_STATE_COMMAND_MESSAGE);
        return GameState.createByCommand(Integer.parseInt(Console.readLine()));
    }
}
