package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Messages messages = new Messages();
        Game game = new Game();
        System.out.println(messages.START_MESSAGE);
        game.run();
    }
}
