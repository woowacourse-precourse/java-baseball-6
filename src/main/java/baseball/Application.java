package baseball;

import baseball.domain.AnswerNumbersGenerator;
import baseball.domain.BaseBallGame;
import baseball.domain.GameState;
import baseball.domain.MatchPlayer;
import baseball.domain.Player;
import baseball.singlegame.BaseballSingleGame;
import baseball.singlegame.ComputerPlayer;
import baseball.singlegame.RandomAnswerNumbersGenerator;
import baseball.view.SinglePlayerConsole;

public class Application {

    public static void main(String[] args) {
        final Player player = initializePlayer();
        final MatchPlayer matchPlayer = initializeMatchPlayer();
        startBaseBallSingleGame(
                new BaseballSingleGame(),
                player,
                matchPlayer
        );
    }

    private static Player initializePlayer() {
        return new SinglePlayerConsole();
    }

    private static MatchPlayer initializeMatchPlayer() {
        final AnswerNumbersGenerator numberGenerator = new RandomAnswerNumbersGenerator();
        return new ComputerPlayer(numberGenerator);
    }

    private static void startBaseBallSingleGame(
            BaseBallGame game,
            Player player,
            MatchPlayer matchPlayer
    ) {
        game.onCreateGame(player);
        GameState gameState = game.play(player, matchPlayer);
        while (gameState == GameState.RESTART) {
            gameState = game.play(
                    initializePlayer(),
                    initializeMatchPlayer()
            );
        }

    }
}
