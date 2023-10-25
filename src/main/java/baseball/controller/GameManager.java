package baseball.controller;

import baseball.entity.ComputerPlayer;
import baseball.entity.Player;
import baseball.entity.UserPlayer;
import baseball.entity.Referee;
import baseball.view.Viewer;

public class GameManager {

    Viewer viewer = new Viewer();

    public void run() {
        String coin = "1";

        viewer.startGameView();
        while (coin.equals("1")) {
            game(new ComputerPlayer());

            coin = viewer.restartGameView();
        }

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
