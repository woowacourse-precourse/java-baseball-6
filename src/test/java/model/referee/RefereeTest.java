package model.referee;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import model.player.Computer;
import model.player.User;
import org.junit.jupiter.api.Test;

class RefereeTest {

    private ArrayList<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
    private Computer computer = Computer.create(computerNumbers);

    @Test
    void judgeBaseBallGame_threeStrike() {
        User threeStrikeUser = User.create(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Referee referee = Referee.create(threeStrikeUser, computer);

        GameScoreboard gameScoreboard = referee.JudgeBaseBallGame();

        assertThat(gameScoreboard.isThreeStrike()).isEqualTo(true);
        assertThat(gameScoreboard.getBall()).isEqualTo(0);
        assertThat(gameScoreboard.getStrike()).isEqualTo(3);

    }

    @Test
    void judgeBaseBallGame_nothing() {
        User nothingUser = User.create(new ArrayList<>(Arrays.asList(4, 5, 6)));
        Referee referee = Referee.create(nothingUser, computer);
        GameScoreboard gameScoreboard = referee.JudgeBaseBallGame();

        assertThat(gameScoreboard.getBall()).isEqualTo(0);
        assertThat(gameScoreboard.getStrike()).isEqualTo(0);

    }

    @Test
    void judgeBaseBallGame_oneBallOneStrike() {
        User oneBallOneStrikeUser = User.create(new ArrayList<>(Arrays.asList(1, 3, 6)));
        Referee referee = Referee.create(oneBallOneStrikeUser, computer);

        GameScoreboard gameScoreboard = referee.JudgeBaseBallGame();

        assertThat(gameScoreboard.getBall()).isEqualTo(1);
        assertThat(gameScoreboard.getStrike()).isEqualTo(1);

    }

    @Test
    void judgeBaseBallGame_twoBall() {
        User twoBallUser = User.create(new ArrayList<>(Arrays.asList(2, 3, 6)));
        Referee referee = Referee.create(twoBallUser, computer);

        GameScoreboard gameScoreboard = referee.JudgeBaseBallGame();

        assertThat(gameScoreboard.getBall()).isEqualTo(2);
        assertThat(gameScoreboard.getStrike()).isEqualTo(0);

    }
}