package baseball;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    int restartStatus = 0;
    while (restartStatus == 0) {
      try {
        Play play = new Play();
        restartStatus = play.gameSet();
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
      }
    }
  }
}