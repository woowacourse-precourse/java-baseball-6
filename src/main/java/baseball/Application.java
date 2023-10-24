package baseball;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    System.out.println("숫자 야구 게임을 시작합니다.");

    Application app = new Application();

    while (app.playNumberBaseball());
  }

  private boolean playNumberBaseball() {
    boolean isContinue = true;

    Computer numsToGuess = new Computer();

    User numsForCompare = new User();

    do {

      numsForCompare.getUserGuessNum();

    } while (!numsToGuess.compare(numsForCompare.getNumsToCompare()));

    isContinue = numsForCompare.getUserContinue();

    return isContinue;
  }

}
