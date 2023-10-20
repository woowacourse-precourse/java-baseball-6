package baseball;

public class GameRestartOrQuit {

    private static final String GAME_RESTART = "1";
    private static final String GAME_QUIT = "2";
    private String restartOrQuitNumber;
    
    public GameRestartOrQuit(String restartOrQuitNumber) {
        validateRestartOrQuitNumber(restartOrQuitNumber);
        this.restartOrQuitNumber = restartOrQuitNumber;
    }

    public String getRestartOrQuitNumber() {
        return restartOrQuitNumber;
    }

    private void validateRestartOrQuitNumber(String number) {
        if (!number.equals(GAME_RESTART) && !number.equals(GAME_QUIT)) {
            throw new IllegalArgumentException();
        }
    }
}
