package game;

public enum GameStatus {
    START,END;

    public boolean isOngoing() {
        return this.equals(START);
    }

    public boolean isFinish() {
        return this.equals(END);
    }

    }
