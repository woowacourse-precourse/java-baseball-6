package baseball.game;

import baseball.BaseballNumber;
import baseball.PrintMessage;
import baseball.Rule;
import baseball.player.Computer;
import baseball.player.User;

public class Game implements Rule {
    private GameState state;
    private Computer computer;
    private User user;

    public Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
        state = new GameState();
    }

    public void play() {
        state.gameStart();
        while (state.isPlaying()) {
            computer.selectNumbers();
            guessNumber();
            state.askRegame();
        }
    }

    private void guessNumber() {
        boolean allStrike = false;
        while (!allStrike) {
            user.selectNumbers();
            GameResult result = testMatch();
            result.print();
            allStrike = result.isAllStrike();
        }
        PrintMessage.gameOver();
    }

    private GameResult testMatch() {
        int strike = 0;
        int nothing = 0;
        for (int index = 0; index < DIGIT_SIZE; index++) {
            BaseballNumber userNumber = user.numberOf(index);
            strike += computer.testStrike(index, userNumber);
            nothing += computer.testNothing(userNumber);
        }
        int ball = DIGIT_SIZE - strike - nothing;
        return new GameResult(strike, ball, nothing);
    }
}
