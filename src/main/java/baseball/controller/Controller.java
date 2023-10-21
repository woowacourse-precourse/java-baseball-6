package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.Player;
import baseball.view.InputView;

public class Controller {
    private boolean isGameInProgress;

    public Controller() {
        isGameInProgress = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        while (isGameInProgress) {
            Computer computer = new Computer();
            Player player = new Player();
            Game game = new Game();
            while (game.getStrikes() != 3) {
                game.compareNumbers(computer.getNumber(), player.getNumber(InputView.inputPlayerNumber()));
                if (game.getStrikes() > 0 && game.getBalls() > 0) {
                    System.out.printf("%d볼 %d스트라이크%n", game.getBalls(), game.getStrikes());
                }
                if (game.getStrikes() > 0 && game.getBalls() == 0) {
                    System.out.printf("%d스트라이크%n", game.getStrikes());
                }
                if (game.getStrikes() == 0 && game.getBalls() > 0) {
                    System.out.printf("%d볼%n", game.getBalls());
                }
                if (game.getStrikes() == 0 && game.getBalls() == 0) {
                    System.out.println("낫싱");
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            String command = InputView.inputRestartNumber();
            if (command.equals("2")) {
                isGameInProgress = false;
            }
        }
    }
}
