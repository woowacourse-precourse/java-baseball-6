package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class GameNumber{
    private static final int GAME_NUMBER_LENGTH = 3;
    private final List<Integer> numbers;

    public GameNumber(){
        numbers = new ArrayList<>();
    }

    public void add(int num){
        if(validate(num) && size() < GAME_NUMBER_LENGTH){
            numbers.add(num);
            return;
        }
        throw new IllegalArgumentException();
    }

    public int get(int index){
        return numbers.get(index);
    }

    public int size(){
        return numbers.size();
    }

    public boolean validate(int number){
        return !numbers.contains(number);
    }

}
