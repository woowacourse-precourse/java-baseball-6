package baseball;

public class AppConfig {
    public BaseBallGameEngine getBaseBallGameEngine(int length) {
        return new BaseBallGameEngine(getNumberGenerator().generateNumber(length), getBaseBalGameValidator());
    }

    private BaseBalGameValidator getBaseBalGameValidator() {
        return new BaseBalGameValidator();
    }

    private NumberGenerator getNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public BaseBallUI getBaseBallUI() {
        return new BaseBallUI();
    }

    public InputReader getInputReader() {
        return new InputReaderImpl();
    }

}
