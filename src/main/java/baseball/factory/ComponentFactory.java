package baseball.factory;

import baseball.controller.BaseballController;
import baseball.formatter.BallCountFormatter;
import baseball.io.InputManager;
import baseball.io.InputMapper;
import baseball.io.InputValidator;
import baseball.io.InputView;
import baseball.io.OutputView;
import baseball.repository.AnswerNumbersRepository;
import baseball.service.BaseballService;
import baseball.utils.RandomNumberGenerator;

public class ComponentFactory {

    public BaseballController baseballController() {
        return new BaseballController(outputView(), inputManager(), baseballService());
    }

    private InputManager inputManager() {
        return new InputManager(inputView(), inputMapper());
    }

    private InputMapper inputMapper() {
        return new InputMapper();
    }

    private InputView inputView() {
        return new InputView(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    private BaseballService baseballService() {
        return new BaseballService(randomNumberGenerator(), answerNumbersRepository());
    }

    private AnswerNumbersRepository answerNumbersRepository() {
        return new AnswerNumbersRepository();
    }

    private RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    private OutputView outputView() {
        return new OutputView(ballCountFormatter());
    }

    private BallCountFormatter ballCountFormatter() {
        return new BallCountFormatter();
    }
}
