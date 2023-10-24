package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.GameNumberValidateService;
import baseball.util.PlayerHintUtil;
import baseball.view.OutputView;
import java.util.List;

public class GamePlayController {

    private final GameNumberValidateService gameNumberValidateService = new GameNumberValidateService();
    private final OutputView outputView = new OutputView();

    public GamePlayController() {
        outputView.printCreateController();
    }

    public void gameStart(Computer computer, Player player){
        hintResult(calculateStrikeAndBallCount(computer, player));
    }

    private List<Integer> calculateStrikeAndBallCount(Computer computer, Player player) {

        return gameNumberValidateService.calculateGameNumber(
                computer.getComputerGameNumber(), player.getPlayerNumber());
    }

    private void hintResult(List<Integer> ballAndStrikeCountList) {
    }
}
