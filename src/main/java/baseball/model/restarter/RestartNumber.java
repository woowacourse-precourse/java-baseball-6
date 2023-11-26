package baseball.model.restarter;

public class RestartNumber {

    private RestartState restartState;

    private RestartNumber(RestartState restartState) {
        this.restartState = restartState;
    }

    public static RestartNumber of(String input) {
        validateIsNumeric(input);
        RestartState restartState = RestartState.findState(Integer.parseInt(input));
        return new RestartNumber(restartState);
    }

    private static void validateIsNumeric(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEndGame() {
        return restartState == RestartState.END_GAME;
    }
}
