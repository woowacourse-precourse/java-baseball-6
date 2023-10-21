package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> number;
    private static final int gameSize = 3;

    public Number() {
        number = new ArrayList<>();
    }

    public void add(int num) {
        number.add(num);
    }

    public int size(){
        return number.size();
    }

    public static int getGameSize(){
        return gameSize;
    }

    public boolean contains(int num) {
        return number.contains(num);
    }

    @Override
    public String toString() {
        return number.toString();
    }

    public Integer get(int index){
        return number.get(index);
    }
}
