package model.system;

import java.util.List;
import model.player.Computer;
import model.player.User;
import model.referee.GameScoreboard;
import model.referee.Referee;
import utils.BaseballNumberUtils;
import view.InputView;

public class GameStarter {

    GameStarter() {
    }

    public GameScoreboard start() {
        GameScoreboard gameScoreboard = new GameScoreboard();
        List<Integer> randomNumbers = BaseballNumberUtils.createRandomNumbers();
        Computer computer = Computer.create(randomNumbers);
        String input = InputView.ReadInput();
        if (BaseballNumberUtils.isValidBaseballNumber(input)) {
            List<Integer> baseballNumber = BaseballNumberUtils.createBaseballNumber(input);
            User user = User.create(baseballNumber);
            Referee referee = Referee.create(user, computer);
            gameScoreboard = referee.JudgeBaseBallGame();
        }
        return gameScoreboard;
    }

}
