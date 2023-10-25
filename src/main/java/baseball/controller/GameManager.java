package baseball.controller;

import baseball.constants.AppConstants;
import baseball.model.GameScoreDTO;
import baseball.service.GameService;
import baseball.view.GameIO;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final int DIGIT_LIMIT;
    private List<Integer> computer;
    private GameIO gameIO;

    public GameManager(GameIO gameIO) {
        this.gameIO = gameIO;
        this.computer = new ArrayList<>();
        DIGIT_LIMIT = AppConstants.NUM_DISIT_LIMIT;
    }

    public void gameStart() {
        gameIO.printStartGame();
        initializeNewGame();
        UserInputHandler userInputHandler = new UserInputHandler(this, gameIO);
        GameScoreDTO gameScoreDTO;
        do {
            List<Integer> user = userInputHandler.getUserInput();
            GameService baseballService = new GameService(computer, user);
            gameScoreDTO = baseballService.calculate();
            checkScore(gameScoreDTO);
        } while (userInputHandler.isContinueGame(gameScoreDTO));
    }

    public void initializeNewGame() {
        computer = generateRandomNumbers();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DIGIT_LIMIT) {
            int randomNumber = Randoms.pickNumberInRange(AppConstants.NUM_BEGIN_RANGE, AppConstants.NUM_END_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private void checkScore(GameScoreDTO gameScoreDTO) {
        int strike = gameScoreDTO.getStrike();
        int ball = gameScoreDTO.getBall();

        if (strike == 3) {
            gameIO.printTreeStrike();
            gameScoreDTO.setGameOver(true);
        } else if (strike > 0 && ball > 0) {
            gameIO.printBallAndStrike(ball, strike);
        } else if (strike > 0) {
            gameIO.printStrike(strike);
        } else if (ball > 0) {
            gameIO.printBall(ball);
        } else if (ball == 0 && strike == 0) {
            gameIO.printNoting();
        }
    }
}
