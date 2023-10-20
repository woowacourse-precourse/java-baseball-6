package baseball;

import baseball.domain.BaseballCalculator;
import baseball.domain.BaseBall;
import baseball.domain.GameManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBall baseBall = new BaseBall(new BaseballCalculator());
        GameManager gameManager = new GameManager(baseBall);

        gameManager.game();
    }
}
