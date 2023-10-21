package baseball.Model;

import java.util.List;

public class BaseBallGame {
    /**
     * Model은 Controller와 View에 관련된 코드가 있으면 안된다!!!!!!
     */
    private List<Integer> computerNumber;
    private NumberGenerator numberGenerator;
    private boolean isGameOver;

    private static final int BASEBALL_NUM_SIZE = 3;
    public BaseBallGame(NumberGenerator numberGenerator){
        this.numberGenerator = numberGenerator;
        computerNumber = numberGenerator.generatorComputerNumber();
    }
    public void playingGame(List<Integer> userInput){
        if(userInput.size() != BASEBALL_NUM_SIZE)
            throw new IllegalArgumentException("입력 자릿 수 오류");

    }
}
