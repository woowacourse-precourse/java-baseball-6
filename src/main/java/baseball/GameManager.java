package baseball;

import java.util.List;

public class GameManager {

    private ResultMapper resultMapper;
    private boolean isGameOver

    public GameManager(ResultMapper resultMapper, boolean isGameOver) {
        this.resultMapper = resultMapper;
        this.isGameOver = false;
    }

    public void playGame(String readLine, List<Integer> computer) {
        Comparing comparing = new Comparing();

        while(!isGameOver) {
            Result result = comparing.compareNumbers(readLine, computer);
            String resultForUi = resultMapper.getResult(result.getEqualsNumber(), result.getEqualsPosition());

            isGameOver = result.getEqualsNumber() == 3 && result.getEqualsPosition() == 3;
        }
    }
}
