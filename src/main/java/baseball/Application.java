package baseball;

import baseball.domain.BaseBallGame;
import baseball.domain.BaseBallNumberGenerator;
import baseball.domain.ComputerPlayer;
import baseball.domain.MatchPlayer;
import baseball.domain.RandomBaseBallNumberGenerator;
import baseball.domain.SingleBaseBallGame;
import baseball.view.Player;
import baseball.view.SinglePlayerConsole;

public class Application {
    public static void main(String[] args) {
        final BaseBallGame singleBaseBallGame = initializeBaseBallGame();
        final Player player = new SinglePlayerConsole();
        startBaseBallGame(player, singleBaseBallGame);
    }

    private static MatchPlayer initializeMatchPlayer() {
        final BaseBallNumberGenerator numberGenerator = new RandomBaseBallNumberGenerator();
        return new ComputerPlayer(numberGenerator);
    }

    private static BaseBallGame initializeBaseBallGame() {
        final MatchPlayer matchPlayer = initializeMatchPlayer();
        return new SingleBaseBallGame(matchPlayer);
    }

    private static void startBaseBallGame(Player player, BaseBallGame game) {
        player.startBaseballGameMessage();
        playBaseBallGame(player, game);
    }

    private static void playBaseBallGame(Player player, BaseBallGame game) {
        if (player.checkRestart()) playBaseBallGame(player, game);
    }
}
