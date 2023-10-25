package baseball;

public class Player {
    private Note guess;


    public Player(Note guess) {
        this.guess = guess;
    }

    public Player(){
        this.guess = Note.writeDown("123");
    }

    public void enterGuess(Note guess) {
        this.guess = guess;
    }

    public Note getGuess() {
        return guess;
    }
}

