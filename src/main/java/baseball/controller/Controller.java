package baseball.controller;

import baseball.dto.ButtonRequestDto;
import baseball.dto.PlayerBallRequestDto;
import baseball.model.Ball;
import baseball.model.Button;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final BaseballService baseballService;

    public Controller(BaseballService baseballService) {
        this.baseballService = baseballService;
    }

    public void run() {
        OutputView.printGameStart();
        Button button;
        do {
            play();
            button = button();
        } while (button != Button.GAME_OVER);
        OutputView.printGameOver();
    }

    private void play() {
        baseballService.init();
        Ball playerBall;
        do {
            playerBall = playerBall();
            OutputView.printCount(baseballService.getStrike(playerBall), baseballService.getBall(playerBall));
        } while (!baseballService.strikeOut(playerBall));
    }

    private Ball playerBall() {
        PlayerBallRequestDto playerBallRequestDto = InputView.inputPlayerBall();
        String number = playerBallRequestDto.getNumber();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            numbers.add(number.charAt(i) - '0');
        }
        return new Ball(numbers);
    }

    private Button button() {
        ButtonRequestDto buttonRequestDto = InputView.inputButton();
        return Button.findByName(buttonRequestDto.getName());
    }
}
