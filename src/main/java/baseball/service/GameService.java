package baseball.service;

import baseball.domain.Player;
import baseball.domain.RandomCreator;
import baseball.domain.Referee;
import baseball.domain.SystemRandomCreator;
import baseball.response.GameResponse;
import java.util.List;

public class GameService {

    private static final GameService instance = new GameService();
    private final Referee referee;
    private final RandomCreator randomCreator;

    private Player user;
    private Player computer;

    public static GameService getInstance() {
        return instance;
    }

    public GameService() {
        this.referee = Referee.getInstance();
        this.randomCreator = SystemRandomCreator.getInstance();
    }

    public GameService(RandomCreator randomCreator) {
        this.referee = Referee.getInstance();
        this.randomCreator = randomCreator;
    }

    public void initializeGame() {
        user = new Player();
        computer = new Player(randomCreator.createRandomNumbers());
    }

    public GameResponse playGame(List<Integer> input) {
        user.setNumbers(input);
        referee.playGame(user, computer);
        return referee.toResponse();
    }
}
