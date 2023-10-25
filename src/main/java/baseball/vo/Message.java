package baseball.vo;

public final class Message {

    private final String message;

    public Message(String message) {
        this.message = message;
    }

    public Message makeNewGameResultMessage(String message) {
        return new Message(message);
    }

    public void printGameResultMessage() {
        System.out.println(message);
    }

    public boolean isResultMessageSameStrikeMessage(String strikeMessage) {
        return message.equals(strikeMessage);
    }
}
