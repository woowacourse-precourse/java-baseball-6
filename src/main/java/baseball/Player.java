package baseball;

public class Player {
    private Count guess;


    public Player(Count guess) {
        this.guess = guess;
    }

    public Player() {
        this.guess = Count.provideCount("123");
    }

    public void enterGuess(Count guess) {
        this.guess = guess;
    }

    public Count getGuess() {
        return guess;
    }
}

