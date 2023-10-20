package baseball.Model;

import java.util.List;

public class BaseBallGame {
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
