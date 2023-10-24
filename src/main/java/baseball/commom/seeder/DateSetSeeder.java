package baseball.commom.seeder;

import baseball.domain.Game;
import baseball.domain.GameState;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Referee;
import baseball.repository.GameRepo;
import baseball.repository.RandomNumberGeneratorRepo;
import baseball.repository.RefereeRepo;

public class DateSetSeeder {

    public void seed() {
        GameRepo.save(new Game(GameState.PLAY));
        RefereeRepo.save(new Referee());
        RandomNumberGeneratorRepo.save(new RandomNumberGenerator());
    }
}
