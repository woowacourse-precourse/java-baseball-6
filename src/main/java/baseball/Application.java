package baseball;

public class Application {
    public static void main(String[] args) {
        DiContainer diFactory = new DiContainer();
        ComputerController computerController = diFactory.computerController();
        computerController.run();
    }
}
