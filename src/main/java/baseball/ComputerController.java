package baseball;

public class ComputerController {

    private final View view;
    private final Validate validation;

    public ComputerController(View view, Validate validation) {
        this.view = view;
        this.validation = validation;
    }

    public void run() {
        if (validation.validatedInput()) {
            view.renderResult();
        }
    }
}

