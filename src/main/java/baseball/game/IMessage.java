package baseball.game;

public interface IMessage {

    String greetingMessage();

    String requestNumberMessage();

    String ballCountMessage();

    String strikeCountMessage();

    String nothingMessage();

    String gameOverMessage();

    String retryMessage();

    String retryErrorMessage();

    String inputNumberErrorMessage();

}
