package baseball.service;

import baseball.domain.BallCounter;
import baseball.domain.Balls;

import java.util.List;

public class GameService {

    private final BallsGenerator ballsGenerator;

    private final Referee referee;

    public GameService() {
        this.ballsGenerator = new BallsGenerator();
        this.referee = new Referee();
    }

    public List<Balls> generateComputerNumbers() {
        return ballsGenerator.generateComputerNumbers();
    }

    public BallCounter judgeGames(List<Balls> computerNumbers, List<Balls> playerBalls) {
        return referee.judgeGame(computerNumbers, playerBalls);
    }

    public boolean isEndGameCondition(BallCounter ballCounter) {
        return referee.isEndGameCondition(ballCounter);
    }

}
