package baseball;

public enum BaseBall {

    BALL("볼"), NOTHING("낫싱"), STRIKE("스트라이크");

    private final String command;


    BaseBall(String command) {
        this.command = command;
    }

    public String command() {
        return command;
    }
}
