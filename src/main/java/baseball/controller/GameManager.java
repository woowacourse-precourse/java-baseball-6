package baseball.controller;

import baseball.entity.Coin;
import baseball.entity.ComputerPlayer;
import baseball.entity.Player;
import baseball.entity.Referee;
import baseball.entity.UserPlayer;
import baseball.view.Viewer;

public class GameManager {

    private final Viewer viewer;

    public GameManager(Viewer viewer) {
        this.viewer = viewer;
    }

    public void run() {
        Coin coin = new Coin();

        viewer.startGameView();
        while (coin.isCoin()) {
            game(new ComputerPlayer());

            coin = inputCoin();
        }
    }

    private Coin inputCoin() {
        return new Coin(viewer.restartGameView());
    }

    private void game(Player computerUserPlayer) {

        Referee referee = new Referee();
        Player userPlayer;
        while (!referee.isGameOver()) {
            userPlayer = new UserPlayer(viewer.pleaseInputNumberView());
            viewer.resultView(referee.result(userPlayer, computerUserPlayer));
        }
        viewer.threeStrikeView();
    }
}
