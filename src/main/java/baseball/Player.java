package baseball;


public class Player {
    private NumberBoard numberBoard;

    public Player(NumberBoard numberBoard) {
        this.numberBoard = numberBoard;
    }

    public NumberBoard getNumberBoard() {
        return numberBoard;
    }

    public void setNumberBoard(NumberBoard numberBoard) {
        this.numberBoard = numberBoard;
    }
}
