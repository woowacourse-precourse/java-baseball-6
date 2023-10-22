package baseball;

public class MenuHandler {
    private final Computer computer;
    private final Communicator communicator;

    public MenuHandler(Computer computer, Communicator communicator) {
        this.computer = computer;
        this.communicator = communicator;
        initialHandle();
    }

    private void initialHandle() {
        communicator.printStart();
        computer.decideAnswer();
    }
}
