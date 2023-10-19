package baseball.controller;

import baseball.domain.BaseBallNumbers;
import baseball.dto.request.PlayerNumberDto;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;

    public GameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.printGameStart();
        PlayerNumberDto playerNumberDto = inputView.scanPlayerNumbers();
        BaseBallNumbers playerNumbers = BaseBallNumbers.from(playerNumberDto.getPlayerNumbers());

    }

}
