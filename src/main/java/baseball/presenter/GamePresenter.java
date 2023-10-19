package baseball.presenter;

public class GamePresenter {
    private boolean isValidNumeric(String numbers) {
        return numbers.matches("^[0-9]+$");
    }

    private boolean isValidLength(String numbers) {
        return numbers.length() == 3;
    }
}
