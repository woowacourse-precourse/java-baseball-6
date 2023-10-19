package baseball.domain.ball;

public enum GameStatus {
  REPLAY("1"),
  EXIT("2");

  private final String input;

  GameStatus(final String input) {
    this.input = input;
  }

  public static GameStatus of(final String input) {
    if ("1".equals(input)) {
      return REPLAY;
    }
    if ("2".equals(input)) {
      return EXIT;
    }
    throw new IllegalArgumentException("GameStatus는 반드시 1, 2 중 하나를 입력해서 만들 수 있습니다.");
  }
}
