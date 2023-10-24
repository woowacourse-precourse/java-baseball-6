package baseball.controller;

import baseball.model.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseBallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // 게임 시작 문구 출력
        outputView.printGameStart();
        do {
            // 게임 생성 (컴퓨터 번호 생성)
            Game game = Game.createRandomNumber();

            while (true) {
                // 사용자가 번호 입력
                String inputNumber = inputView.inputNumber();

                // 컴퓨터 번호와 사용자 번호의 스트라이크, 볼 판단 array 반환
                int[] check = game.checkScoreResult(inputNumber);

                // 게임 결과 출력
                outputView.printResult(check[0], check[1]);

                if (check[1] == 3) {
                    break;
                }
            }
            outputView.printGameOver();
        } while (checkRestart());
    }

    private boolean checkRestart() {
        int choice = inputView.inputRestartChoice();
        return choice == 1;
    }
}
