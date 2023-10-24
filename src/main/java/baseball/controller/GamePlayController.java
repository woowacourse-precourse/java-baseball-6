package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.GameNumberValidateService;
import baseball.util.PlayerHintUtil;
import baseball.view.OutputView;
import java.util.List;

public class GamePlayController {

    private static final int STRIKE_INDEX = 1;
    private static final int THREE_STRIKE = 3;
    private final GameNumberValidateService gameNumberValidateService = new GameNumberValidateService();
    private final PlayerHintUtil playerHintUtil = new PlayerHintUtil();
    private final OutputView outputView = new OutputView();

    public GamePlayController() {
        outputView.printCreateController();
    }

    public void gameStart(Computer computer, Player player){
        hintResult(calculateBallAndStrikeCount(computer, player));
    }

    public List<Integer> calculateBallAndStrikeCount(String computerNumber, String playerNumber) {

        return gameNumberValidateService.calculateGameNumber(
                computerNumber, playerNumber);
    }

    private void hintResult(List<Integer> ballAndStrikeCountList) {
        playerHintUtil.ballAndStrikeResultHint(ballAndStrikeCountList);

        if (ballAndStrikeCountList.get(STRIKE_INDEX) == THREE_STRIKE){
            outputView.printThreeStrikeResult(THREE_STRIKE);
            return;
        }
        outputView.printNotThreeStrikeResult(playerHintUtil.getPlayerHint());
    }
}
