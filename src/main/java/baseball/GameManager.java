package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class GameManager {

    private List<Integer> answer;
    private List<Integer> inputList;
    private static final int ORIGINSIZE = 3;

    public GameManager() {
    }

    public void setAnswer(List<Integer> answer){
        this.answer=answer;
    }
    public void setInputList(String input){
        this.inputList = input.chars()
                .mapToObj(c -> Character.getNumericValue(c))
                .collect(Collectors.toList());;
    }

    public boolean isCorrect() {
        return getStrikeCount()==3;
    }

    public int getStrikeCount() {
        int strikeCount = 0;
        for (int i = 0; i < ORIGINSIZE; i++) {
            if (isSamePosition(i)) strikeCount++;
        }
        return strikeCount;
    }

    public int getBallCount() {
        int ballCount = 0;
        for (int i = 0; i < ORIGINSIZE; i++) {
            if (!isSamePosition(i) && isContainNumber(i)) ballCount++;
        }
        return ballCount;
    }

    public boolean isNothing() {
        return getBallCount() == 0 && getStrikeCount() == 0;
    }

    private boolean isSamePosition(int idx) {
        return answer.get(idx) == inputList.get(idx);
    }

    private boolean isContainNumber(int idx) {
        return answer.contains(inputList.get(idx));
    }

}
