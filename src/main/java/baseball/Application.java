package baseball;

import baseball.domain.BaseBallGame;
import baseball.domain.BaseBallHint;
import baseball.domain.AnswerNumbersGenerator;
import baseball.domain.AnswerNumbers;
import baseball.domain.ComputerPlayer;
import baseball.domain.MatchPlayer;
import baseball.domain.RandomAnswerNumbersGenerator;
import baseball.domain.BaseballSingleGame;
import baseball.domain.Player;
import baseball.view.SinglePlayerConsole;

public class Application {
    public static void main(String[] args) {
        final Player player = new SinglePlayerConsole();
        startSingleBaseBallGame(player);
    }

    private static MatchPlayer initializeMatchPlayer() {
        final AnswerNumbersGenerator numberGenerator = new RandomAnswerNumbersGenerator();
        return new ComputerPlayer(numberGenerator);
    }

    private static BaseBallGame initializeBaseBallGame() {
        final MatchPlayer matchPlayer = initializeMatchPlayer();
        return new BaseballSingleGame(matchPlayer);
    }

    private static void startSingleBaseBallGame(Player player) {
        player.showStartGameMessage();
        playBaseBallGame(player, initializeBaseBallGame());
    }

    private static void playBaseBallGame(Player player, BaseBallGame game) {
        while (true) {
            final AnswerNumbers userNumbers = player.getBaseballNumbers();
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
