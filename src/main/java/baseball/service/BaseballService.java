package baseball.service;

import baseball.commom.constants.GameCommand;
import baseball.domain.Game;
import baseball.domain.BaseballNumber;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Referee;
import baseball.dto.GameResultDto;
import baseball.repository.GameRepo;
import baseball.repository.RandomNumberGeneratorRepo;
import baseball.repository.RefereeRepo;

import java.util.List;

public class BaseballService {

    public GameResultDto judge(BaseballNumber baseballNumber) {
        Referee referee = RefereeRepo.find();
        Game game = GameRepo.find();
        return game.judge(baseballNumber, referee);
    }

    public void decideAnswer() {
        RandomNumberGenerator randomNumberGenerator = RandomNumberGeneratorRepo.find();
        Referee referee = RefereeRepo.find();
        referee.decideAnswer(randomNumberGenerator.generate());
    }

    public void processRestartMode(GameCommand command) {
        Game game = GameRepo.find();
        if (command.equals(GameCommand.RESTART))
            game.restart();
    }

    public boolean isGameEnd() {
        Game game = GameRepo.find();
        return game.isGameEnd();
    }
}
