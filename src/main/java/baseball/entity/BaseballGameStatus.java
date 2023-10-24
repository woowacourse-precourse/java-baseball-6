package baseball.entity;

enum BaseballGameStatus {

    PROGRESS, END;

    public boolean isEnd() {
        return this.equals(END);
    }
}
