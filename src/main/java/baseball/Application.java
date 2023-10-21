package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MessageManager messageManager = new MessageManager();
        Data data = new Data();

        messageManager.showIntro();
        data.setInputData(messageManager.getInputResponse());
        System.out.println(data.getInputData());
    }
}
