package baseball.service;

import baseball.constants.AppConstants;
import baseball.model.GameScoreDTO;
import java.util.List;
import java.util.Objects;
public class GameService {
    private final List<Integer> computerInput;
    private final List<Integer> userInput;
    private final int DIGIT_LIMIT;

    public GameService(List<Integer> computer, List<Integer> userInput) {
        this.computerInput = computer;
        this.userInput = userInput;
        this.DIGIT_LIMIT = AppConstants.NUM_DISIT_LIMIT;
    }

    public GameScoreDTO calculate() {
        GameScoreDTO gameScoreDTO = new GameScoreDTO();
        calculateScore(gameScoreDTO);
        return gameScoreDTO;
    }

    private void calculateScore(GameScoreDTO gameScoreDTO) {
        calculateStrikes(gameScoreDTO);
        calculateBalls(gameScoreDTO);
    }

    private void calculateStrikes(GameScoreDTO gameScoreDTO) {
        for (int i = 0; i < DIGIT_LIMIT; i++) {
            if (Objects.equals(computerInput.get(i), userInput.get(i))) {
                gameScoreDTO.setAddStrike();
            }
        }
    }
    private void calculateBalls(GameScoreDTO gameScoreDTO) {
        for (int i = 0; i < DIGIT_LIMIT; i++) {
            for (int j = 0; j < DIGIT_LIMIT; j++) {
                if (Objects.equals(computerInput.get(i), userInput.get(j))) {
                    if (i != j) {
                        gameScoreDTO.setAddBall();
                    }
                }
            }
        }
    }
}
