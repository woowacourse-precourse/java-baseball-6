package baseball.model;

public class GameRestart {
    private String restartNum;

    public String getRetryNumber(){
        return restartNum;
    }

    public GameRestart(String number) {
        validateRestartNumber(number);
        this.restartNum = number;
    }

    public static void validateRestartNumber(String number) throws IllegalArgumentException {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("1또는 2를 입력해야 합니다.");
        }
    }

    public static boolean restart() {
        GameRestart gameRestart = new GameRestart(PlayerInputNumber.restartOrEnd());

        return gameRestart.getRetryNumber().equals("1");
    }
}
