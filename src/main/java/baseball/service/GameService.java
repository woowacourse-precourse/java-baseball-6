package baseball.service;

import baseball.domain.*;

public class GameService {

    private Computer computer = new Computer();
    private Player player = new Player();
    private Game game = new Game(computer, player);

    public void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (game.getStatus() != GameStatus.END) {
            Result result = game.play();
            System.out.println(result);
            if (result.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                game.choiceContinue();
            }
            if (game.getStatus() == GameStatus.RESTART) {
                game.setStatus(GameStatus.GAMING);
                game.getComputer().createNewGameNumber();
                game.addGameCount();
            }
        }
    }
}
