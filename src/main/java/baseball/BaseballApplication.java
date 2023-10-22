package baseball;

import baseball.domain.*;
import baseball.domain.validators.InputValidator;
import baseball.domain.validators.NumberBaseballValidator;

public class BaseballApplication {
    private InputValidator cachedInputValidator;
    private NumberBaseballValidator cachedNumberBaseballValidator;
    private InputOutputHandler cachedInputOutputHandler;
    private NumberBaseballIO cachedNumberBaseballIO;
    private User cachedUser;
    private NumberBaseball cachedNumberBaseball;

    private BaseballApplication() {};

    public static void run(int numberLimit) {
        // 여기에서 실행 로직을 구현하세요.
        // 예를 들면:
        BaseballApplication application = new BaseballApplication();
        NumberBaseball game = application.numberBaseball();
        game.play(numberLimit);
    }

    public InputValidator inputValidator() {
        if (cachedInputValidator == null) {
            cachedInputValidator = new InputValidator();
        }
        return cachedInputValidator;
    }

    public NumberBaseballValidator numberBaseballValidator() {
        if (cachedNumberBaseballValidator == null) {
            cachedNumberBaseballValidator = new NumberBaseballValidator();
        }
        return cachedNumberBaseballValidator;
    }

    public InputOutputHandler inputOutputHandler() {
        if (cachedInputOutputHandler == null) {
            cachedInputOutputHandler = new InputOutputHandler(inputValidator());
        }
        return cachedInputOutputHandler;
    }

    public NumberBaseballIO numberBaseballIO() {
        if (cachedNumberBaseballIO == null) {
            cachedNumberBaseballIO = new NumberBaseballIO(inputOutputHandler(), numberBaseballValidator());
        }
        return cachedNumberBaseballIO;
    }

    public User user() {
        if (cachedUser == null) {
            cachedUser = new User(numberBaseballIO());
        }
        return cachedUser;
    }

    public NumberBaseball numberBaseball() {
        if (cachedNumberBaseball == null) {
            cachedNumberBaseball = new NumberBaseball(user());
        }
        return cachedNumberBaseball;
    }
}
