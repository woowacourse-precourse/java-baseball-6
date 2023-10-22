package baseball;

import baseball.domain.BaseBallGame;
import baseball.domain.BaseBallHint;
import baseball.domain.BaseBallNumberGenerator;
import baseball.domain.BaseBallNumbers;
import baseball.domain.ComputerPlayer;
import baseball.domain.MatchPlayer;
import baseball.domain.RandomBaseBallNumberGenerator;
import baseball.domain.SingleBaseBallGame;
import baseball.view.Player;
import baseball.view.SinglePlayerConsole;

public class Application {
    public static void main(String[] args) {
        final Player player = new SinglePlayerConsole();
        startSingleBaseBallGame(player);
    }

    private static MatchPlayer initializeMatchPlayer() {
        final BaseBallNumberGenerator numberGenerator = new RandomBaseBallNumberGenerator();
        return new ComputerPlayer(numberGenerator);
    }

    private static BaseBallGame initializeBaseBallGame() {
        final MatchPlayer matchPlayer = initializeMatchPlayer();
        return new SingleBaseBallGame(matchPlayer);
    }

    private static void startSingleBaseBallGame(Player player) {
        player.startBaseballGameMessage();
        playBaseBallGame(player, initializeBaseBallGame());
    }

    private static void playBaseBallGame(Player player, BaseBallGame game) {
        while (true) {
            final BaseBallNumbers userNumbers = player.readBaseballNumbers();
            final BaseBallHint hint = game.checkBaseBallNumber(userNumbers);
            player.printBaseBallHint(hint);
            if (hint.hasThreeStrike()) {
                player.printEndGameMessage();
                break;
            }
        }
        if (player.checkRestart()) playBaseBallGame(player, initializeBaseBallGame());
    }
}
