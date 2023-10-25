package baseball;

import baseball.controller.ValidationController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidationControllerTest {

    private ValidationController validationController;

    @BeforeEach
    public void setUp() {
        validationController = new ValidationController();
    }

    @Test
    public void 올바른_값을_입력했을때() {
        String validInput = "612";

        validationController.validateInput(validInput);
    }
}
