package baseball;


public enum GameMessage {
  NOTHING("낫싱"),
  BALL("볼"),
  STRIKE("스트라이크");

  private final String message;

  GameMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
