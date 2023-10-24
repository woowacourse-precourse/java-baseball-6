package baseball.controller;

import baseball.service.ProgressService;
import baseball.validation.NumberValidation;
import baseball.view.InputView;

import java.util.stream.Stream;

import static baseball.constant.Constant.END;
import static baseball.constant.Constant.RESTART;

public class GameProgress {

    private final ProgressService progressService;
    private final NumberValidation numberValidation;

    public GameProgress() {
        progressService = new ProgressService();
        numberValidation = new NumberValidation();
    }

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return InputView.getInput();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!progressService.isGameClear()) {
            String input = getInput();

            int[] playerNumber = Stream.of(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            numberValidation.validationAll(playerNumber);
            String message = progressService.getResultMessage(playerNumber);
            System.out.println(message);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = InputView.getInput();
        int gameStatus = progressService.getResultGameStatus(input);

        if (gameStatus == RESTART) {
            restartGame();
        }
        if (gameStatus == END) {
            System.out.println("게임 종료");
        }
    }

    public void restartGame() {
        progressService.resetGame();
        startGame();
    }
}
