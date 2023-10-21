package baseball;

public class GameRestartOrQuit {

    private String restartOrQuitNumber;
    
    public GameRestartOrQuit(String restartOrQuitNumber) {
        validateRestartOrQuitNumber(restartOrQuitNumber);
        this.restartOrQuitNumber = restartOrQuitNumber;
    }

    public String getRestartOrQuitNumber() {
        return restartOrQuitNumber;
    }

    private void validateRestartOrQuitNumber(String number) {
        if ((!number.equals(Constants.GAME_RESTART)) && (!number.equals(Constants.GAME_QUIT))) {
            throw new IllegalArgumentException();
        }
    }
}
