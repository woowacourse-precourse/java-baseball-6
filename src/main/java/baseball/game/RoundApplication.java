package baseball.game;

import baseball.domain.Balls;
import baseball.domain.Pitching;
import baseball.view.ApplicationConsole;

public class RoundApplication {

  private final ApplicationConsole console;

  public RoundApplication(ApplicationConsole console) {
    this.console = console;
  }

  public void start(Referee referee) {

    console.printGameStartMessage();

    do {
      // 4. 심판 객체의 필드(스트라이크, 볼) 개수 초기화
      referee.resetCount();
      // 5. 사용자의 추측 값 입력
      Balls guessBalls = new Balls(console.getUserGuess());
      // 6. 심판 객체에게 사용자 값 전달
        // 6.1 심판 객체는 자신이 가진 정답 값과 사용자의 입력값을 비교함
        // 6.2 비교 후 결과를 담은 Pitching 객체에게 결과 전달
      Pitching pitching = referee.matches(guessBalls);
      // 7. 결과 출력
      console.printGuessResult(pitching);
      // 8. 사용자가 세 개의 숫자를 다 맞출 때까지 계속 반복
    } while (!referee.isStrikeOut());
  }
}
