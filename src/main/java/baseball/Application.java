package baseball;

public class Application {
    public static void main(String[] args) {
        InstanceHandler instanceHandler = new InstanceHandler();

        MenuHandler menuHandler = instanceHandler.getMenuHandler();
        menuHandler.tryHandle();
    }
}
