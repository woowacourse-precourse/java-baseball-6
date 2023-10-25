package baseball.enumeration;

public enum GameRestartStatus {

    RESTART(1), END(2);

    private Integer statusNumber;

    GameRestartStatus(Integer statusNumber) {
        this.statusNumber = statusNumber;
    }

    public Integer getStatusNumber() {
        return this.statusNumber;
    }

    public boolean isEqualStatusNumber(Integer statusNumber) {
        return this.statusNumber.equals(statusNumber);
    }

}
