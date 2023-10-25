package baseball.game;

import baseball.domain.Balls;
import baseball.domain.BallsFactory;
import baseball.view.ApplicationConsole;
import baseball.view.Message;

public class BaseballGameApplication implements Runnable {

  private static final String YES = "1";
  private static final String NO = "2";
  private final ApplicationConsole console;


  public BaseballGameApplication(ApplicationConsole console) {
    this.console = console;
  }

  @Override
  public void run() {

    do {
      // 1. 서로 다른 세 제리인 정답 숫자 생성
      Balls answerBalls = BallsFactory.create();
      // 2. 심판 역할 객체에게 정답 숫자 전달
      Referee referee = new Referee(answerBalls);
      // 3. 사용자가 숫자를 추측해 맞추는 라운드 시작
      new RoundApplication(console).start(referee);
      console.printGameResult();

    } while (hasNextRound());
  }

  private boolean hasNextRound() {
    String response = console.getUserDecision();
    if (response.equals(YES)) {
      return true;
    }
    if (response.equals(NO)) {
      return false;
    }
    // 사용자가 1, 2가 아닌 값을 입력했을 때
    throw new IllegalArgumentException(Message.INVALID_INPUT);
  }
}
