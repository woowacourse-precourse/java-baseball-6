package baseball.presenter;

public class GamePresenter {
    private boolean isValidNumeric(String numbers) {
        return numbers.matches("^[0-9]+$");
    }
}
