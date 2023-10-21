package baseball;

public class MessagePusher {
    public void showMessage(Messages message) {
        System.out.print(message);
    }

    public void showMessage(GameProcessor gameProcessor, Messages message) {
        System.out.print(gameProcessor.getResult() + message);
    }
}
