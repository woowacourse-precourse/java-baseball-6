package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MessageManager messageManager = new MessageManager();
        Data data = new Data();
        GameProcessor gameProcessor = new GameProcessor();

        messageManager.showIntro();
        data.setInputData(messageManager.getInputResponse());
        System.out.println(data.getInputData());

        gameProcessor.IllegalArgumentException(data);

        int[] randomNumberRanage = {1, 9};
        System.out.println(randomNumberRanage[0] + randomNumberRanage[1]);
    }
}
