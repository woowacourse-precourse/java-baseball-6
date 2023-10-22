package model.system;

import static utils.GameConstant.INPUT_PROMPT_MESSAGE;

import java.util.List;
import model.player.Computer;
import model.player.User;
import model.referee.GameScoreboard;
import model.referee.Referee;
import utils.BaseballMessageConvertor;
import view.InputView;
import view.OutputView;

public class GameStarter {

    public GameScoreboard start(Computer computer) {
        List<Integer> userBaseballNumber = getUserBaseballNumber();
        User user = User.create(userBaseballNumber);

        Referee referee = Referee.create(user, computer);

        GameScoreboard gameResult = judgeGameScore(referee);
        return gameResult;
    }

    private GameScoreboard judgeGameScore(Referee referee) {
        GameScoreboard judgeScoreboard = referee.JudgeBaseBallGame();
        OutputView.write(judgeScoreboard);
        return judgeScoreboard;
    }

    private List<Integer> getUserBaseballNumber() {
        OutputView.write(INPUT_PROMPT_MESSAGE);
        String input = InputView.readInput();
        return BaseballMessageConvertor.convertInputToBaseballNumber(input);
    }

}
