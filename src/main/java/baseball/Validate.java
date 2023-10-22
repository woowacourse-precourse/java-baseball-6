package baseball;

public interface Validate {

    boolean combinedValidation(String input);

    boolean validateInputType(String input);

    boolean validateInputLength(String input, int expectedLength);

    boolean validationReplayInput(String input);
}
