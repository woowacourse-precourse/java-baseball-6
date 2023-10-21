package baseball;

public class BaseBallGameEngine {
    private final int answer;
    private final BaseBalGameValidator baseBalGameValidator;

    public BaseBallGameEngine(int generateBaseBallValue, BaseBalGameValidator validator) {
        this.baseBalGameValidator = validator;
        baseBalGameValidator.validBaseBallValue(generateBaseBallValue);
        this.answer = generateBaseBallValue;
    }
}
