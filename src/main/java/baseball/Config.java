package baseball;

import baseball.domain.*;
import baseball.domain.validators.InputValidator;
import baseball.domain.validators.NumberBaseballValidator;

public class Config {

    public InputValidator inputValidator() {return new InputValidator();}
    public NumberBaseballValidator numberBaseballValidator() {return new NumberBaseballValidator();}

    public InputOutputHandler inputOutputHandler() {
        return new InputOutputHandler(inputValidator());
    }

    public NumberBaseballIO numberBaseballIO() {return new NumberBaseballIO(inputOutputHandler());}

    public User user() {
        return new User(numberBaseballIO());
    }

    public NumberBaseball numberBaseball(int numberLimit) {
        return new NumberBaseball(
                numberLimit,
                numberBaseballIO(),
                numberBaseballValidator(),
                user());
    }

}
