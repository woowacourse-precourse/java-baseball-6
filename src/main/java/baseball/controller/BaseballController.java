package baseball.controller;

import baseball.dto.BallRequestDto;
import baseball.dto.OptionRequestDto;
import baseball.model.Ball;
import baseball.model.BallGenerator;
import baseball.model.Option;
import baseball.service.BaseballService;
import baseball.view.input.BallInputView;
import baseball.view.input.OptionInputView;
import baseball.view.output.OutputView;
import java.util.stream.Stream;

public class BaseballController {

    private final BaseballService baseballService;

    public BaseballController(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public void run() {
        OutputView.printGameStart();
        Option option;
        do {
            play(BallGenerator.generateBall());
            option = toOption(OptionInputView.readOption());
        } while (!option.isGameOver());
        OutputView.printGameOver();
    }

    private void play(Ball answer) {
        Ball player;
        do {
            player = toBall(BallInputView.readBall());
            baseballService.check(answer, player);
            OutputView.printResult(baseballService.getResult());
        } while (!baseballService.isStrikeOut());
    }

    private Ball toBall(BallRequestDto dto) {
        int number = dto.getNumber();
        return new Ball(
                Stream.of(String.valueOf(number).split(""))
                        .map(Integer::parseInt)
                        .toList()
        );
    }

    private Option toOption(OptionRequestDto dto) {
        int number = dto.getNumber();
        return Option.getOptionByNumber(number);
    }
}
