package baseball;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    BaseballGame baseballGame = new BaseballGame();
    System.out.println("숫자 야구 게임을 시작합니다.");
    while (true) {
      baseballGame.startGame();  // 게임 시작
      if (!baseballGame.reStartGame()) {  // 재시작 여부
        return;
      }
    }
  }
}
