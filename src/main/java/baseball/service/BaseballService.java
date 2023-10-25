package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumber;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Referee;
import baseball.dto.BaseballGameResultDto;
import baseball.repository.BaseballGameRepository;
import baseball.repository.RandomNumberGaneratorRepository;
import baseball.repository.RefereeRepository;

public class BaseballService {
    public BaseballGameResultDto judge(BaseballNumber baseballNumber) {
        Referee referee = RefereeRepository.find();
        BaseballGame baseballGame = BaseballGameRepository.find();
        return baseballGame.judge(baseballNumber, referee);
    }

    public void decideAnswer() {
        RandomNumberGenerator randomNumberGenerator = RandomNumberGaneratorRepository.find();
        Referee referee = RefereeRepository.find();
        referee.decideAnswer(randomNumberGenerator.generate());
    }
}
