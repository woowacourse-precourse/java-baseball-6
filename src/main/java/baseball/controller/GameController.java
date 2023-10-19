package baseball.controller;

import baseball.domain.BaseBallGameResult;
import baseball.domain.BaseBallNumbers;
import baseball.domain.NumberGenerator;
import baseball.dto.request.PlayerNumberDto;
import baseball.dto.response.GameResultDto;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final NumberGenerator numberGenerator;

    public GameController(OutputView outputView, InputView inputView, NumberGenerator numberGenerator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        outputView.printGameStart();
        PlayerNumberDto playerNumberDto = inputView.scanPlayerNumbers();
        BaseBallNumbers playerNumbers = BaseBallNumbers.generateNumbers(playerNumberDto.getPlayerNumbers());
        BaseBallNumbers computerNumbers = BaseBallNumbers.generateRandomNumbers(numberGenerator);
        BaseBallGameResult baseBallGameResult = computerNumbers.calculateResult(playerNumbers);
        outputView.printGameResult(new GameResultDto(baseBallGameResult));

    }

}
