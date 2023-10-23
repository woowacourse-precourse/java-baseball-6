package baseball;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        MenuHandler menuHandler = new MenuHandler(computer);
        menuHandler.tryHandle();
    }
}
