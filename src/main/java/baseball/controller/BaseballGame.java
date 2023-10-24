package baseball.controller;

import baseball.domain.Computer;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {
    private final GameService gameService;
    private static boolean endOrNot = false;

    public BaseballGame() {
        gameService = new GameService();
    }

    public void startGame() {
        initStartGame();
        while (endOrNot) {
            startOneGame();
            exitGame();
        }
        System.out.println("게임 종료");
    }

    private void startOneGame() {
        Computer computer = new Computer();
        boolean oneGameFinished = false;
        List<Integer> computerNumber = computer.getComputerNumber();
        while (!oneGameFinished) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNumber = gameService.parsingInputNumber(InputView.Input());
            List<Integer> gameResult = gameService.playGame(computerNumber, userNumber);
            if (OutputView.outputResult(gameResult)) {
                oneGameFinished = true;
            }
        }
    }

    private void initStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        endOrNot = true;
    }

    private void exitGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (InputView.Input().equals("2")) {
            endOrNot = false;
        }
    }
}
