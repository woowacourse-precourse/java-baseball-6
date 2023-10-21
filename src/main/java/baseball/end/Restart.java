package baseball.end;

public class Restart {
    private Boolean restart;

    public Restart() {
        restart = true;
    }

    public Boolean getRestart() {
        return restart;
    }

    public void stop() {
        restart = false;
    }
}
