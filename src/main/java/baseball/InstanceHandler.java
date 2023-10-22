package baseball;

public class InstanceHandler {
    private final MenuHandler menuHandler;

    public InstanceHandler() {
        menuHandler = generateMenuHandler();
    }

    private Computer generateComputer() {
        return new Computer();
    }

    private Communicator generateCommunicator() {
        return new Communicator();
    }

    private MenuHandler generateMenuHandler() {
        return new MenuHandler(generateComputer(), generateCommunicator());
    }

    public MenuHandler getMenuHandler() {
        return menuHandler;
    }
}
