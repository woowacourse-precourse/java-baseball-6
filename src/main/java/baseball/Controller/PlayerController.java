package baseball.Controller;

import baseball.Model.Player;
import baseball.View.PlayerTerminalInputView;

public class PlayerController {
    private Player player;
    private PlayerTerminalInputView playerView;

    public PlayerController(Player player, PlayerTerminalInputView playerView) {
        this.player = player;
        this.playerView = playerView;
    }

    public String query() {
        player.setTryCount(player.getTryCount()+1);
        return playerView.input();
    }
}
