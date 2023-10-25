package baseball;

import baseball.application.RefereeService;
import baseball.controller.GameController;
import baseball.converter.ValueConverter;
import baseball.factory.PitchFactory;
import baseball.generator.RandomNumberGenerator;
import baseball.ui.InputView;
import baseball.ui.OutputView;
import baseball.validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValidator());
        OutputView outputView = new OutputView();
        RefereeService referee = new RefereeService();
        PitchFactory pitchFactory = new PitchFactory(new RandomNumberGenerator(), new ValueConverter());
        GameController gameController = new GameController(inputView, pitchFactory, outputView, referee);

        gameController.play();
    }
}
