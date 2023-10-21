package baseball.generator;

import java.util.List;

public class ComputerRandomNumber {
    private final List<Integer> randomNumberList;

    public static final Integer NOT_FOUND = -1;

    public ComputerRandomNumber(List<Integer> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    public Integer indexOf(Integer number){
        if(randomNumberList.contains(number)){
            return randomNumberList.indexOf(number);
        }
        return NOT_FOUND;
    }

    public Integer size(){
        return randomNumberList.size();
    }

    public List<Integer> getRandomNumberList(){
        return randomNumberList;
    }

}
