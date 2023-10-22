package baseball;

public class Player {
    private Count guess;


    private Player(Count guess) {
        this.guess = guess;
    }

    public static Player enterGuess(Count guess) {
        return new Player(guess);
    }

}

