package baseball.domain;

public class Judgement {
    private boolean isNew = false;

    public boolean isNewGame() {
        return this.isNew;
    }

    public void updateGameStatus() {
        this.isNew = !this.isNew;
    }
}
