package baseball;

public class InstanceHandler {
    private final Computer computer;
    private final MenuHandler menuHandler;

    public InstanceHandler() {
        this.computer = generateComputer();
        menuHandler = generateMenuHandler();
    }

    private Computer generateComputer() {
        return new Computer();
    }

    private MenuHandler generateMenuHandler() {
        return new MenuHandler(computer);
    }

    public MenuHandler getMenuHandler() {
        return menuHandler;
    }
}
