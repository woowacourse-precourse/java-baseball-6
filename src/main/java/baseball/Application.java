package baseball;


import baseball.view.SystemMessage;
public class Application {
    public static void main(String[] args) {
        SystemMessage systemMessage = new SystemMessage();
        Controller controller = new Controller();
        systemMessage.startGreeting();
        controller.run();
    }
}

