package baseball;

import baseball.domain.BaseBallGame;
import baseball.domain.BaseBallNumberGenerator;
import baseball.domain.ComputerPlayer;
import baseball.domain.MatchPlayer;
import baseball.domain.RandomBaseBallNumberGenerator;
import baseball.domain.SingleBaseBallGame;

public class Application {
    public static void main(String[] args) {
        final BaseBallNumberGenerator numberGenerator = new RandomBaseBallNumberGenerator();
        final MatchPlayer matchPlayer = new ComputerPlayer(numberGenerator);
        final BaseBallGame singleBaseBallGame = new SingleBaseBallGame(matchPlayer);
    }
}
