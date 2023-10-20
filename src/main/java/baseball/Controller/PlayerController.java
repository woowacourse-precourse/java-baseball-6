package baseball.Controller;

import baseball.Model.Player;
import baseball.View.PlayerTerminalView;

public class PlayerController {
    private Player player;
    private PlayerTerminalView playerView;

    public PlayerController(Player player, PlayerTerminalView playerView) {
        this.player = player;
        this.playerView = playerView;
    }

    public String query() {
        player.setTryCount(player.getTryCount()+1);
        playerView.display("숫자를 입력해주세요 : ");
        return playerView.inputQuery();
    }

    public String answer() {
        return playerView.getAnswer();
    }
}
