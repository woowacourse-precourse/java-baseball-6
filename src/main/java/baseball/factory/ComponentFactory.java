package baseball.factory;

import baseball.controller.BaseballController;
import baseball.io.InputManager;
import baseball.io.InputValidator;
import baseball.io.InputView;
import baseball.io.OutputView;
import baseball.repository.DomainRepository;
import baseball.service.BaseballService;
import baseball.utils.RandomNumberGenerator;

public class ComponentFactory {

    public BaseballController baseballController() {
        return new BaseballController(outputView(), inputManager(), baseballService());
    }

    private InputManager inputManager() {
        return new InputManager(inputView());
    }

    private InputView inputView() {
        return new InputView(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    private BaseballService baseballService() {
        return new BaseballService(randomNumberGenerator(), domainRepository());
    }

    private DomainRepository domainRepository() {
        return new DomainRepository();
    }

    private RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
