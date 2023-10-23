package baseball.application;

import baseball.domain.BaseBallNumberList;

public class BaseBallGame {

    private final BaseBallNumberList computer;
    private final GameManager gameManager;

    public BaseBallGame(BaseBallNumberList computer, GameManager gameManager) {
        this.computer = computer;
        this.gameManager = gameManager;
    }

    public BaseBallResult play(BaseBallNumberList playerInput) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.getList().get(i).equals(playerInput.getList().get(i))) {
                strike++;
            }
        }

        if (strike == 3) {
            gameManager.exit();
        }

        assert gameManager != null;
        assert computer != null;
        return new BaseBallResult(strike);
    }
}
