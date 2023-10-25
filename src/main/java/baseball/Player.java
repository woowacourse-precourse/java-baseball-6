package baseball;

public class Player {
    private Note guessNumber;


    public Player(Note guessNumber) {
        this.guessNumber = guessNumber;
    }

    public Player(){
        this.guessNumber = Note.writeDown("123");
    }

    public void writeGuessNumber(Note guess) {
        this.guessNumber = guess;
    }

    public Note getGuessNumber() {
        return guessNumber;
    }
}

