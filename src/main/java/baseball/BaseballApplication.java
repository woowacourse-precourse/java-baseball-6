package baseball;

import baseball.domain.InputOutputHandler;
import baseball.domain.NumberBaseball;
import baseball.domain.NumberBaseballIO;
import baseball.domain.User;
import baseball.domain.validators.InputValidator;
import baseball.domain.validators.NumberBaseballValidator;

public class BaseballApplication {
    private static final int NUMBER_MAX_LENGTH = 3;
    private InputValidator cachedInputValidator;
    private NumberBaseballValidator cachedNumberBaseballValidator;
    private InputOutputHandler cachedInputOutputHandler;
    private NumberBaseballIO cachedNumberBaseballIO;
    private User cachedUser;
    private NumberBaseball cachedNumberBaseball;

    private BaseballApplication() {
    }

    public static void run() {
        BaseballApplication application = new BaseballApplication();
        NumberBaseball game = application.numberBaseball();
        game.play(NUMBER_MAX_LENGTH);
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
