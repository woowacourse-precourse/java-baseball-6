package baseball.ui;

public class UIFacade {

    private final InputUserInterface inputUI;
    private final OutputUserInterface outputUI;

    public UIFacade(InputUserInterface inputUI, OutputUserInterface outputUI) {
        this.inputUI = inputUI;
        this.outputUI = outputUI;
    }

    public void print(String output) {
        outputUI.print(output);
    }

    public String intercept() {
        return inputUI.intercept();
    }
}
