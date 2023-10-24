package model.referee;

import static utils.GameConstant.BASEBALL_GAME_NUMBER_LENGTH;

import model.player.Computer;
import model.player.User;

public class Referee {
    private final User user;
    private final Computer computer;

    private Referee(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }


    public static Referee create(User user, Computer computer) {
        return new Referee(user, computer);
    }

    public GameScoreboard JudgeBaseBallGame() {
        GameScoreboard gameScoreboard = new GameScoreboard();
        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            if (computer.getNumberByPosition(i) == user.getNumberByPosition(i)) {
                gameScoreboard = gameScoreboard.incrementStrike();
            } else if (computer.isContainsNumber(user.getNumberByPosition(i))) {
                gameScoreboard = gameScoreboard.incrementBall();
            }
        }
        return gameScoreboard;
    }
}
