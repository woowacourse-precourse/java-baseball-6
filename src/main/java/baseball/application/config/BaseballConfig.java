package baseball.application.config;

import baseball.application.converter.StringConverter;
import baseball.application.random.RandomGenerator;
import baseball.util.converter.InputStringConverter;
import baseball.util.random.NextStepRandomGenerator;

public class BaseballConfig {

    public RandomGenerator randomGenerator() {
        return new NextStepRandomGenerator();
    }

    public StringConverter stringConverter() {
        return new InputStringConverter();
    }
}
