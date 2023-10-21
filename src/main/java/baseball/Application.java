package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MessageManager messageManager = new MessageManager();
        Data data = new Data();
        GameProcessor gameProcessor = new GameProcessor();

        messageManager.showIntro();
        data.setInputData(messageManager.getInputResponse());

        gameProcessor.IllegalArgumentException(data);

    }
}
