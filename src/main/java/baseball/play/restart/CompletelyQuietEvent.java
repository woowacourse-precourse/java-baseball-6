package baseball.play.restart;

public class CompletelyQuietEvent {
  private final String completelyQuietMessage;

  private CompletelyQuietEvent(String completelyQuietMessage) {
    this.completelyQuietMessage = completelyQuietMessage;
  }

  public static CompletelyQuietEvent of(String completelyQuietMessage) {
    return new CompletelyQuietEvent(completelyQuietMessage);
  }

  public String getCompletelyQuietMessage() {
    return completelyQuietMessage;
  }
}
