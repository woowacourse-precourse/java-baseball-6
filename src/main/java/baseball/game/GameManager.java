package baseball.game;

import baseball.input.ConsoleInputReader;
import baseball.input.DuplicateNumberValidator;
import baseball.input.NumberContainZeroValidator;
import baseball.input.NumberRangeValidator;
import baseball.number.RandomNumberGenerator;
import baseball.property.BaseballGameProperty;

/**
 * @author 민경수
 * @description game manager
 * @since 2023.10.20
 **********************************************************************************************************************/
public class GameManager {

  private ConsoleInputReader consoleInputReader;
  private NumberRangeValidator numberRangeValidator;
  private DuplicateNumberValidator duplicateNumberValidator;
  private NumberContainZeroValidator numberContainZeroValidator;
  private RandomNumberGenerator randomNumberGenerator;
  private BaseballGameProperty baseballGameProperty;

  public GameManager() {
    this(new BaseballGameProperty(3, 1, 9));
  }


  public GameManager(BaseballGameProperty baseballGameProperty) {
    this.baseballGameProperty = baseballGameProperty;

    init();
  }

  public void init() {
    this.consoleInputReader = new ConsoleInputReader();
    this.numberRangeValidator = new NumberRangeValidator();
    this.duplicateNumberValidator = new DuplicateNumberValidator();
    this.numberContainZeroValidator = new NumberContainZeroValidator();
    this.randomNumberGenerator = new RandomNumberGenerator();
  }

  public void start() {
    System.out.println("숫자를 입력해 주세요 : ");
    Integer userInputNumber = consoleInputReader.readNumber();

    numberRangeValidator.validate(userInputNumber);
    duplicateNumberValidator.validate(userInputNumber);
    numberContainZeroValidator.validate(userInputNumber);

    int randomNumber = randomNumberGenerator.generateNumber();
    duplicateNumberValidator.validate(randomNumber);
    numberContainZeroValidator.validate(randomNumber);

  }

  public void restart() {
    this.init();
    this.start();
  }

}