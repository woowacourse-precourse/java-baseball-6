package baseball;

public class Player {
    private Count guess;


    public Player(Count guess) {
        this.guess = guess;
    }

    public void enterGuess(Count guess) {
        this.guess = guess;
    }

    public Count getGuess() {
        return guess;
    }
}

