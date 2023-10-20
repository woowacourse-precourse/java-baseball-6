package baseball.game.system;

import baseball.game.Game;

public class ReplayableGameSystem implements GameSystem {

    private final ReplayableGameSystemView systemView;
    private final Game game;

    public ReplayableGameSystem(ReplayableGameSystemView systemView, Game game) {
        this.systemView = systemView;
        this.game = game;
    }

    public void run() {
        boolean replay = true;
        while (replay) {
            game.init();
            game.play();
            replay = systemView.requestReplayInput();
        }
    }

}
