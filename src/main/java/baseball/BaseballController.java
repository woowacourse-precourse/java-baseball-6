package baseball;

/**
 * 게임을 시작, 재시작, 종료하는 기본 로직
 */


public class BaseballController {

  // Fields
  private final BaseballGame baseballGame;
  private final BaseballRandomNumber baseballRandomNumber;
  private final InputView inputview;
  private final OutputView outputview;


  // Constructor
  public BaseballController() {
    baseballGame = new BaseballGame();
    baseballRandomNumber = new BaseballRandomNumber();
    inputview = new InputView();
    outputview = new OutputView();
  }


  public void playBaseball() {

  }




}
