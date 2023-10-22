package baseball.legacy.game;

import java.util.ArrayList;
import java.util.List;

import baseball.legacy.baseballnumber.BaseBallNumber;
import baseball.legacy.input.ConsoleInputReader;
import baseball.legacy.input.DuplicateNumberValidator;
import baseball.legacy.input.NumberContainZeroValidator;
import baseball.legacy.input.NumberRangeValidator;
import baseball.legacy.number.RandomNumberGenerator;
import baseball.legacy.property.BaseballGameProperty;

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

  private int randomNumber;
  private boolean end;


  public GameManager() {
    this(new BaseballGameProperty(3, 1, 9));
  }


  public GameManager(BaseballGameProperty baseballGameProperty) {
    this.baseballGameProperty = baseballGameProperty;

    init();
  }

  public void init() {
    this.consoleInputReader = new ConsoleInputReader();
    this.numberRangeValidator = new NumberRangeValidator(baseballGameProperty);
    this.duplicateNumberValidator = new DuplicateNumberValidator();
    this.numberContainZeroValidator = new NumberContainZeroValidator();
    this.randomNumberGenerator = new RandomNumberGenerator(baseballGameProperty);

    this.end = false;
  }

  public void start() {
    // 랜덤 숫자 생성
    randomNumber = Integer.parseInt(
      java.util.Arrays.stream(randomNumberGenerator.generateValidRandomNumber())
        .mapToObj(String::valueOf)
        .reduce("", (a, b) -> a + b)
    );

  }

  private void printInputRequestMessage() {
    System.out.println("숫자를 입력해 주세요 : ");
  }

  private int getUserInput() {
    // 유저에게 숫자 입력요청
    return consoleInputReader.readNumber();
  }

  private List<BaseBallNumber> generateBaseBallNumberList(int number) {
    List<BaseBallNumber> baseBallNumberList = new ArrayList<>();

    String stringNumber = String.valueOf(number);
    for (int i = 0; i < stringNumber.length(); i++) {
      BaseBallNumber baseBallNumber = new BaseBallNumber(Character.getNumericValue(stringNumber.charAt(i)), i);
      baseBallNumberList.add(baseBallNumber);
    }

    return baseBallNumberList;
  }

  public void validation(int number) {
    duplicateNumberValidator.validate(number);
    numberContainZeroValidator.validate(number);
    numberRangeValidator.validate(number);
  }

  public void test() {

    printInputRequestMessage();
    // 유저에게 숫자 입력요청
    int userInputNumber = getUserInput();
    validation(userInputNumber);

    // 각 숫자와 자릿수를 따로 담고 있는 객체 생성

    List<BaseBallNumber> randomBaseBallNumberList = generateBaseBallNumberList(randomNumber);

    List<BaseBallNumber> userInputBaseBallNumberList = generateBaseBallNumberList(userInputNumber);

    int strike = 0;
    int ball = 0;
    int nothing = 0;
    // 유저가 입력한 수의 첫번쨰 수부터 랜덤 생성한 수와의 스트라이크, 볼, 낫싱을 비교
    for (BaseBallNumber userBaseBallNumber : userInputBaseBallNumberList) {
      for (BaseBallNumber randomBaseBallNumber : randomBaseBallNumberList) {

        // 숫자도 같고 인덱스도 같다면 스트라이크
        if (userBaseBallNumber.number() == randomBaseBallNumber.number() && userBaseBallNumber.index() == randomBaseBallNumber.index()) {
          // 스트라이크
          strike += 1;
          break;
        }

        // 숫자는 같고 인덱스가 다르다면 볼
        if (userBaseBallNumber.number() == randomBaseBallNumber.number() && userBaseBallNumber.index() != randomBaseBallNumber.index()) {
          // 볼
          ball += 1;
          break;
        }
      }
      nothing += 1;
    }

    if (strike == 3) {
      // 게임 종료 혹은 재시작 여부 확인
      end = true;
      //      System.out.println("리겜?");
      //      int restartStatus = consoleInputReader.readNumber();
      //
      //      if (restartStatus == 1) {
      //        //리겜
      //      }
      //      // 종료
    }

    if (ball > 0) {
      System.out.print(ball + "볼 ");
    }

    if (strike > 0) {
      System.out.print(strike + "스트라이크 ");
    }


    if (nothing > 0 && (strike == 0 && ball == 0)) {
      System.out.print("낫싱 ");
    }

  }

  public void restart() {
    this.init();
    this.start();
  }

  public int requestReplayGameChoice() {
    System.out.println("게임 재시작? 1 예스, 2 종료");
    return getUserInput();
  }

  public boolean isEnd() {
    return end;
  }

  public void setEnd(boolean end) {
    this.end = end;
  }
}