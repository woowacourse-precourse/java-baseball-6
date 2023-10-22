package baseball.model;


public class Game {

    private GameNumbers userGameNumbers;
    private GameNumbers computerGameNumbers;
    private Result result;

    public void updateUserNumbers(GameNumbers userGameNumbers) {
        this.userGameNumbers = userGameNumbers;
    }
}
