package baseball.Model;

import java.util.ArrayList;
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
        computerNumber = numberGenerator.generatorComputerNumber(BASEBALL_NUM_SIZE);
        isGameOver = false;
    }
    public void playingGame(List<Integer> userInput){
        if(userInput.size() != BASEBALL_NUM_SIZE)
            throw new IllegalArgumentException("입력 자릿 수 오류");

    }

    /**
     * 게임이 현재 끝난 상태인지 반환함
     */
    public boolean isGameOver() {
        return isGameOver;
    }
    /**
     * 유저가 입력한 String형식의 Input을 List형식으로 파씽함
     */
    public List<Integer> parseUserInput(String input) {
        List<Integer> parsedInput = new ArrayList<>();

        if (input.length() != BASEBALL_NUM_SIZE) {
            throw new IllegalArgumentException("입력 자릿 수 오류");
        }

        for (int i = 0; i < BASEBALL_NUM_SIZE; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                parsedInput.add(digit);
            }
            if (!Character.isDigit(c))
                throw new IllegalArgumentException("허가되지 않은 문자열");

        }

        return parsedInput;
    }
}
