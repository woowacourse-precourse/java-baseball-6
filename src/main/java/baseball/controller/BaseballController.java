package baseball.controller;

import baseball.dto.ResultDto;
import baseball.dto.TerminateEnum;
import baseball.model.Numbers;
import baseball.service.NumbersGenerator;
import baseball.service.RefereeService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final NumbersGenerator generator;

    public BaseballController(InputView inputView, NumbersGenerator generator) {
        this.inputView = inputView;
        this.generator = generator;
    }

    public void run() {
        OutputView.printWelcome();
        do {
            Numbers com = generator.randomGenerate();
            play(com);
        } while (inputView.inputTerminateNum().toTerminateEnum() == TerminateEnum.RESTART);
    }

    private void play(Numbers com) {
        ResultDto resultDto;
        do {
            Numbers user = inputView.inputNumbers().toNumbers();
            resultDto = RefereeService.compareNumbers(user.getNumbers(), com.getNumbers());
            OutputView.printResult(resultDto);
        } while (!resultDto.isAllStrike());

        OutputView.printGameEndMessage();
    }


}
