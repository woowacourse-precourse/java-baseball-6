package baseball;


import baseball.domain.Computer;
import baseball.service.BaseballService;
import baseball.service.GameManager;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        BaseballService bs = new BaseballService();
        GameManager gameManager = new GameManager(computer, bs);
        gameManager.startGame();
        gameManager.moreGame();
    }
}
