package baseball;

import java.util.List;

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
    List<Integer> computer; // 랜덤 3자리 숫자
    List<Integer> player; // 사용자 입력 3자리 숫자
    List<Integer> gameResult; // [스트라이크, 볼] 값을 담은 리스트
    do {
      System.out.println("숫자 야구 게임을 시작합니다.");
      computer = baseballRandomNumber.generate();
      do {
        player = inputview.playerNumber();
        gameResult = baseballGame.evaluate(computer, player);
        outputview.printResult(gameResult.get(0), gameResult.get(1));
      } while (gameResult.get(0) != 3);
    } while (!inputview.getGameOver().equals("2"));
  }
}

