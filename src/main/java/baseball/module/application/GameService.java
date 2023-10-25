package baseball.module.application;

import static baseball.global.constant.Game.SIGN_RESTART;
import static baseball.global.constant.Game.SIGN_STOP;
import static baseball.global.constant.Game.THREE_STRIKE;

import baseball.module.domain.Game;
import baseball.module.domain.Player;
import baseball.module.view.InputView;
import baseball.module.view.OutputView;

public class GameService {
    private static Game game;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void setGame() {
        outputView.printGameStartMessage();
        game = new Game();
    }

    public void playGame() {

        while (game.getStrikeCnt() != THREE_STRIKE) {
            play();
        }

        outputView.printGameFinishMessage();
        String option = inputView.readRestartStatus();

        if (option.equals(SIGN_RESTART)) {
            setGame();
        } else if (option.equals(SIGN_STOP)) {
            return;
        }
        play();
    }

    private void play() {
        game.init();
        Player player = Player.input(inputView.readPlayerNumber());
        game.play(player.getPlayerNumbers());
        outputView.printGameScoreMessage(game.getStrikeCnt(), game.getBallCnt());
    }
}
