package baseball.game;

import baseball.BaseballNumber;
import baseball.Rule;
import baseball.player.Computer;
import baseball.player.User;

public class Game implements Rule {
    private final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

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
        System.out.println(GAME_OVER_MESSAGE);
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
