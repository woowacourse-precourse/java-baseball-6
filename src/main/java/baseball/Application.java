package baseball;

public class Application {
    public static void main(String[] args) {
        Checker checker = new Checker();
        Player palyer = new Player();
        Controller controller = new Controller(checker, palyer);

        controller.startGame();
    }
}
