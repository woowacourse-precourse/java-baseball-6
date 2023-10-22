package baseball;

public class MenuHandler {
    private final Computer computer;

    public MenuHandler(Computer computer) {
        this.computer = computer;
        initialHandle();
    }

    private void initialHandle() {
        computer.decideAnswer();
    }
}
