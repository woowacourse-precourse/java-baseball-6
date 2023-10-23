package baseball;

public class NumberBaseball {
    private Status status;
    private Message message;

    public NumberBaseball() {
        this.status = Status.START;
        this.message = Message.START_MESSAGE;
    }

    public void printMessage() {
        System.out.print(message.getMessage());
    }
}
