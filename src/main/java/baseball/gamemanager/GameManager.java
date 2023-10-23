package baseball.gamemanager;

import baseball.input.UserNumberInputReader;
import baseball.property.BaseballGameProperty;
import baseball.random.RandomNumberGenerator;
import baseball.result.BallCountResult;
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

    this.end = false;
  }

  public void restart() {
    this.init();

    this.start();
  }

  public void start() {
    randomNumber = randomNumberGenerator.generateNumber();

    duplicateNumberValidator.validate(randomNumber);
    numberContainZeroValidator.validate(randomNumber);
    numberRangeValidator.validate(randomNumber);
  }

  public void requestUserInput() {
    userInputNumber = userNumberInputReader.readInput();

    duplicateNumberValidator.validate(userInputNumber);
    numberContainZeroValidator.validate(userInputNumber);
    numberRangeValidator.validate(userInputNumber);
  }

  public BallCountResult calculateResult() {

    return null;
  }

  public boolean isThreeStrike() {
    return this.end;
  }

  public int requestGameRestartChoice() {
    return userNumberInputReader.readRestartChoiceInput();
  }
}