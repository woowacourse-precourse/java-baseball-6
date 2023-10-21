package baseball;

public class GameRestartOrQuit {

    private String restartOrQuitNumber;
    
    private GameRestartOrQuit(String restartOrQuitNumber) {
        validateRestartOrQuitNumber(restartOrQuitNumber);
        this.restartOrQuitNumber = restartOrQuitNumber;
    }

    public static GameRestartOrQuit from(String restartOrQuitNumber) {
        return new GameRestartOrQuit(restartOrQuitNumber);
    }

    public boolean isGameQuit() {
        return restartOrQuitNumber.equals(Constants.GAME_QUIT);
    }

    private void validateRestartOrQuitNumber(String number) {
        if ((!number.equals(Constants.GAME_RESTART)) && (!number.equals(Constants.GAME_QUIT))) {
            throw new IllegalArgumentException();
        }
    }
}
