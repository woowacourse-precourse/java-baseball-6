package baseball.model;

import java.util.List;

public class Player {
    private List<Integer> numbers;
    private int strikeCount = 0;
    private int ballCount = 0;


    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void addStrikeCount() {
        this.strikeCount++;
    }

    public void addBallCount() {
        this.ballCount++;
    }

    
}

