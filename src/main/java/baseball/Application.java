package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MessageManager messageManager = new MessageManager();

        messageManager.showIntro();
        messageManager.getInput();
    }
}
