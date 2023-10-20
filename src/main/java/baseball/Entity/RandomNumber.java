package baseball.Entity;

import java.util.List;

public class RandomNumber {
    private List<Character> randomNumberList;

    public RandomNumber(List<Character> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    public List<Character> getRandomNumberList(){
        return randomNumberList;
    }

}
