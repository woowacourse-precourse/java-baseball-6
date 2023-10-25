package baseball.controller;

import baseball.common.contents.GameCommand;
import baseball.domain.BaseballNumber;
import baseball.dto.BaseballGameResultDto;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;

    public BaseballGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.baseballService = new BaseballService();

    }

    public void decideAnswer(){
        baseballService.decideAnswer();
    }

    public void greet() {
        outputView.printGreet();
    }

    public void guess() {
        outputView.printInputNumber();
        String guess = inputView.readGuess();
        List<Integer> numbers = Arrays.stream(guess.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        BaseballGameResultDto result = baseballService.judge(new BaseballNumber(numbers));
        outputView.printResult(result);
    }

    public void end(){
        outputView.printEnd();
        String command = inputView.readRestart();
        baseballService.processRestartMode(GameCommand.from(Integer.parseInt(command)));
    }

    public boolean isGameEnd(){
        return baseballService.isGameEnd();
    }
}
