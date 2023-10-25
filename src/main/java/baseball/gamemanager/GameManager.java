package baseball.gamemanager;

import baseball.calculator.ResultCalculator;
import baseball.enumeration.GameRestartStatus;
import baseball.input.UserNumberInputReader;
import baseball.property.BaseballGameProperty;
import baseball.random.RandomNumberGenerator;
import baseball.result.BaseballGameResult;
import baseball.validation.DuplicateNumberValidator;
import baseball.validation.NumberContainZeroValidator;
import baseball.validation.NumberRangeValidator;

/**
 * @author 민경수
 * @description game manager
 * @since 2023.10.23
 **********************************************************************************************************************/
public class GameManager {

    private UserNumberInputReader userNumberInputReader;
    private RandomNumberGenerator randomNumberGenerator;
    private DuplicateNumberValidator duplicateNumberValidator;
    private NumberContainZeroValidator numberContainZeroValidator;
    private NumberRangeValidator numberRangeValidator;
    private ResultCalculator resultCalculator;

    private BaseballGameProperty baseballGameProperty;

    private int[] randomNumber;
    private int[] userInputNumber;

    private boolean end;

    public GameManager() {
        this(new BaseballGameProperty(3, 1, 9));
    }

    public GameManager(BaseballGameProperty baseballGameProperty) {
        this.baseballGameProperty = baseballGameProperty;

        init();
    }

    private void init() {
        this.userNumberInputReader = new UserNumberInputReader(baseballGameProperty);
        this.randomNumberGenerator = new RandomNumberGenerator(baseballGameProperty);
        this.duplicateNumberValidator = new DuplicateNumberValidator();
        this.numberContainZeroValidator = new NumberContainZeroValidator();
        this.numberRangeValidator = new NumberRangeValidator(baseballGameProperty);
        this.resultCalculator = new ResultCalculator();

        this.end = false;
    }

    public void restart() {
        this.init();

        this.start();
    }

    public void start() {
        randomNumber = randomNumberGenerator.generateNumber();
    }

    private boolean isAllowedRandomNumber(int[] randomNumber) {
        try {
            duplicateNumberValidator.validate(randomNumber);
            numberContainZeroValidator.validate(randomNumber);
            numberRangeValidator.validate(randomNumber);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void requestUserInput() {
        userInputNumber = userNumberInputReader.readInput();

        duplicateNumberValidator.validate(userInputNumber);
        numberContainZeroValidator.validate(userInputNumber);
        numberRangeValidator.validate(userInputNumber);
    }

    public BaseballGameResult calculateResult() {
        BaseballGameResult baseballGameResult = resultCalculator.calculate(userInputNumber, randomNumber);

        this.end = baseballGameResult.isEnd();

        return baseballGameResult;
    }

    public boolean isThreeStrike() {
        return this.end;
    }

    public GameRestartStatus requestGameRestartChoice() {

        Integer inputNumber = userNumberInputReader.readRestartChoiceInput();
        if (GameRestartStatus.RESTART.isEqualStatusNumber(inputNumber)) {
            return GameRestartStatus.RESTART;
        }

        if (GameRestartStatus.END.isEqualStatusNumber(inputNumber)) {
            return GameRestartStatus.END;
        }

        throw new IllegalArgumentException("재 시작 값을 잘못 선택 했습니다. 게임을 종료합니다.");
    }

}