package baseball.ui;

public class UIFacade {

    private final InputUserInterface inputUI;
    private final OutputUserInterface outputUI;

    public UIFacade(InputUserInterface inputUI, OutputUserInterface outputUI) {
        this.inputUI = inputUI;
        this.outputUI = outputUI;
    }

    public void rendering(String output) {
        outputUI.rendering(output);
    }

    public String intercept() {
        return inputUI.intercept();
    }
}
